package app;

import modelo.Producto;
import servicio.Inventario;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Inventario inventario = new Inventario();
        boolean continuar = true;

        do {
            mostrarMenu();
            int opcion = leerOpcion(sc);

            switch (opcion) {
                case 1:
                    agregarProducto(sc, inventario);
                    break;
                case 2:
                    buscarProducto(sc, inventario);
                    break;
                case 3:
                    actualizarStock(sc, inventario);
                    break;
                case 4:
                    eliminarProducto(sc, inventario);
                    break;
                case 5:
                    inventario.listarProductos();
                    break;
                case 6:
                    inventario.ordenarPorPrecio();
                    System.out.println("Productos ordenados por precio.");
                    break;
                case 7:
                    for (Producto p : inventario.listarStockBajo()) {
                        System.out.println(p);
                    }
                    break;
                case 8:
                    continuar = false;
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción no válida, intenta de nuevo.");
            }

        } while (continuar);

        sc.close();
    }

    private static void mostrarMenu() {
        System.out.println("\n===== SISTEMA DE INVENTARIO =====");
        System.out.println("1. Agregar producto");
        System.out.println("2. Buscar producto por código");
        System.out.println("3. Actualizar stock");
        System.out.println("4. Eliminar producto");
        System.out.println("5. Listar todos los productos");
        System.out.println("6. Ordenar por precio");
        System.out.println("7. Ver productos con stock bajo");
        System.out.println("8. Salir");
        System.out.print("Elige una opción: ");
    }

    private static int leerOpcion(Scanner sc) {
        try {
            int opcion = sc.nextInt();
            sc.nextLine();
            return opcion;
        } catch (InputMismatchException e) {
            sc.nextLine();
            System.out.println("Debes ingresar un número.");
            return -1;
        }
    }

    private static void agregarProducto(Scanner sc, Inventario inventario) {
        try {
            System.out.print("Código: ");
            String codigo = sc.nextLine();
            System.out.print("Nombre: ");
            String nombre = sc.nextLine();
            System.out.print("Precio: ");
            double precio = Double.parseDouble(sc.nextLine());
            System.out.print("Stock: ");
            int stock = Integer.parseInt(sc.nextLine());
            System.out.print("Categoría: ");
            String categoria = sc.nextLine();

            Producto nuevo = new Producto(codigo, nombre, precio, stock, categoria);
            boolean exito = inventario.agregarProducto(nuevo);

            if (exito) {
                System.out.println("Producto agregado correctamente.");
            } else {
                System.out.println("Ya existe un producto con ese código.");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void buscarProducto(Scanner sc, Inventario inventario) {
        System.out.print("Código a buscar: ");
        String codigo = sc.nextLine();
        Producto encontrado = inventario.buscarPorCodigo(codigo);

        if (encontrado != null) {
            System.out.println(encontrado);
        } else {
            System.out.println("No se encontró ningún producto con ese código.");
        }
    }

    private static void actualizarStock(Scanner sc, Inventario inventario) {
        System.out.print("Código del producto: ");
        String codigo = sc.nextLine();
        System.out.print("Nuevo stock: ");

        try {
            int nuevoStock = Integer.parseInt(sc.nextLine());
            boolean exito = inventario.actualizarStock(codigo, nuevoStock);

            if (exito) {
                System.out.println("Stock actualizado correctamente.");
            } else {
                System.out.println("No se pudo actualizar (código no existe o stock inválido).");
            }
        } catch (NumberFormatException e) {
            System.out.println("Debes ingresar un número válido.");
        }
    }

    private static void eliminarProducto(Scanner sc, Inventario inventario) {
        System.out.print("Código a eliminar: ");
        String codigo = sc.nextLine();
        boolean exito = inventario.eliminar(codigo);

        if (exito) {
            System.out.println("Producto eliminado correctamente.");
        } else {
            System.out.println("No se encontró ningún producto con ese código.");
        }
    }
}