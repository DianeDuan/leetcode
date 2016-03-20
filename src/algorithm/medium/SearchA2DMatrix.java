package algorithm.medium;

/**
 * Problem:
 * No: 74
 * Link: https://leetcode.com/problems/search-a-2d-matrix/
 * <p/>
 * Analysis:
 * First use binary search to find the target row,
 * whose last element is greater than target and its upper row's last element is less than target,
 * this is the row we may find the target.
 * Then use binary search to find if the target is in the target row.
 */
public class SearchA2DMatrix {
    public boolean searchMatrix_solution1(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }

        int row = binarySearchRow(matrix, target, 0, matrix.length - 1);
        return row != -1 && binarySearchColumn(matrix, row, target, 0, matrix[row].length - 1);
    }

    private int binarySearchRow(int[][] matrix, int target, int start, int end) {
        if (start > end) {
            return -1;
        }

        int mid = (start + end) / 2;
        int last = matrix[mid][matrix[mid].length - 1];
        if (target > last) {
            return binarySearchRow(matrix, target, mid + 1, end);
        } else {
            if (mid == 0) {
                return mid;
            } else if (target > matrix[mid - 1][matrix[mid - 1].length - 1]) {
                return mid;
            } else {
                return binarySearchRow(matrix, target, start, mid - 1);
            }
        }
    }

    private boolean binarySearchColumn(int[][] matrix, int row, int target, int start, int end) {
        if (start > end) {
            return false;
        }

        int mid = (start + end) / 2;
        if (target > matrix[row][mid]) {
            return binarySearchColumn(matrix, row, target, mid + 1, end);
        } else {
            return target == matrix[row][mid] || binarySearchColumn(matrix, row, target, start, mid - 1);
        }
    }
}
