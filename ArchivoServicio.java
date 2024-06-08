package trabajosentregas.Ejercicio28;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ArchivoServicio {

    public void cargarDatos(ProductoServicio productoServicio, String ruta) {
        try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                Producto producto = new Producto(data[0], data[1], data[2], data[3], data[4], data[5], data[6]);
                productoServicio.agregarProducto(producto);
            }
            System.out.println("Datos cargados correctamente en la lista");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

