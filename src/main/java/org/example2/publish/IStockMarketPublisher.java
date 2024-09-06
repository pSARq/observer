package org.example2.publish;

import org.example2.StockEvent;

public interface IStockMarketPublisher extends IPublisher<StockEvent> {
    void updateStockPrice(String stockName, double stockPrice);
}
