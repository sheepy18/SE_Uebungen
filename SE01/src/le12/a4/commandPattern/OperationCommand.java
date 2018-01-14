package le12.a4.commandPattern;

public abstract class OperationCommand {
    protected double[] inputNumbers;

    public OperationCommand(double n1, double n2)  {
        inputNumbers = new double[]{n1, n2};
    }

    public abstract double execute();
}
