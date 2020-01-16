import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Drink implements Comparable<Drink> {
    private Map<String, Integer> recipe = new HashMap<>(); //map ingredients to units per
    private String name;
    private double totalCost = 0;

    public Drink(String name, String[] recipe) {
        this.name = name;
        setRecipe(recipe);
    }

    public int compareTo(Drink drink) {
        return name.compareTo(drink.getName());
    }

    public void setRecipe(String[] recipe) {
        for (String s : recipe) {
            if (this.recipe.containsKey(s)) {
                this.recipe.put(s, this.recipe.get(s) + 1);//increment if multiple units
            } else {
                this.recipe.put(s, 1);//insert first occurrence of ingredient
            }
        }
    }

    public void setCost(double totalCost) {
        this.totalCost = totalCost;
    }

    public Map<String, Integer> getRecipe() {
        return recipe;
    }

    public double getCost() {
        return totalCost;
    }

    public String getName() {
        return name;
    }

    public void make(List<Ingredient> ingredientList, CliView view) {
        if (isMakeable(ingredientList)) {
            view.showDispensingDrink(this);
            for (Ingredient ingredient : ingredientList) {
                consume(ingredient);
            }
        } else {
            view.showOutOfStock(this);
        }
    }

    public void consume(Ingredient ingredient) {
        if (needed(ingredient)) {
            ingredient.consume(neededAmount(ingredient));
        }
    }

    public boolean needed(Ingredient ingredient) {
        return recipe.containsKey(ingredient.getName());
    }

    public Integer neededAmount(Ingredient ingredient) {
        return recipe.get(ingredient.getName());
    }

    public boolean isMakeable(List<Ingredient> ingredientList) {
        return ingredientList.stream()
            .filter(this::needed)
            .allMatch(this::available);
    }

    public boolean available(Ingredient ingredient) {
        return ingredient.hasAmount(neededAmount(ingredient));
    }

}