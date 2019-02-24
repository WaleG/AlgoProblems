package solutions;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Valentyn.Moliakov
 */
public class Solution201Knapsack {

    public static class Item {
        int weight;
        int value;

        public Item(int weight, int value) {
            this.weight = weight;
            this.value = value;
        }
    }

    public static int knapsack(Item[] items, int W) {
        //map: i > W > value
        Map<Integer, Map<Integer, Integer>> cache = new HashMap<>();
        return knapsack(items, W, 0, cache);
    }

    private static int knapsack(Item[] items, int W, int i, Map<Integer, Map<Integer, Integer>> cache) {
        if (i == items.length) {
            return 0;
        }
        if (!cache.containsKey(i)) {
            cache.put(i, new HashMap<>());
        }
        Integer cached = cache.get(i).get(W);
        if (cached != null) {
            return cached;
        }
        if (W - items[i].weight < 0) {
            return knapsack(items, W, i + 1, cache);
        }

        int toReturn = Math.max(knapsack(items, W - items[i].weight, i + 1, cache) + items[i].value,
                knapsack(items, W, i + 1, cache));
        cache.get(i).put(W, toReturn);
        return toReturn;
    }

    public static int bottomUpKnapsack(Item[] items, int W) {
        // cache[i][j] = max value for the first i items with a max weight of j
        int[][] cache = new int[items.length + 1][W + 1];
        for (int i = 1; i <= items.length; i++) {
            for (int j = 0; j <= W; j++) {
                // If including item[i-1] would exceed max weight j, don't
                // include the item. Otherwise take the max value of including
                // or excluding the item
                if (items[i - 1].weight > j) {
                    cache[i][j] = cache[i - 1][j];
                } else {
                    cache[i][j] = Math.max(
                            cache[i - 1][j],
                            cache[i - 1][j - items[i - 1].weight] + items[i - 1].value
                    );
                }
            }
        }
        return cache[items.length][W];
    }
}