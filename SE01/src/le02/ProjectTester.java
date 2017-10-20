package le02;

import org.junit.Before;

/**
 * Created by Lukas on 19.10.2017.
 */
public class ProjectTester {

    @Before
    public void setup() {
        String[] [] simple_graph = {{"A","C"}};

        ProjectIF simple_p1 = new Project(simple_graph);
    }
}
