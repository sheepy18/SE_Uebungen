package le02;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Lukas on 19.10.2017.
 */
public class ProjectTester {

    ProjectIF simple_p1, empty, complex;

    @Before
    public void setup() {
        String[] [] simple_ex = {{"A","C"}};
        complex = new Project(new String[][]{{"A", "C"}, {"C", "D"}, {"B", "C"},{"A", "E"}, {"B", "F"}, {"E", "G"},{"D", "G"}, {"F", "G"}, {"C", "E"},{"C", "F"}});
        String[] [] empty_ex = {};

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

    @Test
    public void empty_3() {
        assertTrue(empty.isWellSorted(new String[]{}));
    }

    @Test
    public void test_complex_1() {
        assertTrue(complex.isWellSorted(new String[]{"A","B","C","D","E","F","G"}));
    }

    @Test
    public void test_complex_2() {
        assertFalse(complex.isWellSorted(new String[]{"A","B","F","D","E","C","G"}));
    }


}
