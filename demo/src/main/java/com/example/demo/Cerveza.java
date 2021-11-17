package com.example.demo;

public class Cerveza extends BebidaAlcoholica{

    private int ibu;
    private String color;

    public Cerveza(String color,int ibu,String descripcion, String nombre, String marca, String tipo, int cantidad, int precio, boolean alcohol, boolean artesanal, int graduacion){
        super(descripcion, nombre, marca, tipo, cantidad, precio, alcohol, artesanal, graduacion);
        this.color = color;
        this.ibu = ibu;
    }

    public int getIbu() {
        return ibu;
    }

    public void setIbu(int ibu) {
        this.ibu = ibu;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
