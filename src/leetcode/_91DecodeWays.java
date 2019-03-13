package leetcode;

/**
 * @author Valentyn.Moliakov
 */
public class _91DecodeWays {

    public static int numDecodings(String s) {
        if (s.length() == 0 || (s.charAt(0) == '0')) {
            return 0;
        }
        int prev = 1;
        int prePrev = 1;
        int cur = prev;
        for (int i = 2; i <= s.length(); i++) {
            cur = 0;
            if (s.charAt(i - 1) > '0') {
                cur = prev;
            }
            if (s.charAt(i - 2) == '1' ||
                    (s.charAt(i - 2) == '2' && s.charAt(i - 1) < '7')) {
                cur += prePrev;
            }
            prePrev = prev;
            prev = cur;
        }
        return cur;
    }
}
