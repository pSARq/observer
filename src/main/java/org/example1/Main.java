package org.example1;

public class Main {
    public static void main(String[] args) {
        //Se crea una clase que despues de realizar una operación publica sus cambios a sus subscriptores
        IConcretePublisher publisher = new ConcretePublisher();

        //Se crean dos subscriptores
        ISubscriber<String> subscriber1 = new ConcreteSubscriber("Subscriber 1");
        ISubscriber<String> subscriber2 = new ConcreteSubscriber("Subscriber 2");

        //Se añaden los subscriptores a la lista de subscriptores del publicador
        publisher.addSubscriber(subscriber1);
        publisher.addSubscriber(subscriber2);

        //Se cambia el nombre del publicador, lo que notifica a los subscriptores
        publisher.setName("Hello World!");

        //Se remueve un subscriptor
        publisher.removeSubscriber(subscriber1);

        //El publicador realiza un cambio, pero el subscriptor removido no recibe la notificación
        publisher.setName("Hello World again!");
    }
}