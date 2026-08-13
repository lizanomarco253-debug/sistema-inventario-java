package servicio;

import java.io.*;
import modelo.Producto;
import java.util.ArrayList;

public class Inventario {

    private static final String ARCHIVO = "productos.txt";
    private ArrayList<Producto> productos;

    public Inventario() {
        this.productos = new ArrayList<>();
        cargarDesdeArchivo();
    }

    public boolean agregarProducto(Producto nuevo) {
        if (buscarPorCodigo(nuevo.getCodigo()) != null) {
            return false;
        }
        productos.add(nuevo);
        guardarEnArchivo();
        return true;
    }

    public Producto buscarPorCodigo(String codigo) {
        for (Producto p : productos) {
            if (p.getCodigo().equals(codigo)) {
                return p;
            }
        }
        return null;
    }

    public boolean eliminar(String codigo) {
        Producto encontrado = buscarPorCodigo(codigo);
        if (encontrado == null) {
            return false;
        }
        productos.remove(encontrado);
        guardarEnArchivo();
        return true;
    }

    public boolean actualizarStock(String codigo, int nuevoStock) {
        if (nuevoStock < 0) {
            return false;
        }
        Producto encontrado = buscarPorCodigo(codigo);
        if (encontrado == null) {
            return false;
        }
        encontrado.setStock(nuevoStock);
        guardarEnArchivo();
        return true;
    }


    public void listarProductos() {
        for (Producto p : productos) {
            System.out.println(p);
        }
    }

    public void ordenarPorPrecio() {
        int n = productos.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (productos.get(j).getPrecio() > productos.get(j + 1).getPrecio()) {
                    Producto temp = productos.get(j);
                    productos.set(j, productos.get(j + 1));
                    productos.set(j + 1, temp);
                }
            }
        }
    }

    public ArrayList<Producto> listarStockBajo() {
        ArrayList<Producto> resultado = new ArrayList<>();
        for (Producto p : productos) {
            if (p.esStockBajo()) {
                resultado.add(p);
            }
        }
        return resultado;
    }

    private void guardarEnArchivo() {
    try (FileWriter fw = new FileWriter(ARCHIVO)) {
        for (Producto p : productos) {
            fw.write(p.getCodigo() + ";" + p.getNombre() + ";" + p.getPrecio() + ";" + p.getStock() + ";" + p.getCategoria() + "\n");
            }
        } catch (IOException e) {
            System.out.println("Error al guardar en archivo: " + e.getMessage());
        }
    }

    private void cargarDesdeArchivo() {
    File archivo = new File(ARCHIVO);
    System.out.println("Buscando archivo en: " + archivo.getAbsolutePath());
    if (!archivo.exists()) {
        return;
    }
    try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
        String linea;
        while ((linea = br.readLine()) != null) {
            String[] datos = linea.split(";");
            String codigo = datos[0];
            String nombre = datos[1];
            double precio = Double.parseDouble(datos[2]);
            int stock = Integer.parseInt(datos[3]);
            String categoria = datos[4];
            productos.add(new Producto(codigo, nombre, precio, stock, categoria));
        }
    } catch (IOException e) {
        System.out.println("Error al cargar archivo: " + e.getMessage());
    }
}

}