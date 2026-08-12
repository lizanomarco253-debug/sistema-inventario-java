package servicio;

import modelo.Producto;
import java.util.ArrayList;

public class Inventario {

    private ArrayList<Producto> productos;

    public Inventario() {
        this.productos = new ArrayList<>();
    }

    public boolean agregarProducto(Producto nuevo) {
        if (buscarPorCodigo(nuevo.getCodigo()) != null) {
            return false;
        }
        productos.add(nuevo);
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

}