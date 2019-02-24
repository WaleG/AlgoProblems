package solutions;

import java.util.PriorityQueue;

/**
 * @author Valentyn.Moliakov
 */
public class Solution3MatrixProduct {

    public static PriorityQueue<Integer> maxQ;

    public static int matrixProduct(int[][] matrix) {
        maxQ = new PriorityQueue<>((x, y) -> y - x);
        matrixProduct(matrix, 0, 0, 1);
        return maxQ.element();
    }

    private static void matrixProduct(int[][] matrix, int i, int j, int product) {
        product *= matrix[i][j];
        if (i == matrix.length - 1 && j == matrix.length - 1) {
            maxQ.add(product);
        } else if (i == matrix.length - 1) {
            matrixProduct(matrix, i, j + 1, product);
        } else if (j == matrix[0].length - 1) {
            matrixProduct(matrix, i + 1, j, product);
        } else {
            matrixProduct(matrix, i + 1, j, product);
            matrixProduct(matrix, i, j + 1, product);
        }
    }

    public static int matrixProductDP(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int[][] maxCache = new int[matrix.length][matrix[0].length];
        int[][] minCache = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (i == 0 && j == 0) {
                    maxCache[i][j] = matrix[i][j];
                    minCache[i][j] = matrix[i][j];
                } else {
                    int maxVal = Integer.MIN_VALUE;
                    int minVal = Integer.MAX_VALUE;
                    if (i > 0) {
                        int tempMax = Math.max(
                                maxCache[i - 1][j] * matrix[i][j],
                                minCache[i - 1][j] * matrix[i][j]
                        );
                        int tempMin = Math.min(
                                maxCache[i - 1][j] * matrix[i][j],
                                minCache[i - 1][j] * matrix[i][j]
                        );
                        maxVal = Math.max(maxVal, tempMax);
                        minVal = Math.min(minVal, tempMin);
                    }
                    if (j > 0) {
                        int tempMax = Math.max(
                                maxCache[i][j - 1] * matrix[i][j],
                                minCache[i][j - 1] * matrix[i][j]
                        );
                        int tempMin = Math.min(
                                maxCache[i][j - 1] * matrix[i][j],
                                minCache[i][j - 1] * matrix[i][j]
                        );
                        maxVal = Math.max(maxVal, tempMax);
                        minVal = Math.min(minVal, tempMin);
                    }
                    maxCache[i][j] = maxVal;
                    minCache[i][j] = minVal;
                }
            }
        }
        return maxCache[matrix.length - 1][matrix[0].length - 1];
    }
}
