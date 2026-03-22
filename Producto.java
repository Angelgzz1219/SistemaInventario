package inventario;

public abstract class Producto {

    protected String nombre;
    protected double precio;

    public Producto(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    // Método abstracto (obligatorio en las subclases)
    public abstract void mostrarInfo();
}