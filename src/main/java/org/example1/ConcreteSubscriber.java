package org.example1;

/*Esta es una clase suscriptora que puede hacer x cantidad de acciones después de que el publicador le notifica algo*/
public class ConcreteSubscriber implements ISubscriber<String> {
    private final String name;

    public ConcreteSubscriber(String name) {
        this.name = name;
    }

    @Override
    public void update(String name) {
        System.out.println(this.name + " recibió una notificación: " + name);
    }
}
