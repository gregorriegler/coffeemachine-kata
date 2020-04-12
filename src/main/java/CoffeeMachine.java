import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class CoffeeMachine {
    public final Inventory inventory = new Inventory();
    public final List<Drink> menu = new ArrayList<>();

    public CoffeeMachine() {
        menu.add(new Drink("Coffee", new String[]{"Coffee", "Coffee", "Coffee", "Sugar", "Cream"}));
        menu.add(new Drink("Decaf Coffee", new String[]{"Decaf Coffee", "Decaf Coffee", "Decaf Coffee", "Sugar", "Cream"}));
        menu.add(new Drink("Caffe Latte", new String[]{"Espresso", "Espresso", "Steamed Milk"}));
        menu.add(new Drink("Caffe Americano", new String[]{"Espresso", "Espresso", "Espresso"}));
        menu.add(new Drink("Caffe Mocha", new String[]{"Espresso", "Cocoa", "Steamed Milk", "Whipped Cream"}));
        menu.add(new Drink("Cappuccino", new String[]{"Espresso", "Espresso", "Steamed Milk", "Foamed Milk"}));
        Collections.sort(menu);
    }

    public boolean canMake(Drink drink) {
        return this.inventory.canMake(drink);
    }

    public double cost(Drink drink) {
        return this.inventory.cost(drink);
    }

    public void makeDrink(Drink drink, Runnable onSuccess, Runnable onError) {
        inventory.make(
            drink,
            onSuccess,
            onError
        );
    }

    public void restock() {
        inventory.restock();
    }

    public Optional<Drink> drinkById(int drinkId) {
        if(invalidDrink(drinkId)) {
            return Optional.empty();
        }
        return Optional.of(menu.get(drinkId - 1));
    }

    private boolean invalidDrink(int drinkId) {
        return drinkId <= 0 || drinkId > menu.size();
    }
}
