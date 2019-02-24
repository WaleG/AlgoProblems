import solutions.Solution3MatrixProduct;

public class Main {

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1, 2, 3},
                {4, 5, -6},
                {-7, 8, 9}
        };
        int res = Solution3MatrixProduct.matrixProductDP(matrix);
        System.out.println(res);
    }
}
