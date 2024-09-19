package edu.eci.cvds.inventario;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Subject {
    private List<Observer> observers = new ArrayList<>();
    private Map<String, Producto> productos = new HashMap<>();

    public void attach(Observer observer) {
        observers.add(observer);
    }

    public void detach(Observer observer) {
        observers.remove(observer);
    }

    public void setState(Producto producto) {
        // Si el producto ya existe, se actualiza
        productos.put(producto.getNombre(), producto);

        // Notifica usando patron observer
        notifyObservers(producto);
    }

    private void notifyObservers(Producto producto) {
        for (Observer observer : observers) {
            observer.update(producto); // Notifica el producto completo
        }
    }

    public Map<String, Producto> getProductos() {
        return productos;
    }
}
