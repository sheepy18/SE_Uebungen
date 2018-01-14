package le12.a4.commandPattern;

import java.util.Arrays;

public class SumCommand extends OperationCommand {
    public SumCommand(double n1, double n2) {
        super(n1, n2);
    }

    @Override
    public double execute() {
        return Arrays.stream(inputNumbers).sum();
    }
}
