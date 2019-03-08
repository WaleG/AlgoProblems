package leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Valentyn.Moliakov
 */
public class _36ValidSudoku {

    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'5', '3', '.', '.', '7', '.', '.', '.', ','},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        boolean solvable = isValidSudoku(board);
        System.out.println(solvable);
    }

    public static boolean isValidSudoku(char[][] board) {
        short[] rows = new short[9];
        short[] cols = new short[9];
        short[] squares = new short[9];

        for (int row = 0; row <= 8; row++) {
            for (int col = 0; col <= 8; col++) {
                if (board[row][col] == '.') {
                    continue;
                }

                short cell = (short) (1 << board[row][col] - '1');

                if ((cell & rows[row]) > 0 ||
                        (cell & cols[col]) > 0 ||
                        (cell & squares[3 * (row / 3) + col / 3]) > 0) {
                    return false;
                }

                rows[row] |= cell;
                cols[col] |= cell;
                squares[3 * (row / 3) + col / 3] |= cell;
            }
        }

        return true;
    }
}

