package org.example2.subscriber.impl;

import org.example2.EventType;
import org.example2.StockEvent;
import org.example2.subscriber.ISubscriber;

public class StockBrokerSubscriber implements ISubscriber<StockEvent> {
    private final String brokerName;
    private final String interestedStock;

    public StockBrokerSubscriber(String brokerName, String interestedStock) {
        this.brokerName = brokerName;
        this.interestedStock = interestedStock;
    }

    @Override
    public void update(StockEvent stockEvent, EventType eventType) {
        if (EventType.STOCK_PRICE_UPDATE == eventType && stockEvent.stockName().equals(interestedStock)) {
            System.out.println(brokerName + " ha recibido una actualización del precio de la acción " +
                    stockEvent.stockName() + ": $" + stockEvent.stockPrice());
        }
    }
}
