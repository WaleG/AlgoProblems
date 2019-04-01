package leetcode;

public class _9PalindromeNumber {

    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        int tmp = x;
        int y = 0;
        while (tmp > 0) {
            y += tmp % 10;
            tmp /= 10;
            if (tmp > 0) y *= 10;
        }
        return y == x;
    }
}
