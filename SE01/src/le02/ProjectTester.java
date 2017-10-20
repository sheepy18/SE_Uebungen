package le02;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Lukas on 19.10.2017.
 */
public class ProjectTester {

    ProjectIF simple_p1, empty;

    @Before
    public void setup() {
        String[] [] simple_ex = {{"A","C"}};
        String[] [] empty_ex = {{}};

        simple_p1 = new Project(simple_ex);
        empty = new Project(empty_ex);
    }

    @Test
    public void simlpe_p1_1() {
        assertEquals(new String[] []{{"A","C"}}, simple_p1.getRules());
    }

    @Test
    public void simple_ex__1() {
        assertTrue(simple_p1.isWellSorted(new String[]{"A","C"}));
    }

    @Test
    public void empty_1() {
        assertFalse(simple_p1.isWellSorted(new String[]{}));
    }

    @Test
    public void empty_2() {
        assertFalse(empty.isWellSorted(new String[]{"A","B","C","D"}));
    }
}
