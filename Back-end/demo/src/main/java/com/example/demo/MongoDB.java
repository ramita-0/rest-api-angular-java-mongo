package com.example.demo;

import com.mongodb.MongoClient;
import com.mongodb.client.*;
import org.bson.Document;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
class MongoDB {
    private MongoDatabase baseDeDatos;
    private MongoCollection coleccion;
    private String host;
    private int puerto;

    public MongoDB() {
        this.host="localhost";
        this.puerto=27017;
        //cambiar BAR a minusculas (bar)
        this.conectar("bar");
    }


    public void conectar(String baseDeDatos){ this.conectarABaseDeDatos(baseDeDatos); }

    public void conectarAColeccionUnica(String coleccion){
        this.conectarAColeccion(coleccion);
    }

    public MongoDatabase getBaseDeDatos() {
        return baseDeDatos;
    }

    public void setBaseDeDatos(MongoDatabase baseDeDatos) {
        this.baseDeDatos = baseDeDatos;
    }

    public MongoCollection getColeccion() {
        return coleccion;
    }

    public void setColeccion(MongoCollection coleccion) {
        this.coleccion = coleccion;
    }

    public void conectarABaseDeDatos(String nombreBaseDeDatos){
        MongoClient mongo = new MongoClient("localhost",27017);
        this.baseDeDatos = mongo.getDatabase(nombreBaseDeDatos);
    }

    public void conectarAColeccion(String nombreDeColeccion){
        if (this.existeLaColeccion(nombreDeColeccion)){
            this.coleccion = baseDeDatos.getCollection(nombreDeColeccion);
        } else {
            baseDeDatos.createCollection(nombreDeColeccion);
            this.coleccion = baseDeDatos.getCollection(nombreDeColeccion);
        }
    }

    public boolean existeLaColeccion(String nombreDeColeccion){
        MongoIterable<String> nombresDeColecciones = baseDeDatos.listCollectionNames();
        boolean existe = false;

        for (String nombre : nombresDeColecciones) {
            if (nombre.equals(nombreDeColeccion)){
                existe = true;
            }
        }
        return existe;
    }

    //funciona
    //terminado y funcional
    public HashMap<String,Object> obtenerBebidas(){
        HashMap<String,Object> datos = new HashMap<>();
        ArrayList<Bebida> bebidas = new ArrayList<>();
        FindIterable resultado = coleccion.find();
        MongoCursor iterador = resultado.iterator();


        while (iterador.hasNext()) {
            Document documento = (Document) iterador.next();
            String nombre = documento.getString("nombre");
            String marca = documento.getString("marca");
            int precio = documento.getInteger("precio");
            String tipo = documento.getString("tipo");
            int cantidad= documento.getInteger("cantidad");

            Document info = (Document) documento.get("info");
            boolean alcohol = info.getBoolean("alcohol");
            String descripcion = info.getString("descripcion");

            boolean artesanal;
            double graduacion;
            String color;
            double ibu;

            switch (tipo){
                case "Gaseosa":
                    BebidaNoAlcoholica bebidaNoAlcoholica = new BebidaNoAlcoholica(nombre,marca,tipo,cantidad,precio,descripcion,alcohol);
                    bebidas.add(bebidaNoAlcoholica);
                    break;

                case "Aperitivo":
                    artesanal = info.getBoolean("artesanal");
                    graduacion = info.getDouble("graduacion");
                    Aperitivo aperitivo = new Aperitivo(descripcion, nombre, marca, tipo, cantidad, precio, alcohol, artesanal, graduacion);
                    bebidas.add(aperitivo);
                    break;

                case "Cerveza":
                    artesanal = info.getBoolean("artesanal");
                    graduacion = info.getInteger("graduacion");
                    color = info.getString("color");
                    ibu = info.getDouble("ibu");
                    Cerveza cerveza = new Cerveza(color, ibu, descripcion, nombre, marca, tipo, cantidad, precio, alcohol, artesanal, graduacion);
                    bebidas.add(cerveza);
                    break;
            }
        }
        datos.put("Bebidas",bebidas);
        return datos;
    }

    // terminado, falta comprobar si funciona
    public void insertarBebida(HashMap<String,String> bebida){
        Document nuevoDocumento = new Document();
        Document info = new Document();

        nuevoDocumento.append("nombre", bebida.get("nombre"));
        nuevoDocumento.append("marca", bebida.get("marca"));
        nuevoDocumento.append("tipo", bebida.get("tipo"));
        nuevoDocumento.append("precio", Integer.parseInt(bebida.get("precio")));
        nuevoDocumento.append("cantidad", Integer.parseInt(bebida.get("cantidad")));

        info.append("alcohol", Boolean.parseBoolean(bebida.get("cantidad")));
        info.append("artesanal", Boolean.parseBoolean(bebida.get("artesanal")));

        if (bebida.get("tipo").equals("cerveza") || bebida.get("tipo").equals("aperitivo")){
           info.append("graduacion", Integer.parseInt(bebida.get("graduacion")));
        }

        info.append("descripcion", bebida.get("descripcion"));

        nuevoDocumento.append("info",info);
        coleccion.insertOne(nuevoDocumento);
    }

    //hacer llamadas http para probarlos!
    public int obtenerStock(String nombre){
        String json = "{ nombre : { $eq : '"+nombre+"' } }";
        Document filtro = Document.parse(json);
        FindIterable resultado = coleccion.find(filtro);
        MongoCursor iterador = resultado.iterator();

        int cantidad=0;
        while (iterador.hasNext()){
            Document documento = (Document) iterador.next();
            cantidad = documento.getInteger("cantidad");
        }
        return cantidad;
    }

    public void actualizarStockBebida(String nombre, int cantidadASumar){
        String json = "{ nombre: { $eq : '"+nombre+"' } }";
        Document filtro = Document.parse(json);
        int valorNuevoCantidad = cantidadASumar + this.obtenerStock(nombre);

        json = "{ $set: { cantidad :"+valorNuevoCantidad+" } }";
        Document nuevosValores = Document.parse(json);
        coleccion.updateOne(filtro, nuevosValores);
    }


    //estos metodos no los contemplamos en el tp, pero los hicimos de igual manera, se utilizarian en la app final
    // metodos para relizar Baja de la base de bebidas (no es lo mismo que realizar venta)
    // (los implementamos pero no estan usados en el tp)
    public void eliminarBebida(String nombre){
        String json = "{ nombre: { $eq: '"+nombre+"' } }";
        Document filtro = Document.parse(json);
        coleccion.deleteOne(filtro);
    }

    public void eliminarVariasBebidas(String nombre){
        String json = "{ nombre: { $eq: '"+nombre+"' } }";
        Document filtro = Document.parse(json);
        coleccion.deleteMany(filtro);
    }


    /**
     * documentación de clase Document
     * http://mongodb.github.io/mongo-java-driver/3.6/javadoc/org/bson/Document.html
     */
}
