public class Ingredient implements Comparable<Ingredient> {
    private String name;
    private double cost;
    private int stock;

    public Ingredient(String name, double cost) {
        this.name = name;
        this.cost = cost;
        this.stock = 10;
    }

    public int compareTo(Ingredient ingredient) {
        return name.compareTo(ingredient.getName());
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getName() {
        return name;
    }

    public double getCost() {
        return cost;
    }

    public int getStock() {
        return stock;
    }

    public void consume(Integer neededAmount) {
        this.stock = stock - neededAmount;
    }

    public boolean hasAmount(Integer neededAmount) {
        return stock >= neededAmount;
    }
}