package solutions;

/**
 * @author Valentyn.Moliakov
 */
public class Solution7SquareSubmatrix {

    public static int submatrix(int[][] matrix) {
        int[][] cache = new int[matrix.length][matrix[0].length];
        int max = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (i == 0 || j == 0) {
                    cache[i][j] = matrix[i][j];
                } else if (matrix[i][j] == 1) {
                    cache[i][j] = Math.min(
                            Math.min(
                                    cache[i - 1][j],
                                    cache[i][j - 1]
                            ),
                            cache[i - 1][j - 1]) + 1;
                }
                max = Math.max(cache[i][j], max);
            }
        }
        return max;
    }

}
