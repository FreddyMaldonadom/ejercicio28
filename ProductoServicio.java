package trabajosentregas.Ejercicio28;

import java.util.ArrayList;

public class ProductoServicio {
    private ArrayList<Producto> listaProductos = new ArrayList<>();

    // Getters y Setters
    public ArrayList<Producto> getListaProductos() { return listaProductos; }
    public void setListaProductos(ArrayList<Producto> listaProductos) { this.listaProductos = listaProductos; }

    // Método para añadir producto a la lista
    public void agregarProducto(Producto producto) {
        listaProductos.add(producto);
    }
}
