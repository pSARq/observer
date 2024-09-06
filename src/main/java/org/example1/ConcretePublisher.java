package org.example1;

import java.util.ArrayList;
import java.util.List;

/*Esta clase es con las que se interactua y que despues de realizar sobre una acción entonces decide notificar
* a todos los suscriptores para que realicen una acción en concreto  */
public class ConcretePublisher implements IConcretePublisher {
    private final List<ISubscriber<String>> subscriberList = new ArrayList<>();
    private String name;

    @Override
    public void addSubscriber(ISubscriber<String> subscriber) {
        subscriberList.add(subscriber);
    }

    @Override
    public void removeSubscriber(ISubscriber<String> subscriber) {
        subscriberList.remove(subscriber);
    }

    @Override
    public void notifySubscribers() {
        for (ISubscriber<String> subscriber : subscriberList) {
            subscriber.update(name);
        }
    }

    /*En este caso desde esta misma clase se esta notificando despues de realizar un cambio de nombre, para este ejemplo
    * esta bien, pero no siempre es lo correcto, ya que puede llevar un efecto colateral el hecho de querer solo cambiar
    * el nombre sin que los suscriptores lo sepan. Lo mas limpio para evitar que eso pase es dejar la responsabilidad de
    * llamar el metodo de notificacion (notifySubscribers()) desde la clase cliente*/
    @Override
    public void setName(String name) {
        this.name = name;
        notifySubscribers();
    }
}
