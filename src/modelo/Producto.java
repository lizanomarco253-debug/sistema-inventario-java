package modelo;

public class Producto {
    
    private String codigo;
    private String nombre;
    private double precio;
    private int stock;
    private String categoria;
    private static final int STOCK_MINIMO = 5;
    
    
    public Producto(String codigo, String nombre, double precio, int stock, String categoria) {
        if (codigo == null || codigo.isEmpty()) {
            throw new IllegalArgumentException("El código no puede estar vacío");
        }
        if (nombre == null || nombre.isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío");
        }
        if (precio < 0) {
            throw new IllegalArgumentException("El precio no puede ser negativo");
        }
        if (stock < 0) {
            throw new IllegalArgumentException("El stock no puede ser negativo");
        }

        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
        this.categoria = categoria;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public int getStock() {
        return stock;
    }

    public String getCategoria() {
        return categoria;
    }

    public boolean esStockBajo() {
        return stock < STOCK_MINIMO;
    }

    @Override
    public String toString() {
        return "Código: " + codigo + " | " + nombre + " | Precio: S/ " + precio + " | Stock: " + stock + " | Categoría: " + categoria;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPrecio(double precio) {
        if (precio < 0) {
            throw new IllegalArgumentException("El precio no puede ser negativo");
        }
        this.precio = precio;
    }

    public void setStock(int stock) {
        if (stock < 0) {
            throw new IllegalArgumentException("El stock no puede ser negativo");
        }
        this.stock = stock;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    

}
