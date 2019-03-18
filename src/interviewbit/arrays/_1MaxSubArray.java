package interviewbit.arrays;

import java.util.List;

/**
 * @author Valentyn.Moliakov
 */
public class _1MaxSubArray {

    /*
    Given the array [-2,1,-3,4,-1,2,1,-5,4],

    the contiguous subarray [4,-1,2,1] has the largest sum = 6.

     */

    public int maxSubArray(final List<Integer> A) {
        if (A == null || A.size() == 0) return 0;
        int maxSoFar = A.get(0);
        int maxEndedHere = A.get(0);
        for (int i = 1; i < A.size(); i++) {
            maxEndedHere = Math.max(A.get(i), maxEndedHere + A.get(i));
            maxSoFar = Math.max(maxEndedHere, maxSoFar);
        }
        return maxSoFar;
    }
}
