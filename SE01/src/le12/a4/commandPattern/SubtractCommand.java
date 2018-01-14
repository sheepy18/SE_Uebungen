package le12.a4.commandPattern;

public class SubtractCommand extends OperationCommand{
    public SubtractCommand(double n1, double n2) {
        super(n1, n2);
    }

    @Override
    public double execute() {
        return inputNumbers[0] - inputNumbers[1];
    }
}
