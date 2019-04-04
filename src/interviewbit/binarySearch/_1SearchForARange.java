package interviewbit.binarySearch;

import java.util.ArrayList;
import java.util.List;

public class _1SearchForARange {

    public ArrayList<Integer> searchRange(final List<Integer> a, int b) {
        ArrayList<Integer> result = new ArrayList<>();
        result.add(-1);
        result.add(-1);

        int lo = 0;
        int hi = a.size() - 1;

        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (a.get(mid) < b) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        int first = lo;

        if (lo < a.size() && a.get(lo) == b) {
            lo = 0;
            hi = a.size() - 1;
            while (lo < hi) {
                int mid = lo + (hi - lo + 1) / 2;
                if (a.get(mid) > b) {
                    hi = mid - 1;
                } else {
                    lo = mid;
                }
            }

            result.set(0, first);
            result.set(1, hi);
        }
        return result;
    }
}
