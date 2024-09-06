package org.example2.subscriber.impl;

import org.example2.EventType;
import org.example2.subscriber.ISubscriber;

import java.util.Set;

public class NewsSubscriber implements ISubscriber<String> {
    private final String subscriberName;
    private final Set<EventType> interestedEvents;

    public NewsSubscriber(String subscriberName, Set<EventType> interestedEvents) {
        this.subscriberName = subscriberName;
        this.interestedEvents = interestedEvents;
    }

    @Override
    public void update(String news, EventType eventType) {
        if (interestedEvents.contains(eventType)) {
            System.out.println(subscriberName + " ha recibido una notificación de " + eventType + ": " + news);
        }
    }
}
