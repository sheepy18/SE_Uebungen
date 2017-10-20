package le02;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Lukas on 19.10.2017.
 */
public class ProjectTester {

    ProjectIF simple_p1;

    @Before
    public void setup() {
        String[] [] simple_ex = {{"A","C"}};

        simple_p1 = new Project(simple_ex);
    }

    @Test
    public void simlpe_p1_1() {
        assertEquals(new String[] []{{"A","b"}}, simple_p1.getRules());
    }

    @Test
    public void simple_ex__1() {
        assertTrue(simple_p1.isWellSorted(new String[]{"A","C"}));
    }


}
