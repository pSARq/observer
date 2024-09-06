package org.example2.publish;

import org.example2.EventType;
import org.example2.subscriber.ISubscriber;

/*Este ejemplo es similar al anterior pero con la diferencia de que ahora se reciben eventos*/
public interface IPublisher<E> {
    void addSubscriber(ISubscriber<E> subscriber, EventType eventType);
    void removeSubscriber(ISubscriber<E> subscriber, EventType eventType);
    void notifySubscribers(E event, EventType eventType);
}
