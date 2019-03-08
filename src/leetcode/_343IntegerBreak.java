package leetcode;

/**
 * @author Valentyn.Moliakov
 */
public class _343IntegerBreak {

    public int integerBreak(int n) {
        if (n <=  3) return n - 1;
        if (n % 3 == 0) return (int) Math.pow(3, n / 3);
        if (n % 3 == 1) return (int) Math.pow(3, n / 3 - 1) * 4;
        // if (n % 3 == 2)
        return (int) Math.pow(3, n / 3) * 2;
    }

    /*
    12
    3*3*3*3=81
    4*4*4=64
    14

    */
}
