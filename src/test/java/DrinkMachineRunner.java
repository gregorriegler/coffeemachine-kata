import seamer.SeamerFactory;
import seamer.core.Seam;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class DrinkMachineRunner {
    public DrinkMachineRunner() {
    }

    public static void main(String[] args) {
        SeamerFactory.persist((Seam<String>) arg -> run((String[]) arg[0]), DrinkMachineRunner.class, "DrinkMachine")
            .recordInvocation($("1", "q"))
            .recordInvocation($("1", "1", "1", "1", "q"))
            .recordInvocation($("2", "r", "q"))
            .recordInvocation($("", "q"))
            .recordInvocation($("7", "q"));
    }

    static String run(String... strings) {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));
        System.setIn(new ByteArrayInputStream(commands(strings).getBytes()));

        DrinkMachine.main(new String[]{});

        return output.toString();
    }

    static String commands(String... commands) {
        return String.join("\n", commands) + "\n";
    }

    private static Object[] $(String... strings) {
        return new Object[]{strings};
    }
}