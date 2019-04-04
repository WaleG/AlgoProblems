package leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author Valentyn.Moliakov
 */
public class _56MergeIntervals {

    public class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }

    public List<Interval> merge(List<Interval> intervals) {
        if (intervals == null || intervals.size() <= 1) return intervals;
        intervals.sort(Comparator.comparingInt(i -> i.start));
        List<Interval> result = new ArrayList<>();
        for (Interval interval : intervals) {
            int lastIndex = result.size() - 1;
            if (result.isEmpty() || result.get(lastIndex).end < interval.start) {
                result.add(interval);
            } else {
                result.get(lastIndex).end = Math.max(
                        result.get(lastIndex).end,
                        interval.end
                );
            }
        }
        return result;
    }
}
