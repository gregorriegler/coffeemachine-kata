import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CoffeeMachine {

    public static void main(String[] args) {
        // model
        Model model = new Model();

        // view
        CliView view = new CliView();
        view.askForSelection(model.ingredientList, model.drinkList);

        // controller
        control(view, model);
    }

    public static void control(CliView view, Model model) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = "";

        while (true) {
            try {
                input = reader.readLine().toLowerCase();

                if (input.equals("")) {
                    continue;
                } else if (input.equals("q")) {
                    break;
                } else if (input.equals("r")) {
                    model.restockIngredients();
                } else {
                    model.makeDrink(Integer.parseInt(input), view);
                }
                view.askForSelection(model.ingredientList, model.drinkList);
            } catch (Exception e) {
                view.showInvalidSelection(input);//illegal input
            }
        }
    }

}
