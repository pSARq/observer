package org.example2.publish;

import org.example2.EventType;

public interface INewsPublisher extends IPublisher<String> {
    void publishNews(String news, EventType eventType);
}
