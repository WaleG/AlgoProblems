package leetcode;

/**
 * @author Valentyn.Moliakov
 */
public class _831ShortestDistanceToACharacter {

    public static int[] shortestToChar(String S, char C) {
        int[] dist = new int[S.length()];
        int lastCIndex = -1;
        for (int i = 0; i < S.length(); i++) {
            if (lastCIndex == -1) {
                dist[i] = S.length();
            } else {
                dist[i] = i - lastCIndex;
            }
            if (S.charAt(i) == C) {
                int curr = 0;
                int currIndex = i;
                while (currIndex >= 0 && dist[currIndex] > curr) {
                    dist[currIndex--] = curr++;
                }
                lastCIndex = i;
            }
        }
        return dist;
    }

}
