public class CliView {

    public void askForSelection(CoffeeMachine coffeeMachine) {
        System.out.println("Inventory:");
        for (Stock stock : coffeeMachine.inventory) {
            System.out.println(stock.ingredient + "," + stock.amount());
        }

        System.out.println("\nMenu:");
        int count = 1;
        for (Drink drink : coffeeMachine.menu) {
            System.out.printf("%d,%s,$%.2f," + coffeeMachine.canMake(drink) + "\n", count, drink.name, coffeeMachine.cost(drink));
            count++;
        }

        System.out.print("\nYour selection: ");
    }

    public void showOutOfStock(Drink drink) {
        System.out.println("Out of stock: " + drink.name + "\n");
    }

    public void showDispensingDrink(Drink drink) {
        System.out.println("Dispensing: " + drink.name + "\n");
    }

    public void showInvalidSelection(String input) {
        System.out.print("Invalid selection: " + input + ". Try again: ");
    }
}