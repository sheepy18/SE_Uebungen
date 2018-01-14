package le12.a4;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CalculatorTest {

    Calculator calc;

    @Before
    public void setup() {
        calc = new Calculator();
    }

    @Test
    public void sum() {
        calc = new Calculator();
        calc.sum(3, 5);
        assertEquals(8, calc.getResult(), 0.01);
        calc.sum(9, 5);
        assertEquals(14, calc.getResult(), 0.01);
        calc.sum(calc.getResult(), 20);
        assertEquals(34, calc.getResult(), 0.01);

        calc.undo();
        assertEquals(14, calc.getResult(), 0.01);
        calc.undo();
        assertEquals(8, calc.getResult(), 0.01);
        calc.undo();
        assertEquals(0, calc.getResult(), 0.01);

        calc.redo();
        assertEquals(8, calc.getResult(), 0.01);
        calc.redo();
        assertEquals(14, calc.getResult(), 0.01);
        calc.redo();
        assertEquals(34, calc.getResult(), 0.01);
        calc.redo();
        assertEquals(34, calc.getResult(), 0.01);
        calc.redo();
        assertEquals(34, calc.getResult(), 0.01);
        calc.redo();
        assertEquals(34, calc.getResult(), 0.01);

        calc.undo();
        calc.undo();
        calc.undo();
        assertEquals(0, calc.getResult(), 0.01);
        calc.undo();
        assertEquals(0, calc.getResult(), 0.01);
        calc.undo();
        assertEquals(0, calc.getResult(), 0.01);
    }

    @Test
    public void sub() {
        calc = new Calculator();

        calc.subtract(4, 5);
        assertEquals(-1, calc.getResult(), 0.01);

        calc.subtract(10, 5);
        assertEquals(5, calc.getResult(), 0.01);

        calc.subtract(calc.getResult(), 5);
        assertEquals(0, calc.getResult(), 0.01);

        calc.undo();
        assertEquals(5, calc.getResult(), 0.01);
        calc.undo();
        assertEquals(-1, calc.getResult(), 0.01);
        calc.undo();
        assertEquals(0, calc.getResult(), 0.01);

        calc.redo();
        calc.redo();
        assertEquals(5, calc.getResult(), 0.01);
        calc.redo();
        calc.redo();
        calc.redo();
        calc.redo();
        assertEquals(0, calc.getResult(), 0.01);

        calc.subtract(90, 80);
        assertEquals(10, calc.getResult(), 0.01);
        calc.undo();
        assertEquals(0, calc.getResult(), 0.01);
        calc.undo();
        assertEquals(5, calc.getResult(), 0.01);
        calc.undo();
        assertEquals(-1, calc.getResult(), 0.01);
        calc.undo();
        assertEquals(0, calc.getResult(), 0.01);
        calc.undo();
        assertEquals(0, calc.getResult(), 0.01);
    }
}
