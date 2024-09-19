package edu.eci.cvds.inventario;

import org.springframework.stereotype.Service;

@Service
public class NotificationService {
    private Subject subject = new Subject();

    public void addObserver() {
        subject.attach(new AgenteLog());
        subject.attach(new AgenteAdvertencia());
    }

    public void changeProduct(Producto producto) {
        subject.setState(producto);
    }

    public Subject getSubject() { return subject;
    }
}
