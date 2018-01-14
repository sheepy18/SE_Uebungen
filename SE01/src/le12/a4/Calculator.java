package le12.a4;

import le12.a4.commandPattern.OperationCommand;
import le12.a4.commandPattern.SubtractCommand;
import le12.a4.commandPattern.SumCommand;

import java.util.ArrayList;
import java.util.List;

public class Calculator {

    private List<OperationCommand> operations;
    private double result;
    private int indexLastCommand = -1;

    public Calculator() {
        operations = new ArrayList<>();
    }

    public double getResult() {
        return result;
    }

    public void undo() {
        indexLastCommand--;
        if(indexLastCommand <= -1) {
            result = 0;
            indexLastCommand = -1;
            return;
        }
        result = operations.get(indexLastCommand).execute();
    }

    public void redo() {
        indexLastCommand++;
        if(indexLastCommand >= operations.size()-1) {
            indexLastCommand = operations.size()-1;
        }
        result = operations.get(indexLastCommand).execute();
    }

    public void sum(double arg1, double arg2) {
        operations.add(new SumCommand(arg1, arg2));
        indexLastCommand++;
        result = operations.get(indexLastCommand).execute();
    }

    public void subtract(double arg1, double arg2) {
        operations.add(new SubtractCommand(arg1, arg2));
        indexLastCommand++;
        result = operations.get(indexLastCommand).execute();
    }
}
