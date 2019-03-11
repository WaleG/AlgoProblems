package leetcode;

import java.util.*;

public class _895MaximumFrequencyStack {

    Map<Integer, Integer> freq;
    int maxFreq;
    Map<Integer, Stack<Integer>> group;

    public _895MaximumFrequencyStack() {
        freq = new HashMap<>();
        group = new HashMap<>();
        maxFreq = 0;
    }

    public void push(int x) {
        int f = freq.getOrDefault(x, 0) + 1;
        freq.put(x, f);
        if (f > maxFreq) {
            maxFreq = f;
        }
        group.computeIfAbsent(f, s -> new Stack<>()).push(x);
    }

    public int pop() {
        int x = group.get(maxFreq).pop();
        freq.put(x, freq.get(x) - 1);
        if (group.get(maxFreq).size() == 0) {
            maxFreq--;
        }
        return x;
    }
}
