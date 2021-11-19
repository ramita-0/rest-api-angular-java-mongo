package com.example.demo;

public abstract class BebidaAlcoholica extends Bebida {

    private int graduacion;
    private boolean artesanal;


    public BebidaAlcoholica(String descripcion, String nombre, String marca, String tipo, int cantidad, int precio ,boolean alcohol, boolean artesanal, int graduacion){
        super(nombre, marca, tipo, cantidad, precio, descripcion,alcohol);
        this.artesanal = artesanal;
        this.graduacion = graduacion;
    }

    public int getGraduacion() {
        return graduacion;
    }

    public boolean isArtesanal() {
        return artesanal;
    }

    public void setArtesanal(boolean artesanal) {
        this.artesanal = artesanal;
    }
}
