package algorithm.medium;

/**
 * Problem:
 * No: 240
 * Link: https://leetcode.com/problems/search-a-2d-matrix-ii/
 * <p/>
 * Analysis:
 * Start comparing from the top right corner of the matrix.
 * If target is greater than the right top corner element,
 * it cannot be in this row as each row is ascending,
 * continue to search the next row.
 * If target is less than the right top corner element,
 * it cannot be in this column as each column is ascending,
 * continue to search the previous column.
 */
public class SearchA2DMatrixII {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int currentRow = 0;
        int currentColumn = matrix[0].length - 1;
        while (currentRow < matrix.length && currentColumn > -1) {
            int current = matrix[currentRow][currentColumn];
            if (current == target) {
                return true;
            } else if (current < target) {
                currentRow++;
            } else {
                currentColumn--;
            }
        }
        return false;
    }
}
