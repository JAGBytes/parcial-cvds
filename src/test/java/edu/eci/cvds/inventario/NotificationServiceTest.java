package edu.eci.cvds.inventario;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class NotificationServiceTest {
    private NotificationService notificationService;

    @BeforeEach
    void setUp() {
        notificationService = new NotificationService();
        notificationService.addObserver(); // Añadir los observadores en su respetivo metodo
    }

    @Test
    void testChangeProductAddsNewProduct() {
        Producto xbox = new Producto("XBOX One S", 299.99, 10, "Consola");
        notificationService.changeProduct(xbox);

        Map<String, Producto> productos = notificationService.getSubject().getProductos();
        assertEquals(1, productos.size()); // verifica que si este registrado
        assertEquals(xbox, productos.get("XBOX One S"));
    }

    @Test
    void testChangeProductUpdatesExistingProduct() {
        Producto xbox = new Producto("XBOX One S", 299.99, 10, "Consola");
        notificationService.changeProduct(xbox);

        Producto updatedXbox = new Producto("XBOX One S", 299.99, 5, "Consola");
        notificationService.changeProduct(updatedXbox); // Actualiza el stock

        Map<String, Producto> productos = notificationService.getSubject().getProductos();
        assertEquals(1, productos.size());
        assertEquals(5, productos.get("XBOX One S").getCantidadEnStock()); // Debería ser 5 después de la actualización
    }

    @Test
    void testChangeProductNotifiesObservers() {
        Producto xbox = new Producto("XBOX One S", 299.99, 10, "Consola");
        notificationService.changeProduct(xbox);

        Map<String, Producto> productos = notificationService.getSubject().getProductos();
        assertEquals(1, productos.size());
        assertTrue(productos.containsKey("XBOX One S"));
        assertEquals(10, productos.get("XBOX One S").getCantidadEnStock());
    }

    @Test
    void testChangeProductTriggersAlertForLowStock() {
        Producto xbox = new Producto("XBOX One S", 299.99, 4, "Consola");
        notificationService.changeProduct(xbox);

        Map<String, Producto> productos = notificationService.getSubject().getProductos();
        assertEquals(1, productos.size());
        assertEquals(4, productos.get("XBOX One S").getCantidadEnStock());
    }
}
