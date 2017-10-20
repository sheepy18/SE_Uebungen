package le02;

/**
 * Created by Lukas on 20.10.2017.
 */
public class Project implements ProjectIF{
    String[][] rules;

    public Project(String[][] graph) {
        rules = graph;
    }

    public String[] [] getRules() {
        return rules;
    }

    public boolean isWellSorted(String[] sequence) {
        boolean isWellSorted = true;
        boolean isSorted = false;

        for(int i = sequence.length - 1; i >= 0; i--) {
            for(int x = 0; x < rules.length; x++) {
                if(rules[x] [1].equals(sequence[i])) {
                    isSorted = false;
                    for(int k = 0; k < i; k++) {
                        isSorted |= rules[x] [0].equals(sequence[k]);
                    }
                    isWellSorted &= isSorted;
                }
            }
        }

        return isWellSorted;
    }
}
