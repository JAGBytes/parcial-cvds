package edu.eci.cvds.inventario;

public class AgenteLog implements Observer{
    @Override
    public void update(Producto producto) {
        System.out.println("Producto: " + producto.getNombre() +
                " -> " + producto.getCantidadEnStock() +
                " unidades disponibles, Precio: " +
                producto.getPrecio() +
                ", Categoría: " + producto.getCategoria());
    }
}
