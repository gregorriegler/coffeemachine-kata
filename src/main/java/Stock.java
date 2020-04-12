public class Stock implements Comparable<Stock> {
    public final String ingredient;
    private final double cost;
    private int amount;

    public Stock(String ingredient, double cost) {
        this.ingredient = ingredient;
        this.cost = cost;
        this.amount = 10;
    }

    public int amount() {
        return amount;
    }

    public void restock() {
        this.amount = 10;
    }

    public void consume(Drink drink) {
        this.amount = amount - drink.neededAmount(this.ingredient);
    }

    public boolean available(Drink drink) {
        return amount >= drink.neededAmount(this.ingredient);
    }

    public double cost(Drink drink) {
        return cost * drink.neededAmount(this.ingredient);
    }

    public int compareTo(Stock stock) {
        return this.ingredient.compareTo(stock.ingredient);
    }
}