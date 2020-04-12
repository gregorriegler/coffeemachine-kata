import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Input {

    private final BufferedReader bufferedReader;

    public Input() {
        bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    }

    public String get() {
        try {
            return bufferedReader.readLine().toLowerCase();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
