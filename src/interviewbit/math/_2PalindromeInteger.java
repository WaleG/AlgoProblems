package interviewbit.math;

/**
 * @author Valentyn.Moliakov
 */
public class _2PalindromeInteger {
    public int isPalindrome(int A) {
        if (A < 0) return 0;
        int B = 0;
        int tmp = A;
        while (tmp > 0) {
            B += tmp % 10;
            tmp /= 10;
            if (tmp > 0) {
                B *= 10;
            }
        }
        if (B == A) return 1;
        return 0;
    }
}
