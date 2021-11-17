public class BebidaNoAlcoholica extends Bebida{
    private boolean alcohol;
    public BebidaNoAlcoholica(boolean alcohol,String nombre, String marca, String tipo, int cantidad, int precio,String descripcion) {
        super(nombre, marca, tipo, cantidad, precio,descripcion);
        this.alcohol=alcohol;
    }
}
