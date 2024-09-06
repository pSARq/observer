package org.example2;

import org.example2.publish.INewsPublisher;
import org.example2.publish.IStockMarketPublisher;
import org.example2.publish.impl.NewsPublisher;
import org.example2.publish.impl.StockMarketPublisher;
import org.example2.subscriber.ISubscriber;
import org.example2.subscriber.impl.NewsSubscriber;
import org.example2.subscriber.impl.StockBrokerSubscriber;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        //Creación de los publicadores
        INewsPublisher newsPublisher = new NewsPublisher();
        IStockMarketPublisher stockMarketPublisher = new StockMarketPublisher();

        //Creación de los subscriptores de noticias
        Set<EventType> interestedEvents1 = new HashSet<>(Arrays.asList(EventType.GENERAL_NEWS, EventType.ECONOMIC_NEWS));
        Set<EventType> interestedEvents2 = new HashSet<>(Collections.singletonList(EventType.SPORTS_NEWS));

        ISubscriber<String> newsSubscriber1 = new NewsSubscriber("Subscriber 1", interestedEvents1);
        ISubscriber<String> newsSubscriber2 = new NewsSubscriber("Subscriber 2", interestedEvents2);

        //Creación de los subscriptores de eventos de mercado
        ISubscriber<StockEvent> broker1 = new StockBrokerSubscriber("Broker 1", "AAPL");
        ISubscriber<StockEvent> broker2 = new StockBrokerSubscriber("Broker 2", "GOOGL");

        //Añadir subscriptores a los publicadores
        newsPublisher.addSubscriber(newsSubscriber1, EventType.GENERAL_NEWS);
        newsPublisher.addSubscriber(newsSubscriber1, EventType.ECONOMIC_NEWS);
        newsPublisher.addSubscriber(newsSubscriber2, EventType.SPORTS_NEWS);

        stockMarketPublisher.addSubscriber(broker1, EventType.STOCK_PRICE_UPDATE);
        stockMarketPublisher.addSubscriber(broker2, EventType.STOCK_PRICE_UPDATE);

        //Publicar noticias
        newsPublisher.publishNews("Economía global en crecimiento", EventType.ECONOMIC_NEWS);
        newsPublisher.publishNews("Equipo local gana el campeonato", EventType.SPORTS_NEWS);

        //Actualizar precios de acciones
        stockMarketPublisher.updateStockPrice("AAPL", 150.0);
        stockMarketPublisher.updateStockPrice("GOOGL", 900.0);
    }
}
