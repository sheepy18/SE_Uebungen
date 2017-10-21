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
    }

    @Test
    public void zeitMin() {
        assertEquals(0, z01.getMinutes());
    }
}
