package inventario;

public class Ropa extends Producto implements IVendible {

    private String talla;

    public Ropa(String nombre, double precio, String talla) {
        super(nombre, precio);
        this.talla = talla;
    }

    @Override
    public void mostrarInfo() {
        System.out.println("Ropa: " + nombre);
        System.out.println("Precio: " + precio);
        System.out.println("Talla: " + talla);
    }

    @Override
    public double calcularPrecioFinal() {
        return precio * 1.10;
    }
}