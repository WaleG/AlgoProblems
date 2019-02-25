package solutions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Valentyn.Moliakov
 */
public class Solution11ZeroSumSubarray {

    public static int[] subArray(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (sum == 0) {
                return Arrays.copyOfRange(arr, 0, i + 1);
            } else if (map.containsKey(sum)) {
                return Arrays.copyOfRange(arr, map.get(sum) + 1, i + 1);
            } else {
                map.put(sum, i);
            }
        }
        return null;
    }
}
