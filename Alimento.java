package inventario;

public class Alimento extends Producto implements IVendible {

    private String fechaCaducidad;

    public Alimento(String nombre, double precio, String fechaCaducidad) {
        super(nombre, precio);
        this.fechaCaducidad = fechaCaducidad;
    }

    @Override
    public void mostrarInfo() {
        System.out.println("Alimento: " + nombre);
        System.out.println("Precio: " + precio);
        System.out.println("Caduca: " + fechaCaducidad);
    }

    @Override
    public double calcularPrecioFinal() {
        return precio * 1.05;
    }
}