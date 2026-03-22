package inventario;

public class Electronico extends Producto implements IVendible {

    private int garantia;

    public Electronico(String nombre, double precio, int garantia) {
        super(nombre, precio);
        this.garantia = garantia;
    }

    @Override
    public void mostrarInfo() {
        System.out.println("Electrónico: " + nombre);
        System.out.println("Precio: " + precio);
        System.out.println("Garantía: " + garantia + " meses");
    }

    @Override
    public double calcularPrecioFinal() {
        return precio * 1.16; // IVA
    }
}