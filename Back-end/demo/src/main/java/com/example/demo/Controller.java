package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;
import org.springframework.web.bind.annotation.CrossOrigin;

/** url: http://localhost:8080/api/... **/

@RestController
@RequestMapping("/api")
public class Controller {

    @Autowired
    private MongoDB mongo;

    public Controller() {
        this.mongo=new MongoDB();
    }

    //funciona
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @RequestMapping(value ="/get/bebidas", method = RequestMethod.GET)
    public ResponseEntity<Object> obtenerBebidas() {
        mongo.conectarAColeccionUnica("bebidas");
        HashMap<String, Object> datos = mongo.obtenerBebidas();
        System.out.println("\nsuccess");
        return new ResponseEntity<>(datos, HttpStatus.OK);
    }

    //este metodo no lo usamos en la app para el tp, en una app terminada posiblemente se usaria
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @RequestMapping(value = "/delete/eliminar/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> eliminarBebida() {
        mongo.conectarAColeccionUnica("bebidas");
        mongo.eliminarBebida("Fernet Branca");
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @RequestMapping(value = "/post/insertBebida", method = RequestMethod.POST)
    public ResponseEntity<Object> insertBebida(@RequestBody HashMap<String, String> bebida) {
        mongo.conectarAColeccionUnica("bebidas");
        mongo.insertarBebida(bebida);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @RequestMapping(value = "/patch/updateStockBebida", method = RequestMethod.PATCH)
    public ResponseEntity<Object> patchBebida(@RequestBody HashMap<String, String> bebida) {
        mongo.conectarAColeccionUnica("bebidas");
        int cantidad = Integer.parseInt(bebida.get("cantidad"));
        mongo.actualizarStockBebida(bebida.get("nombre"), cantidad);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

