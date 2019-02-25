package solutions;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Valentyn.Moliakov
 */
public class Solution5ConsecutiveArray {

    //consecutive([4, 2, 1, 6, 5]) = 3, [4, 5, 6]

    public static int consecutive(int[] arr) {
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, 1 + consecutive(arr, i));
        }
        return max;
    }

    private static int consecutive(int[] arr, int i) { //i = 0
        if (i == arr.length) {
            return 0;
        }
        int tmpMax = 0;
        for (int j = i + 1; j < arr.length; j++) {
            if (arr[j] == arr[i] + 1) {   //arr[i] = 4
                tmpMax = Math.max(1 + consecutive(arr, j), tmpMax);
            }
        }
        return tmpMax;
    }

    public static int consecutiveSet(int[] arr) {
        Set<Integer> values = new HashSet<>();
        for (int a : arr) {
            values.add(a);
        }
        int maxLength = 0;
        for (int i : values) {
            if (values.contains(i - 1)) {
                continue;
            }
            int length = 0;
            while (values.contains(i++)) {
                length++;
            }
            maxLength = Math.max(length, maxLength);
        }
        return maxLength;
    }
}
