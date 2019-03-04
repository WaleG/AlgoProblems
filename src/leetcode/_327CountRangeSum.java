package leetcode;

/**
 * @author Valentyn.Moliakov
 */
public class _327CountRangeSum {

    public static int countRangeSum(int[] nums, int lower, int upper) {
        int len = nums.length;
        if (lower > upper || len == 0) {
            return 0;
        }
        long[] sums = new long[len];
        sums[0] = nums[0];
        for (int i = 1; i < len; i++) {
            sums[i] = sums[i - 1] + nums[i];
        }
        return getCount(nums, 0, len - 1, sums, lower, upper);
    }

    private static int getCount(int[] nums, int left, int right, long[] sums, int lower, int upper) {
        if (left > right) {
            return 0;
        }
        if (left == right) {
            if (nums[left] <= upper && nums[right] >= lower) {
                return 1;
            } else {
                return 0;
            }
        }
        int mid = (left + right) / 2;
        int count = 0;
        for (int i = left; i <= mid; i++) {
            for (int j = mid + 1; j <= right; j++) {
                //sums[i] = 0 to i sum, inclusive
                // sums[j] = 0 to j sum, inclusive
                //sums[j] - sums[i] i + 1 to j sum
                //so we need to add nums[i] back
                long temp = sums[j] - sums[i] + nums[i];
                if (temp <= upper && temp >= lower) {
                    count++;
                }
            }
        }
        return count +
                getCount(nums, left, mid, sums, lower, upper) +
                getCount(nums, mid + 1, right, sums, lower, upper);
    }

    // Effective way - merge sort

    public int countRangeSumI(int[] nums, int lower, int upper) {
        if (nums == null || nums.length == 0 || lower > upper) return 0;

        long[] prefixArray = new long[nums.length + 1];

        for (int i = 1; i < prefixArray.length; i++) {
            prefixArray[i] = prefixArray[i - 1] + nums[i - 1];
        }

        return countRangeSumSub(prefixArray, 0, prefixArray.length - 1, lower, upper);
    }

    private int countRangeSumSub(long[] prefixArray, int l, int r, int lower, int upper) {
        if (l >= r) return 0;

        int m = l + (r - l) / 2;

        int count = countRangeSumSub(prefixArray, l, m, lower, upper) + countRangeSumSub(prefixArray, m + 1, r, lower, upper);

        long[] mergedArray = new long[r - l + 1];
        int i = l, j = m + 1, k = m + 1, p = 0, q = m + 1;

        while (i <= m) {
            while (j <= r && prefixArray[j] - prefixArray[i] < lower) j++;
            while (k <= r && prefixArray[k] - prefixArray[i] <= upper) k++;
            count += k - j;

            while (q <= r && prefixArray[q] < prefixArray[i]) mergedArray[p++] = prefixArray[q++];
            mergedArray[p++] = prefixArray[i++];
        }

        while (q <= r) mergedArray[p++] = prefixArray[q++];

        System.arraycopy(mergedArray, 0, prefixArray, l, mergedArray.length);

        return count;
    }

}
