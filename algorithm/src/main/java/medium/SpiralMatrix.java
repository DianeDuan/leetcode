package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem:
 * No: 54
 * Link: https://leetcode.com/problems/spiral-matrix/
 * <p/>
 * Analysis:
 * Simulate the spiral traversal of the matrix.
 */
public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return new ArrayList<Integer>();
        }

        List<Integer> result = new ArrayList<Integer>();
        int top = 0;
        int bottom = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;
        while ((top <= bottom) && (left <= right)) {
            for (int i = left; i <= right; i++) {
                result.add(matrix[top][i]);
            }
            top++;
            for (int i = top; i <= bottom; i++) {
                result.add(matrix[i][right]);
            }
            right--;
            for (int i = right; i >= left; i--) {
                if (bottom < top) {//avoid traverse the same row twice
                    break;
                }
                result.add(matrix[bottom][i]);
            }
            bottom--;
            for (int i = bottom; i >= top; i--) {
                if (left > right) {//avoid traverse the same column twice
                    break;
                }
                result.add(matrix[i][left]);
            }
            left++;
        }
        return result;
    }
}
