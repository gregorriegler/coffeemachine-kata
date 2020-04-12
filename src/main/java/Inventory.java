import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class Inventory implements Iterable<Stock> {
    private final List<Stock> stocks = new ArrayList<Stock>();

    public Inventory() {
        stocks.add(new Stock("Coffee", 0.75));
        stocks.add(new Stock("Decaf Coffee", 0.75));
        stocks.add(new Stock("Sugar", 0.25));
        stocks.add(new Stock("Cream", 0.25));
        stocks.add(new Stock("Steamed Milk", 0.35));
        stocks.add(new Stock("Foamed Milk", 0.35));
        stocks.add(new Stock("Espresso", 1.10));
        stocks.add(new Stock("Cocoa", 0.90));
        stocks.add(new Stock("Whipped Cream", 1.00));

        Collections.sort(stocks);
    }

    public void restock() {
        forEach(Stock::restock);
    }

    public boolean canMake(Drink drink) {
        return stream()
            .allMatch(stock -> stock.available(drink));
    }

    public double cost(Drink drink) {
        return stream()
            .mapToDouble(stock -> stock.cost(drink))
            .sum();
    }

    public void make(Drink drink, Runnable onSuccess, Runnable onError) {
        if (!canMake(drink)) {
            onError.run();
            return;
        }

        onSuccess.run();
        _make(drink);
    }

    private void _make(Drink drink) {
        for (Stock stock : this) {
            stock.consume(drink);
        }
    }

    private Stream<Stock> stream() {
        return stocks.stream();
    }

    @Override
    public Iterator<Stock> iterator() {
        return stocks.iterator();
    }

    @Override
    public void forEach(Consumer<? super Stock> action) {
        stocks.forEach(action);
    }

    @Override
    public Spliterator<Stock> spliterator() {
        return stocks.spliterator();
    }
}