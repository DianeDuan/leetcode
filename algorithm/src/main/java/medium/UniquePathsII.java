package medium;

/**
 * Problem:
 * No: 63
 * Link: https://leetcode.com/problems/unique-paths-ii/
 * <p/>
 * Analysis:
 * Dynamic programming solution.
 * The solution of unique paths II problem is different from the solution of unique paths in processing the obstacle cells in the grid.
 * If a cell is marked as obstacle, the count of paths to reach it is 0.
 */
public class UniquePathsII {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0].length == 0) {
            return 0;
        }

        int length = obstacleGrid.length;
        int width = obstacleGrid[0].length;
        int[][] pathCounts = new int[length][width];
        //init the first row
        int initCount = 1;
        for (int i = 0; i < width; i++) {
            if (obstacleGrid[0][i] == 1) {
                initCount = 0;
            }
            pathCounts[0][i] = initCount;
        }
        //init the first column
        initCount = 1;
        for (int i = 0; i < length; i++) {
            if (obstacleGrid[i][0] == 1) {
                initCount = 0;
            }
            pathCounts[i][0] = initCount;
        }
        //calculate the counts of paths to reach other cells in grid
        for (int i = 1; i < length; i++) {
            for (int j = 1; j < width; j++) {
                if (obstacleGrid[i][j] == 0) {
                    pathCounts[i][j] = pathCounts[i - 1][j] + pathCounts[i][j - 1];
                } else {
                    pathCounts[i][j] = 0;
                }
            }
        }
        return pathCounts[length - 1][width - 1];
    }
}
