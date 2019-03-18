package interviewbit.arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Valentyn.Moliakov
 */
public class _3RepeatAndMissingNumberArray {

    public ArrayList<Integer> repeatedNumber(final List<Integer> A) {
        Integer missing = null;
        Integer duplicate = null;
        Map<Integer, Boolean> map = new HashMap<>();
        for (Integer i : A) {
            if (map.get(i) == null) {
                map.put(i, true);
            } else {
                duplicate = i;
            }
        }
        for (int i = 1; i <= A.size(); i++) {
            if (map.get(i) == null) {
                missing = i;
            }
        }
        ArrayList<Integer> result = new ArrayList<>();
        result.add(duplicate);
        result.add(missing);
        return result;
    }
}
