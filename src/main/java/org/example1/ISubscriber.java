package org.example1;

/*Esta interfaz la deben de tener todas las clases que esperar suscribirse a una clase publicadora*/
public interface ISubscriber<T> {
    void update(T t);
}
