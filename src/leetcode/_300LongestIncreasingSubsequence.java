package leetcode;

import java.util.Arrays;

/**
 * @author Valentyn.Moliakov
 */
public class _300LongestIncreasingSubsequence {

    /*
    Brute Force. Time: O(2^n). Space: O(n)

    public int lengthOfLIS(int[] nums) {
        if (nums.length <= 1) return nums.length;
        return lis(nums, 0, Integer.MIN_VALUE);
    }

    private static int lis(int[] nums, int index, int prev) {
        if (index == nums.length) {
            return 0;
        }
        int taken = 0;
        if (nums[index] > prev) {
            taken = 1 + lis(nums, index + 1, nums[index]);
        }
        int nottaken = lis(nums, index + 1, prev);
        return Math.max(taken, nottaken);
    }
     */

    /*
    With memoization. Time: O(n^2). Space: O(n^2)

    public int lengthOfLIS(int[] nums) {
        int[][] memo = new int[nums.length + 1][nums.length];
        for (int[] l : memo) {
            Arrays.fill(l, -1);
        }
        return lis(nums, 0, -1, memo);
    }

    private static int lis(int[] nums, int index, int prevIndex, int[][] memo) {
        if (index == nums.length) {
            return 0;
        }
        if (memo[prevIndex + 1][index] >= 0) {
            return memo[prevIndex + 1][index];
        }
        int taken = 0;
        if (prevIndex < 0 || nums[index] > nums[prevIndex]) {
            taken = 1 + lis(nums, index + 1, index, memo);
        }
        int nottaken = lis(nums, index + 1, prevIndex, memo);
        memo[prevIndex + 1][index] = Math.max(taken, nottaken);
        return memo[prevIndex + 1][index];
    }
     */

    /*
    DP. Time: O(n^2). Space: O(n)
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int maxAns = 1;
        for (int i = 1; i < dp.length; i++) {
            int maxVal = 0;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    maxVal = Math.max(maxVal, dp[j]);
                }
            }
            dp[i] = maxVal + 1;
            maxAns = Math.max(maxAns, dp[i]);
        }
        return maxAns;
    }
    */

    /*
    DP + binary search. Time: O(nlog(n)). Space: O(n)
     */

    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int len = 0;
        for (int num : nums) {
            int i = Arrays.binarySearch(dp, 0, len, num);
            if (i < 0) {
                i = -(i + 1);
                dp[i] = num;
                if (i == len) {
                    len++;
                }
            }
        }
        return len;
    }
}
