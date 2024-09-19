package edu.eci.cvds.inventario;

public class Producto {
    private String nombre;
    private double precio;
    private int cantidadEnStock;
    private String categoria;

    public Producto(String nombre, double precio, int cantidadEnStock, String categoria) {
        this.nombre = nombre;
        this.precio = precio;
        this.cantidadEnStock = cantidadEnStock;
        this.categoria = categoria;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public int getCantidadEnStock() {
        return cantidadEnStock;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCantidadEnStock(int cantidadEnStock) {
        this.cantidadEnStock = cantidadEnStock;
    }
}
