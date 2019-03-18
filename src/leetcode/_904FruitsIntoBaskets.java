package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Valentyn.Moliakov
 */
public class _904FruitsIntoBaskets {

    /* Brute-force. Time: O(n^2). Space: O(1).
    public int totalFruit(int[] tree) {
        int max = 0;
        for (int i = 0; i < tree.length; i++) {
            int fc = fruitsCollected(tree, i);
            max = Math.max(fc, max);
        }
        return max;
    }

    private int fruitsCollected(int[] tree, int i) {
        int first = tree[i++];
        int count = 1;
        while (i < tree.length && tree[i] == first) {
            count++;
            i++;
        }
        if (i == tree.length) return count;
        int second = tree[i++];
        count++;

        while (i < tree.length && (tree[i] == first || tree[i] == second)) {
            count++;
            i++;
        }

        return count;
    }
    */

    /* Optimized: Sliding window. Time: O(n). Space: O(1).*/
    public int totalFruit(int[] tree) {
        Map<Integer, Integer> map = new HashMap<>();
        int i = 0;
        int max = 0;
        for (int j = 0; j < tree.length; j++) {
            map.put(tree[j], map.getOrDefault(tree[j], 0) + 1);
            while (map.size() >= 3) {
                int val = map.get(tree[i]);
                if (val == 1) {
                    map.remove(tree[i]);
                } else {
                    map.put(tree[i], --val);
                }
                i++;
            }
            max = Math.max(max, j - i + 1);
        }
        return max;
    }

}
