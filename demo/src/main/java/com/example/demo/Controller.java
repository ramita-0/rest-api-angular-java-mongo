package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;

/** url: http://localhost:8080/api/... **/

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class Controller {

    @Autowired
    private MongoDB mongo;

    public Controller() {
        this.mongo=new MongoDB();
    }


    @RequestMapping(value ="/get_bebidas", method = RequestMethod.GET)
    public ResponseEntity<Object> obtenerBebidas() {
        HashMap<String, Object> datos = new HashMap<>();

        //esto es testing, hacer el metodo como se debe.
        datos.put("asd", "stirng");
        datos.put("dsa", "stirng");

        return new ResponseEntity<>(datos, HttpStatus.OK);
    }






//    @RequestMapping(value ="/venta", method = RequestMethod.GET)
//    public ResponseEntity<Object> obtenerBebidas() {
//
//        HashMap<String, Object> datos = mongo.obtenerBebidas();
//        return new ResponseEntity<>(datos, HttpStatus.OK);
//    }

    @RequestMapping(value = "/bebida/eliminar", method = RequestMethod.DELETE)
    public ResponseEntity<Object> eliminarBebida() {
        mongo.conectarAColeccionUnica("bebidas");
        mongo.eliminarBebida("Fernet Branca");
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

