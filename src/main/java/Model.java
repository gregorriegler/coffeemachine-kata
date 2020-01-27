import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Model {
    List<Drink> drinkList = new ArrayList<>();
    List<Ingredient> ingredientList = new ArrayList<>();

    public Model() {
        addAllIngredients();
        addAllDrinks();
    }

    public void makeDrink(int drinkId, CliView view) {
        drinkById(drinkId).make(ingredientList, view);
    }

    public Drink drinkById(int drinkId) {
        assertDrinkExists(drinkId);
        return drinkList.get(drinkId - 1);
    }

    public void assertDrinkExists(int drinkId) {
        if (drinkId <= 0 || drinkId > drinkList.size()) {
            throw new IllegalArgumentException();
        }
    }

    public void restockIngredients() {
        for (Ingredient i : ingredientList) {
            i.setStock(10);
        }
    }

    public void addIngredient(Ingredient ingredient) {
        ingredientList.add(ingredient);
    }

    public void addDrink(String name, String[] recipe) {
        drinkList.add(new Drink(name, recipe));
    }

    public void addAllIngredients() {
        addIngredient(new Ingredient("Coffee", 0.75));
        addIngredient(new Ingredient("Decaf Coffee", 0.75));
        addIngredient(new Ingredient("Sugar", 0.25));
        addIngredient(new Ingredient("Cream", 0.25));
        addIngredient(new Ingredient("Steamed Milk", 0.35));
        addIngredient(new Ingredient("Foamed Milk", 0.35));
        addIngredient(new Ingredient("Espresso", 1.10));
        addIngredient(new Ingredient("Cocoa", 0.90));
        addIngredient(new Ingredient("Whipped Cream", 1.00));

        Collections.sort(ingredientList);
    }

    public void addAllDrinks() {
        addDrink("Coffee", new String[]{"Coffee", "Coffee", "Coffee", "Sugar", "Cream"});
        addDrink("Decaf Coffee", new String[]{"Decaf Coffee", "Decaf Coffee", "Decaf Coffee", "Sugar", "Cream"});
        addDrink("Caffe Latte", new String[]{"Espresso", "Espresso", "Steamed Milk"});
        addDrink("Caffe Americano", new String[]{"Espresso", "Espresso", "Espresso"});
        addDrink("Caffe Mocha", new String[]{"Espresso", "Cocoa", "Steamed Milk", "Whipped Cream"});
        addDrink("Cappuccino", new String[]{"Espresso", "Espresso", "Steamed Milk", "Foamed Milk"});

        Collections.sort(drinkList);
    }
}
