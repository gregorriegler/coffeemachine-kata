public class CoffeeMachineApp {

    private static final String QUIT = "q";
    private static final String RESTOCK = "r";

    public static void main(String[] args) {
        control(
            new CoffeeMachine(),
            new CliView()
        );
    }

    public static void control(CoffeeMachine coffeeMachine, CliView view) {
        view.askForSelection(coffeeMachine);

        Input input = new Input();
        do {
            String command = input.get();
            if(command.equals(QUIT)) break;
            switch (command) {
                case "":
                    break;
                case RESTOCK:
                    restock(coffeeMachine, view);
                    break;
                default:
                    makeDrink(command, coffeeMachine, view);
                    break;
            }
        } while (true);
    }

    public static void restock(CoffeeMachine coffeeMachine, CliView view) {
        coffeeMachine.restock();
        view.askForSelection(coffeeMachine);
    }

    public static void makeDrink(String command, CoffeeMachine coffeeMachine, CliView view) {
        try {
            Drink drink = coffeeMachine.drinkById(Integer.parseInt(command)).orElseThrow(IllegalArgumentException::new);
            coffeeMachine.makeDrink(
                drink,
                () -> view.showDispensingDrink(drink),
                () -> view.showOutOfStock(drink)
            );
            view.askForSelection(coffeeMachine);
        } catch (Exception e) {
            view.showInvalidSelection(command);//illegal input
        }
    }

}
