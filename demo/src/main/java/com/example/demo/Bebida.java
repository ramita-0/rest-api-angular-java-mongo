package com.example.demo;

public abstract class Bebida {

    private String nombre;
    private String marca;
    private String tipo;
    private int precio;
    private int cantidad;
    private String descripcion;
    private boolean alcohol;

    public Bebida(String nombre, String marca, String tipo, int precio, int cantidad, String descripcion,boolean alcohol){
        this.nombre = nombre;
        this.marca = marca;
        this.tipo = tipo;
        this.precio = precio;
        this.cantidad = cantidad;
        this.descripcion=descripcion;
        this.alcohol=alcohol;
    }
    //saque la variable de tipo Object info que esta mal


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean isAlcohol() {
        return alcohol;
    }

    public void setAlcohol(boolean alcohol) {
        this.alcohol = alcohol;
    }
}
