package org.example1;

/*Esta interfaz en el patron no la encontré, pero decidí agregarla.
* Son las acciones basicas con las que debe cumplir una clase que sea publicadora*/
public interface IPublisher<T> {
    void addSubscriber(ISubscriber<T> subscriber);
    void removeSubscriber(ISubscriber<T> subscriber);
    void notifySubscribers();
}
