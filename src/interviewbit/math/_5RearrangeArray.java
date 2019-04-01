package interviewbit.math;

import java.util.ArrayList;

public class _5RearrangeArray {
    public void arrange(ArrayList<Integer> a) {
        int n = a.size();
        for (int i = 0; i < n; i++) { // 1
            a.set(i, a.get(i) +(a.get(a.get(i)) % n) * n);
        }
        for (int i = 0; i < n; i++) {
            a.set(i, a.get(i) / n);
        }
    }
}
