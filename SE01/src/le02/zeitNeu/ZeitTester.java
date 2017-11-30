package le02.zeitNeu;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Lukas on 21.10.2017.
 */
public class ZeitTester {

    ZeitIF z01, z02, z03;

    @Before
    public void setup() {
        z01 = new Zeit();
        z02 = new Zeit(1, 45);
        z03 = new Zeit(1, 80);
    }

    @Test
    public void zeitMin() {
        assertEquals(0, z01.getMinute());
    }

    @Test
    public void zeitHour() {
        assertEquals(0, z01.getHour());
    }

    @Test
    public void zeitMinHour() {
        assertEquals(1, z02.getHour());
        assertEquals(45, z02.getMinute());
    }

    @Test
    public void zeitConversion() {
        assertEquals(2, z03.getHour());
        assertEquals(20, z03.getMinute());
    }

    @Test
    public void zeitToString() {
        assertEquals("00:00", z01.toString());
        assertEquals("01:45", z02.toString());
        assertEquals("02:20", z03.toString());
    }
}
