package com.example.demo;

public class BebidaNoAlcoholica extends Bebida{
    private boolean artesanal;

    public BebidaNoAlcoholica(String nombre, String marca, String tipo, int cantidad, int precio, String descripcion, boolean alcohol, boolean artesanal){
        super(nombre, marca, tipo, cantidad, precio, descripcion, alcohol);
        this.artesanal = artesanal;
    }
}
