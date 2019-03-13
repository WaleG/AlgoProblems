package leetcode;

/**
 * @author Valentyn.Moliakov
 */
public class _8StringToIntegerAtoi {

    public int myAtoi(String str) {
        int i = 0, res = 0, sign = 1;
        if (str == null || str.length() == 0) {
            return 0;
        }
        while (i < str.length() && str.charAt(i) == ' ') {
            i++;
        }
        if (i < str.length() && (str.charAt(i) == '-' || str.charAt(i) == '+')) {
            sign = str.charAt(i) == '-' ? -1 : 1;
            i++;
        }
        for (; i < str.length(); i++) {
            int curr = str.charAt(i) - '0';
            if (curr < 0 || curr > 9) break;
            if (Integer.MAX_VALUE / 10 < res ||
                    Integer.MAX_VALUE / 10 == res && Integer.MAX_VALUE % 10 < curr) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            res = res * 10 + curr;
        }
        return sign * res;
    }
}
