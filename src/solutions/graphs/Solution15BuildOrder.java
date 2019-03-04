package solutions.graphs;

import java.util.*;

/**
 * @author Valentyn.Moliakov
 */
public class Solution15BuildOrder {

    public static List<Integer> buildOrder(int[][] processes) {
        Set<Integer> tempMarks = new HashSet<>();
        Set<Integer> permMarks = new HashSet<>();
        List<Integer> result = new LinkedList<>();

        for (int i = 0; i < processes.length; i++) {
            if (!permMarks.contains(i)) {
                visit(i, processes, tempMarks, permMarks, result);
            }
        }

        return result;
    }

    private static void visit(int process, int[][] processes, Set<Integer> tempMarks, Set<Integer> permMarks, List<Integer> result) {
        if (tempMarks.contains(process)) {
            throw new RuntimeException();
        }
        if (!permMarks.contains(process)) {
            tempMarks.add(process);
            for (int i : processes[process]) {
                visit(i, processes, tempMarks, permMarks, result);
            }

            permMarks.add(process);
            tempMarks.remove(process);
            result.add(process);
        }
    }
}
