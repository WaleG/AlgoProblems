package solutions.arrays;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author Valentyn.Moliakov
 */
public class Solution4FindDuplicates {

    public static List<Integer> findDuplicates(List<Integer> arr) {
        Set<Integer> result = new TreeSet<>();
        for (int value : arr) {
            int index = Math.abs(value - 1);
            if (arr.get(index) < 0) {
                result.add(Math.abs(value));
            } else {
                arr.set(index, -Math.abs(arr.get(index)));
            }
        }
        return new ArrayList<>(result);
    }
}
