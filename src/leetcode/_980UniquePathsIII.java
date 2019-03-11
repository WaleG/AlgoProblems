package leetcode;

public class _980UniquePathsIII {

    private class Point {
        int row;
        int col;

        Point(int row, int col) {
            this.row = row;
            this.col = col;
        }

        boolean isValid(int[][] grid) {
            return row >= 0 &&
                    row < grid.length &&
                    col >= 0 &&
                    col < grid[0].length &&
                    grid[row][col] != -1;
        }

    }

    private int count = 0;

    public int uniquePathsIII(int[][] grid) {
        int toVisit = 1;
        Point start = null;
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == 0) {
                    toVisit++;
                }
                if (grid[row][col] == 1) {
                    start = new Point(row, col);
                }
            }
        }
        count = 0;
        if (start == null) return count;
        dfs(grid, start, toVisit);
        return count;
    }

    private void dfs(int[][] grid, Point p, int toVisit) {
        if (!p.isValid(grid)) return;
        if (grid[p.row][p.col] == 2) {
            if (toVisit == 0) count++;
            return;
        }
        grid[p.row][p.col] = -1;
        dfs(grid, new Point(p.row - 1, p.col), toVisit - 1);
        dfs(grid, new Point(p.row + 1, p.col), toVisit - 1);
        dfs(grid, new Point(p.row, p.col - 1), toVisit - 1);
        dfs(grid, new Point(p.row, p.col + 1), toVisit - 1);
        grid[p.row][p.col] = 0;
    }
}
