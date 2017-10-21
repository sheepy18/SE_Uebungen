package le02.zeit;

/**
 * Created by Lukas on 21.10.2017.
 */
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ZeitTest {

    Zeit z01, z02, z03,z04;

    @Before
    public void setUp() throws Exception {
        z01   = new Zeit(00.01f);
        z02   = new Zeit(00.02f);
        z03 = new Zeit(0.0099999999999999999999999999999999999999999999f + 0.0000000001f);
        z04 = new Zeit(1.8f);
    }


    @Test
    public void testStunden() {
        assertEquals(0, z01.stunden());
        assertEquals(0, z02.stunden());
    }

    @Test
    public void testMinuten() {
        assertEquals(1, z01.minuten());
        assertEquals(2, z02.minuten());
    }

    @Test
    public void testAdd() {
        z01.add(z01); assertEquals(z01, z01);
    }

    @Test
    public void testToString() {
        assertEquals("00:01", z01.toString());
    }

    @Test
    public void testFloatInaccuracy() {
        assertFalse("00:01".equals(z03.toString()));
    }

    @Test
    public void testConversion() {
        assertEquals(1, z04.stunden());
        assertEquals(48, z04.minuten());
    }
}