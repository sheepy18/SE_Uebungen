package le08;

/**
 * Created by Lukas on 30.11.2017.
 */
import java.util.function.BiFunction;

public interface ExtensibleCalculatorIF {

    /* liefere alle erlaubten Operationen des Taschenrechners, e.g. +,-,*,: */
    String[] operations();

    /* füge neue Operation mit Java Lambdas hinzu */
    void addOperation(String name, BiFunction operation);

    /* führe eine erlaubte Rechenoperation  op(x, y)   aus */
    int calc(String op, int x, int y);

}
