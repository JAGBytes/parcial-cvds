package edu.eci.cvds.inventario;

import org.springframework.beans.factory.annotation.Autowired;


//@RequestMapping("/notifications")
public class NotificationController {
    @Autowired
    private NotificationService notificationService;

//@PostMapping("/add")
    public void addObserver() {
        notificationService.addObserver();
    }

//@PostMapping("/change")
    public void changeState(Producto producto) {
        notificationService.changeProduct(producto);
    }
}
