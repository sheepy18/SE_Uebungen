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
        boolean firstSorted = false;

        if((sequence.length != 0 && rules.length == 0) ||(sequence.length == 0 && rules.length != 0)){
            return false;
        }

        if(rules.length != 0) {
            if(rules[0].length == 0)
                return false;
        }

        for(int i = sequence.length - 1; i >= 0; i--) {
            for(int x = 0; x < rules.length; x++) {
                if(rules[x] [1].equals(sequence[i])) {
                    firstSorted = true;
                    isSorted = false;
                    for(int k = 0; k < i; k++) {
                        isSorted |= rules[x][0].equals(sequence[k]);
                    }
                    isWellSorted &= isSorted;
                }
            }
        }

        if(sequence.length == 0)
            return true;

        return isWellSorted && firstSorted;
    }
}
