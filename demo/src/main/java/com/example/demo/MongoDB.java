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
        this.conectar("bar", "bebidas");

    }

    public void conectar(String baseDeDatos,String coleccion){
        this.conectarABaseDeDatos(baseDeDatos);
        this.conectarAColeccion(coleccion);
    }

    public void conectarAColeccionUnica(String coleccion){
        this.conectarAColeccion(coleccion);
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





    public HashMap<String,Object> obtenerBebidas(){
        HashMap<String,Object> datos = new HashMap<>();
        ArrayList<Bebida> bebidas = new ArrayList<>();
        FindIterable resultado = coleccion.find();
        MongoCursor iterador = resultado.iterator();

        while (iterador.hasNext()) {
            Document documento = (Document) iterador.next();
            String nombre = documento.getString("nombre");
            String marca = documento.getString("marca");

            //todos los post en mongo tienen que ser ints! (controlarlo en js)
            int precio = documento.getInteger("precio");


            String tipo = documento.getString("tipo");
            int cantidad= documento.getInteger("cantidad");

            //tri termina esto!
            Document info = (Document) documento.get("info");
            int ibu = info.getInteger("ibu");

            //hacer los switch cases para crear determinada bebida

            //Bebida bebida = new Bebida(nombre,marca,tipo,precio,cantidad,info);
            //bebidas.add(bebida);
        }
        datos.put("Bebidas",bebidas);
        return datos;
    }

    public void insertarBebida(Bebida bebida){
        Document nuevoDocumento = new Document();
        nuevoDocumento.append("nombre",bebida.getNombre());
        nuevoDocumento.append("precio",bebida.getPrecio());
        nuevoDocumento.append("marca",bebida.getMarca());
        nuevoDocumento.append("tipo",bebida.getTipo());
        nuevoDocumento.append("cantidad",bebida.getCantidad());
        nuevoDocumento.append("info",bebida.getInfo());
        coleccion.insertOne(nuevoDocumento);
    }

    public int obtenerCantidad(String nombre){
        String json = "{ nombre : { $eq : \"Nadia\" } }";
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

    public void actualizarDatosDeBebida(String nombre,int cantidadASumar){
        String json = "{ nombre: { $eq : 23 } }";
        Document filtro = Document.parse(json);
        int valorNuevoCantidad= cantidadASumar+this.obtenerCantidad(nombre);

        json = "{ $set: { cantidad :"+valorNuevoCantidad+" } }";
        Document nuevosValores= Document.parse(json);
        coleccion.updateOne(filtro,nuevosValores);
    }

    public void eliminarBebida(String nombre){
        String json = "{ nombre: { $eq: 'Fernet Branca' } }";
        Document filtro = Document.parse(json);
        coleccion.deleteOne(filtro);
    }

    public void eliminarVariosAlumnos(/** ¿parámetros? **/){
        String json = "{ edad : { $eq: 25 } }";
        Document filtro = Document.parse(json);
        coleccion.deleteMany(filtro);
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


    /**
     * documentación de clase Document
     * http://mongodb.github.io/mongo-java-driver/3.6/javadoc/org/bson/Document.html
     */
}