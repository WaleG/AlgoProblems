package leetcode;

/**
 * @author Valentyn.Moliakov
 */
public class _942DIStringMatch {

    public int[] diStringMatch(String S) {
        int N = S.length();
        int min = 0;
        int max = N;
        int[] result = new int[N + 1];
        for (int i = 0; i < N; i++) {
            if (S.charAt(i) == 'I') {
                result[i] = min++;
            } else {
                result[i] = max--;
            }
        }
        result[N] = min;
        return result;
    }
}
