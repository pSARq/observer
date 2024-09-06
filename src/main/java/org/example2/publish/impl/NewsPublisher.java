package org.example2.publish.impl;

import org.example2.EventType;
import org.example2.subscriber.ISubscriber;
import org.example2.publish.INewsPublisher;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*Ahora se almacenan las clases suscriptoras segun su evento, para que un solo suscriptor pueda
* manejar multiples clases con intereses diferentes*/
public class NewsPublisher implements INewsPublisher {
    private final Map<EventType, List<ISubscriber<String>>> subscriberByType = new HashMap<>();

    @Override
    public void publishNews(String news, EventType eventType) {
        notifySubscribers(news, eventType);
    }

    @Override
    public void addSubscriber(ISubscriber<String> subscriber, EventType eventType) {
        subscriberByType.computeIfAbsent(eventType, k -> new ArrayList<>()).add(subscriber);
    }

    @Override
    public void removeSubscriber(ISubscriber<String> subscriber, EventType eventType) {
        List<ISubscriber<String>> subscribers = subscriberByType.get(eventType);
        if (subscribers != null) {
            subscribers.remove(subscriber);
        }
    }

    @Override
    public void notifySubscribers(String event, EventType eventType) {
        List<ISubscriber<String>> subscribers = subscriberByType.get(eventType);
        if (subscribers != null) {
            subscribers.forEach(subscriber -> subscriber.update(event, eventType));
        }
    }
}
