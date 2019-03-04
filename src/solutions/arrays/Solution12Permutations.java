package solutions.arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Valentyn.Moliakov
 */
public class Solution12Permutations {

    public static List<String> stringPermutations(String s) {
        List<String> result = new ArrayList<>();
        stringPermutations("", s, result);
        return result;
    }

    private static void stringPermutations(String prefix, String suffix, List<String> result) {
        if (suffix.length() == 0) {
            result.add(prefix);
        } else {
            for (int i = 0; i < suffix.length(); i++) {
                stringPermutations(prefix + suffix.charAt(i), suffix.substring(0, i) + suffix.substring(i + 1), result);
            }
        }
    }

    public static List<int[]> listPermutations(int[] a) {
        List<int[]> result = new ArrayList<>();
        listPermutations(a, 0, result);
        return result;
    }

    private static void listPermutations(int[] a, int start, List<int[]> result) {
        if (start == a.length) {
            result.add(a.clone());
        } else {
            for (int i = start; i < a.length; i++) {
                swap(a, start, i);
                listPermutations(a, i, result);
                swap(a, start, i);
            }
        }
    }

    private static void swap(int[] a, int i, int j) {
        int tmp = a[j];
        a[j] = a[i];
        a[i] = tmp;
    }
}
