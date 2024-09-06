package org.example2.subscriber;

import org.example2.EventType;

/*Ahora los suscriptores tambien reciben los eventos, asi pueden validar si de verdad se le esta enviando
* la informacion que le corresponde y de la que esta interesado cada suscriptor*/
public interface ISubscriber<E> {
    void update(E e, EventType eventType);
}
