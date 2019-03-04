package uber;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Valentyn.Moliakov
 */
public class _37SudokuSolver {

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
        System.out.println(Arrays.deepToString(board));
        boolean solvable = sudokuSolve(board);
        System.out.println(Arrays.deepToString(board));
        System.out.println(solvable);
    }

    public static boolean sudokuSolve(char[][] board) {
        int row = -1;
        int col = -1;
        Set<Character> candidates = null;
        for (int r = 0; r <= 8; r++) {
            for (int c = 0; c <= 8; c++) {
                if (board[r][c] == '.') {
                    Set<Character> newCandidates = getCandidates(board, r, c);
                    if (candidates == null || newCandidates.size() < candidates.size()) {
                        candidates = newCandidates;
                        row = r;
                        col = c;
                    }
                }
            }
        }

        if (candidates == null) {
            return true;
        }

        for (Character c: candidates) {
            board[row][col] = c;
            if (sudokuSolve(board)) {
                return true;
            }
            board[row][col] = '.';
        }
        
        return false;
    }

    private static Set<Character> getCandidates(char[][] board, int row, int col) {
        Set<Character> candidates = new HashSet<>();

        for (char chr = '1'; chr <= '9'; chr++) {
            boolean collision = false;
            for (int i = 0; i <= 8; i++) {
                if (board[row][i] == chr ||
                        board[i][col] == chr ||
                        board[row - (row % 3) + i / 3][col - (col % 3) + i % 3] == chr) {
                    collision = true;
                    break;
                }
            }
            if (!collision) {
                candidates.add(chr);
            }
        }

        return candidates;
    }
}

