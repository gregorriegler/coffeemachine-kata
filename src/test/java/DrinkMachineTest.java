import seamer.test.SeamTest;

public class DrinkMachineTest extends SeamTest {

    @Override
    public Class<?> carrierClass() {
        return DrinkMachineRunner.class;
    }

    @Override
    public String seamId() {
        return "DrinkMachine";
    }
}