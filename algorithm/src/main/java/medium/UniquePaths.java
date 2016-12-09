package algorithm.medium;

/**
 * Problem:
 * No: 62
 * Link: https://leetcode.com/problems/unique-paths/
 * <p/>
 * Analysis:
 * <p/>
 * Solution1:
 * Recursive solution.
 * <p/>
 * Solution2:
 * Dynamic programming solution.
 * <p/>
 * Reference:
 * http://www.cnblogs.com/springfor/p/3886603.html
 */
public class UniquePaths {
    public int uniquePathsSolution1(int m, int n) {
        if (m <= 0 || n <= 0) {
            return 0;
        }
        if (m == 1 || n == 1) {
            return 1;
        }

        return uniquePathsSolution1(m - 1, n) + uniquePathsSolution1(m, n - 1);
    }

    public int uniquePathsSolution2(int m, int n) {
        if (m <= 0 || n <= 0) {
            return 0;
        }

        int[][] paths = new int[m][n];
        for (int i = 0; i < m; i++) {
            paths[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            paths[0][i] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                paths[i][j] = paths[i - 1][j] + paths[i][j - 1];
            }
        }
        return paths[m - 1][n - 1];
    }
}
