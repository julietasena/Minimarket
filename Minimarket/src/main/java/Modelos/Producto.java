package Modelos;

public class Producto {
    private int idProducto;
    private String nombre_producto;
    private double precio_producto;
    private int stockProducto;

    public int getStockProducto() {
        return stockProducto;
    }

    public void setStockProducto(int stockProducto) {
        this.stockProducto = stockProducto;
    }

    public Producto(String nombre_producto, double precio_producto, int stockProducto) {
        this.nombre_producto = nombre_producto;
        this.precio_producto = precio_producto;
        this.stockProducto = stockProducto;
    }

    public Producto(int idProducto, String nombre_producto, double precio_producto, int stockProducto) {
        this.idProducto = idProducto;
        this.nombre_producto = nombre_producto;
        this.precio_producto = precio_producto;
        this.stockProducto = stockProducto;
    }

    public Producto() {
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre_producto() {
        return nombre_producto;
    }

    public void setNombre_producto(String nombre_producto) {
        this.nombre_producto = nombre_producto;
    }

    public double getPrecio_producto() {
        return precio_producto;
    }

    public void setPrecio_producto(double precio_producto) {
        this.precio_producto = precio_producto;
    }
}
