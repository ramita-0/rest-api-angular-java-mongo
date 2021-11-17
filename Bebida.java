public abstract  class Bebida implements InterfazBebidas {
    private String nombre;
    private String marca;
    private String tipo;
    private int cantidad;
    private int precio;
    private String descripcion;

    public Bebida(String nombre, String marca, String tipo, int cantidad, int precio,String descripcion) {
        this.nombre = nombre;
        this.marca = marca;
        this.tipo = tipo;
        this.cantidad = cantidad;
        this.precio = precio;
        this.descripcion=descripcion;
    }

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

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
