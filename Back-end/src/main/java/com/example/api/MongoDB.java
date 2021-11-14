package com.example.api;

import org.springframework.stereotype.Service;
import com.mongodb.MongoClient;
import com.mongodb.client.*;
import org.bson.Document;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
class MongoDB {

    private MongoDatabase baseDeDatos;
    private MongoCollection coleccion;

    public MongoDB() {
        this.conectar("personas","alumnos");
    }

    public void conectar(String baseDeDatos,String coleccion){
        this.conectarABaseDeDatos(baseDeDatos);
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

    public HashMap<String,Object> obtenerDatos(){
        HashMap<String,Object> datos = new HashMap<>();
        ArrayList<Alumno> alumnos = new ArrayList<>();

        FindIterable resultado = coleccion.find();
        MongoCursor iterador = resultado.iterator();

        while (iterador.hasNext()) {
            Document documento = (Document) iterador.next();
            String nombre = documento.getString("nombre");
            int edad = documento.getInteger("edad");
            System.out.println(nombre + " - " + edad);
        }

        datos.put("alumnos",alumnos);
        return datos;
    }

    public Alumno obtenerAlumno(HashMap<String,Object> filtros /** opcional **/) {
        Alumno alumno = new Alumno();
        /** aquí se deben tomar los valores del map para armar el json (opcional) **/
        String json = "{ nombre : { $eq : \"Nadia\" } }";
        Document filtro = Document.parse(json);
        FindIterable resultado = coleccion.find(filtro);
        MongoCursor iterador = resultado.iterator();

        while (iterador.hasNext()){
            Document documento = (Document) iterador.next();
            String nombre = documento.getString("nombre");
            int edad = documento.getInteger("edad");
            alumno = new Alumno(nombre,edad);
            System.out.println(nombre + " - " + edad);
        }

        return alumno;
    }

    public void insertarAlumno(Alumno alumno){
        Document nuevoDocumento = new Document();
        nuevoDocumento.append("nombre",alumno.getNombre());
        nuevoDocumento.append("edad",alumno.getEdad());
        coleccion.insertOne(nuevoDocumento);
    }

    public void insertarAlumnos(List<Alumno> alumnos){

        List<Document> documentosAInsertar = new ArrayList<>();

        for (Alumno alumno : alumnos) {

            Document nuevoDocumento = new Document();
            nuevoDocumento.append("nombre",alumno.getNombre());
            nuevoDocumento.append("edad",alumno.getEdad());
            documentosAInsertar.add(nuevoDocumento);

        }

        coleccion.insertMany(documentosAInsertar);
    }

    public void actualizarDatosDeVariosAlumnos(/** parámetros? **/){
        String json = "{ edad: { $eq : 23 } }";
        Document filtro = Document.parse(json);
        json = "{ $set: { edad :  25 } }";
        Document nuevosValores= Document.parse(json);
        coleccion.updateOne(filtro,nuevosValores);
    }

    public void eliminarAlumno(int id){
        String json = "{ nombre: { $eq: \"Nadia\" } }";
        Document filtro = Document.parse(json);
        coleccion.deleteOne(filtro);
    }

    public void eliminarVariosAlumnos(/** ¿parámetros? **/){
        String json = "{ edad : { $eq: 25 } }";
        Document filtro = Document.parse(json);
        coleccion.deleteMany(filtro);
    }


    /**
     * documentación de clase Document
     * http://mongodb.github.io/mongo-java-driver/3.6/javadoc/org/bson/Document.html
     */

}