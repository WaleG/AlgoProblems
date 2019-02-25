package solutions;

import java.util.Arrays;

/**
 * @author Valentyn.Moliakov
 */
public class Solution9MatrixSearch {

    public static boolean contains(int[][] arr, int x) {
        if (arr.length == 0 || arr[0].length == 0) {
            return false;
        }
        int row = 0;
        int col = arr[0].length - 1;
        while (row < arr.length && col >= 0) {
            if(arr[row][col] == x) {
                return true;
            } else if (arr[row][col] < x) {
                row++;
            } else {
                col--;
            }
        }
        return false;
    }
}
