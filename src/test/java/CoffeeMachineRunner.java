import com.gregorriegler.seamer.Seamer;
import com.gregorriegler.seamer.core.Signature1;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class CoffeeMachineRunner {
    public CoffeeMachineRunner() {
    }

    public static void main(String[] args) {
        Seamer.persist((Signature1<String, String>) CoffeeMachineRunner::run, CoffeeMachineRunner.class, "CoffeeMachine")
            .recordInvocation("1\nq\n")
            .recordInvocation("1\n1\n1\n1\nq\n")
            .recordInvocation("2\nr\nq\n")
            .recordInvocation("9999\nq\n")
            .recordInvocation("\nq\n");
    }

    static String run(String input) {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        CoffeeMachine.main(new String[]{});

        return output.toString();
    }

}