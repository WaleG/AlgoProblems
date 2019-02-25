import solutions.Solution11ZeroSumSubarray;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] A = new int[]{1, 2, 3, -6};
        int[] zeroSum = Solution11ZeroSumSubarray.subArray(A);
        System.out.println(Arrays.toString(zeroSum));
    }
}
