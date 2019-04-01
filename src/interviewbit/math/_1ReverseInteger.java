package interviewbit.math;

/**
 * @author Valentyn.Moliakov
 */
public class _1ReverseInteger {
    public int reverse(int A) {
        boolean negative = false;
        if (A < 0) {
            A /= -1;
            negative = true;
        }
        int B = 0;
        while (A > 0) {
            B += A % 10;
            A /= 10;
            if (A > 0) {
                if (B > Integer.MAX_VALUE / 10) return 0;
                B *= 10;
            }
        }
        if (negative) B /= -1;
        return B;
    }
}
