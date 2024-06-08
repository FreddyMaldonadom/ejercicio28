package trabajosentregas.Ejercicio28;

import java.util.Scanner;

public class Menu {
    private ProductoServicio productoServicio = new ProductoServicio();
    private ArchivoServicio archivoServicio = new ArchivoServicio();
    private Scanner scanner = new Scanner(System.in);

    public void mostrarMenu() {
        while (true) {
            System.out.println("1. Listar Producto");
            System.out.println("2. Editar Datos");
            System.out.println("3. Importar Datos");
            System.out.println("4. Salir");
            System.out.print("Ingrese una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (opcion) {
                case 1:
                    listarProductos();
                    break;
                case 2:
                    editarProducto();
                    break;
                case 3:
                    importarDatos();
                    break;
                case 4:
                    System.out.println("Abandonando el sistema de clientes...");
                    return;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }

    private void listarProductos() {
        for (Producto producto : productoServicio.getListaProductos()) {
            System.out.println(producto);
        }
    }

    private void editarProducto() {
        System.out.print("Ingrese el código del producto: ");
        String codigo = scanner.nextLine();
        for (Producto producto : productoServicio.getListaProductos()) {
            if (producto.getCodigo().equals(codigo)) {
                System.out.println("1.-El nombre del articulo actual es: " + producto.getArticulo());
                System.out.println("2.-El código del producto: " + producto.getCodigo());
                System.out.println("3.-El color del producto: " + producto.getColor());
                System.out.println("4.-La descripción del producto: " + producto.getDescripcion());
                System.out.println("5.-La marca del producto: " + producto.getMarca());
                System.out.println("6.-El precio del producto: " + producto.getPrecio());
                System.out.println("7.-La talla del producto: " + producto.getTalla());
                System.out.print("Ingrese la opción a editar de los datos del producto: ");
                int opcion = scanner.nextInt();
                scanner.nextLine();  // Consume newline
                System.out.print("Ingrese el nuevo valor: ");
                String nuevoValor = scanner.nextLine();

                switch (opcion) {
                    case 1: producto.setArticulo(nuevoValor); break;
                    case 3: producto.setColor(nuevoValor); break;
                    case 4: producto.setDescripcion(nuevoValor); break;
                    case 5: producto.setMarca(nuevoValor); break;
                    case 6: producto.setPrecio(nuevoValor); break;
                    case 7: producto.setTalla(nuevoValor); break;
                    default: System.out.println("Opción no válida."); break;
                }
                System.out.println("Producto editado exitosamente.");
                return;
            }
        }
        System.out.println("Producto no encontrado.");
    }

    private void importarDatos() {
        System.out.print("Ingresa la ruta en donde se encuentra el archivo ProductosImportados.csv: ");
        String ruta = scanner.nextLine();
        archivoServicio.cargarDatos(productoServicio, ruta);
    }
}
