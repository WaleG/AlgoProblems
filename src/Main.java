import solutions.Solution7SquareSubmatrix;

public class Main {

    public static void main(String[] args) {
            /*
    subarray([1, 1, 1, 0]
             [1, 1, 1, 1]
             [1, 1, 0, 0]) = 2
     */
        int[][] matrix = new int[][]{
                {0, 1, 1, 1},
                {1, 1, 1, 1},
                {1, 1, 1, 1}
        };
        int submatrix = Solution7SquareSubmatrix.submatrix(matrix);
        System.out.println(submatrix);
    }
}
