package edu.eci.cvds.inventario;


public class AgenteAdvertencia implements Observer {

    @Override
    public void update(Producto producto) {
        if (producto.getCantidadEnStock() < 5) {
            System.out.println("ALERTA!!! El stock del Producto: " + producto.getNombre() +
                    " es muy bajo, solo quedan " + producto.getCantidadEnStock() + " unidades.");
        }
    }
}
