package org.example2.publish.impl;

import org.example2.EventType;
import org.example2.subscriber.ISubscriber;
import org.example2.StockEvent;
import org.example2.publish.IStockMarketPublisher;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StockMarketPublisher implements IStockMarketPublisher {
    private final Map<EventType, List<ISubscriber<StockEvent>>> subscriberByType = new HashMap<>();

    @Override
    public void addSubscriber(ISubscriber<StockEvent> subscriber, EventType eventType) {
        subscriberByType.computeIfAbsent(eventType, k -> new ArrayList<>()).add(subscriber);
    }

    @Override
    public void removeSubscriber(ISubscriber<StockEvent> subscriber, EventType eventType) {
        List<ISubscriber<StockEvent>> subscribers = subscriberByType.get(eventType);
        if (subscribers != null) {
            subscribers.remove(subscriber);
        }
    }

    @Override
    public void notifySubscribers(StockEvent event, EventType eventType) {
        List<ISubscriber<StockEvent>> subscribers = subscriberByType.get(eventType);
        if (subscribers != null) {
            subscribers.forEach(subscriber -> subscriber.update(event, eventType));
        }
    }

    @Override
    public void updateStockPrice(String stockName, double stockPrice) {
        notifySubscribers(new StockEvent(stockName, stockPrice), EventType.STOCK_PRICE_UPDATE);
    }
}
