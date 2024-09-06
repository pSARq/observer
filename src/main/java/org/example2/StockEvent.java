package org.example2;

/*Esta clase la que contiene datos en este caso de las monedas, pero no contiene logica, simplemente contiene
* datos y asi como esta pueden haber mas dependiendo lo que se necesite*/
public record StockEvent(String stockName, double stockPrice) {
}
