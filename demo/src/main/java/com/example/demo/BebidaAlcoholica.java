package com.example.demo;

public abstract class BebidaAlcoholica extends Bebida {

    private double graduacion;
    private boolean artesanal;


    public BebidaAlcoholica(String descripcion, String nombre, String marca, String tipo, int cantidad, int precio, boolean alcohol, boolean artesanal, double graduacion){
        super(nombre, marca, tipo, cantidad, precio, descripcion, alcohol);
        this.artesanal = artesanal;
        this.graduacion = graduacion;
    }

    public double getGraduacion() {
        return graduacion;
    }

    public void setGraduacion(double graduacion) {
        this.graduacion = graduacion;
    }

    public boolean isArtesanal() {
        return artesanal;
    }

    public void setArtesanal(boolean artesanal) {
        this.artesanal = artesanal;
    }
}
