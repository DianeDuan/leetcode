package algorithm.medium;

/**
 * Problem:
 * https://leetcode.com/problems/rotate-image/
 * <p/>
 * Analysis:
 * <p/>
 * Solution1:
 * Flip the matrix along the inverse diagonal,
 * and then flip the matrix along the horizontal middle line.
 * <p/>
 * Solution2:
 * Rotate four elements at a time.
 * <p/>
 * Reference:
 * http://fisherlei.blogspot.com/2013/01/leetcode-rotate-image.html
 * http://www.cnblogs.com/springfor/p/3886487.html
 */
public class RotateImage_48 {
    public void rotate_solution1(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return;
        }

        int n = matrix.length;

        //along the inverse diagonal
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < (n - 1 - i); j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[n - 1 - j][n - 1 - i];
                matrix[n - 1 - j][n - 1 - i] = tmp;
            }
        }

        //along the horizontal middle line
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < n; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[n - 1 - i][j];
                matrix[n - 1 - i][j] = tmp;
            }
        }
    }

    public void rotate_solution2(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return;
        }

        int n = matrix.length;
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < Math.ceil(n / 2.0); j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[n - 1 - j][i];
                matrix[n - 1 - j][i] = matrix[n - 1 - i][n - 1 - j];
                matrix[n - 1 - i][n - 1 - j] = matrix[j][n - 1 - i];
                matrix[j][n - 1 - i] = tmp;
            }
        }
    }
}
