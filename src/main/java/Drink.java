import java.util.Map;

import static java.util.Arrays.stream;
import static java.util.function.Function.identity;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.summingInt;

public class Drink implements Comparable<Drink> {
    private final Map<String, Integer> recipe; //map ingredients to units per
    public final String name;

    public Drink(String name, String[] recipe) {
        this.name = name;
        this.recipe = asMap(recipe);
    }

    public Integer neededAmount(String name) {
        return this.recipe.getOrDefault(name, 0);
    }

    public int compareTo(Drink drink) {
        return name.compareTo(drink.name);
    }

    private static Map<String, Integer> asMap(String[] recipe) {
        return stream(recipe).collect(groupingBy(identity(), summingInt(e -> 1)));
    }

}