package solutions.arrays;

/**
 * @author Valentyn.Moliakov
 */
public class Solution14Anagrams {

    public static boolean isAnagram(String a, String b) {
        if (a.length() == 0 || b.length() == 0 || a.length() != b.length()) {
            return false;
        }
        int[] chars = new int[256];
        for (char c : a.toCharArray()) {
            int index = Character.toLowerCase(c);
            chars[index]++;
        }
        for (char c : b.toCharArray()) {
            int index = Character.toLowerCase(c);
            chars[index]--;
            if (chars[index] < 0) {
                return false;
            }
        }
        for (int val : chars) {
            if (val != 0) return false;
        }
        return true;
    }
}
