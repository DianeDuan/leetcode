package algorithm.medium;

/**
 * Problem:
 * https://leetcode.com/problems/spiral-matrix-ii/
 * <p/>
 * Analysis:
 * Simulate the process of spirally assigning values to elements in the matrix.
 */
public class SpiralMatrixII_59 {
    public int[][] generateMatrix(int n) {
        if (n <= 0) {
            return new int[0][0];
        }

        int[][] matrix = new int[n][n];
        int top = 0;
        int bottom = n - 1;
        int left = 0;
        int right = n - 1;
        int number = 1;
        while ((top <= bottom) && (left <= right)) {
            for (int i = left; i <= right; i++) {
                matrix[top][i] = number;
                number++;
            }
            top++;
            for (int i = top; i <= bottom; i++) {
                matrix[i][right] = number;
                number++;
            }
            right--;
            for (int i = right; i >= left; i--) {
                matrix[bottom][i] = number;
                number++;
            }
            bottom--;
            for (int i = bottom; i >= top; i--) {
                matrix[i][left] = number;
                number++;
            }
            left++;
        }
        return matrix;
    }
}
