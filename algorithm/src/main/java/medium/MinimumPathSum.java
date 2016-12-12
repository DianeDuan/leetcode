package medium;

/**
 * Problem:
 * No: 64
 * Link: https://leetcode.com/problems/minimum-path-sum/
 * <p/>
 * Analysis:
 * Dynamic programming.
 * Use pathSums array record the minimum path sum when reach the point which is in position (i, j).
 */
public class MinimumPathSum {
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int row = grid.length;
        int column = grid[0].length;
        int[][] pathSums = new int[row][column];
        pathSums[0][0] = grid[0][0];
        for (int i = 1; i < row; i++) {
            pathSums[i][0] = pathSums[i - 1][0] + grid[i][0];
        }
        for (int i = 1; i < column; i++) {
            pathSums[0][i] = pathSums[0][i - 1] + grid[0][i];
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < column; j++) {
                pathSums[i][j] = Math.min(pathSums[i - 1][j], pathSums[i][j - 1]) + grid[i][j];
            }
        }
        return pathSums[row - 1][column - 1];
    }
}
