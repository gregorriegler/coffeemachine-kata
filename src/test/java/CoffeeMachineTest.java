import com.gregorriegler.seamer.test.SeamerTest;

public class CoffeeMachineTest extends SeamerTest {

    @Override
    public Class<?> carrierClass() {
        return CoffeeMachineRunner.class;
    }

    @Override
    public String seamId() {
        return "CoffeeMachine";
    }
}