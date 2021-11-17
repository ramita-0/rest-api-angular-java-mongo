public abstract class BebidaAlcoholica extends Bebida {
    private boolean alcohol;
    private int graduacion;
    private boolean artesanal;
    public BebidaAlcoholica(String descripcion,String nombre, String marca, String tipo, int cantidad, int precio,boolean alcohol,boolean artesanal,int graduacion) {
        super(nombre, marca, tipo, cantidad, precio,descripcion);
        this.alcohol=alcohol;
        this.artesanal=artesanal;
        this.graduacion=graduacion;
    }
}
