package le08;

import java.util.function.BiFunction;

/**
 * Created by Lukas on 30.11.2017.
 */
public class Calculator implements ExtensibleCalculatorIF {


    @Override
    public String[] operations() {
        return new String[0];
    }

    @Override
    public void addOperation(String name, BiFunction operation) {

    }

    @Override
    public int calc(String op, int x, int y) {
        return 0;
    }
}
