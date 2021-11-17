package com.example.demo;

public class Cerveza extends BebidaAlcoholica{

    private int ibu;
    private String color;
    
    public Cerveza(String color,int ibu,String descripcion, String nombre, String marca, String tipo, int cantidad, int precio, boolean alcohol, boolean artesanal, int graduacion){
        super(descripcion, nombre, marca, tipo, cantidad, precio, alcohol, artesanal, graduacion);
        this.color = color;
        this.ibu = ibu;
    }

}
