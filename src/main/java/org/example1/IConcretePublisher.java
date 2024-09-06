package org.example1;

/*Esta interfaz tampoco esta en el patron, pero decidí agregarla. Representa a todas las acciones que puede llevar
* una clase publicadora en concreto ya que cada publicadora puede llevar diferente logica, asi que pueden haber x
* cantidad de interfaces iguales a esta contengan diferentes métodos y que extiendan de IPublisher */
public interface IConcretePublisher extends IPublisher<String> {
    void setName(String name);
}
