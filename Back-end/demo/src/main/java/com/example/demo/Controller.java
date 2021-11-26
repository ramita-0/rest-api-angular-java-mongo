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
        HashMap<String, Object> bebidas = mongo.obtenerBebidas();
        System.out.println("\nsuccessful get");
        return new ResponseEntity<>(bebidas, HttpStatus.OK);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @RequestMapping(value = "/post/insertBebida", method = RequestMethod.POST)
    public ResponseEntity<Object> insertBebida(@RequestBody HashMap<String, String> bebida) {
        mongo.conectarAColeccionUnica("bebidas");
        System.out.println(bebida);
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

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @RequestMapping(value = "/delete/deleteBebida/{bebida}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteBebida(@PathVariable String bebida) {
        mongo.conectarAColeccionUnica("bebidas");
        System.out.println("\n" + bebida);
        mongo.eliminarBebida(bebida);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

