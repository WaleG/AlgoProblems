package solutions.arrays;

/**
 * @author Valentyn.Moliakov
 */
public class Solution6ZeroMatrix {

    public static void zeroMatrix(boolean[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return;
        boolean nullifyFirstRow = false;
        boolean nullifyFirstColumn = false;
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0]) {
                nullifyFirstColumn = true;
                break;
            }
        }
        for (int j = 0; j < matrix[0].length; j++) {
            if (matrix[0][j]) {
                nullifyFirstRow = true;
                break;
            }
        }
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j]) {
                    matrix[0][j] = true;
                    matrix[i][0] = true;
                }
            }
        }
        for (int j = 1; j < matrix[0].length; j++) {
            if (matrix[0][j]) {
                nullifyColumn(matrix, j);
            }
        }
        for (int i = 1; i < matrix[0].length; i++) {
            if (matrix[i][0]) {
                nullifyRow(matrix, i);
            }
        }
        if (nullifyFirstColumn) {
            nullifyColumn(matrix, 0);
        }
        if (nullifyFirstRow) {
            nullifyRow(matrix, 0);
        }
    }

    private static void nullifyRow(boolean[][] matrix, int i) {
        for (int j = 0; j < matrix[0].length; j++) {
            matrix[i][j] = true;
        }
    }

    private static void nullifyColumn(boolean[][] matrix, int j) {
        for (int i = 0; i < matrix.length; i++) {
            matrix[i][j] = true;
        }
    }
}
