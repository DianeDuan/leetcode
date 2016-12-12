package medium;

/**
 * Problem:
 * No: 73
 * Link: https://leetcode.com/problems/set-matrix-zeroes/
 * <p/>
 * Analysis:
 * <p/>
 * solution1:
 * Use an array to record if elements of row i should be set to zeroes.
 * Use the other array to record if elements of column i should be set to zeroes.
 * <p/>
 * Solution2:
 * Use the first row and the first column to record information.
 * <p/>
 * Reference:
 * http://www.cnblogs.com/springfor/p/3888003.html
 */
public class SetMatrixZeroes {
    //space complexity: O(m+n)
    public void setZeroesSolution1(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return;
        }

        int rowCount = matrix.length;
        int columnCount = matrix[0].length;

        boolean[] rows = new boolean[rowCount];
        boolean[] columns = new boolean[columnCount];

        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < columnCount; j++) {
                if (matrix[i][j] == 0) {
                    rows[i] = true;
                    columns[j] = true;
                }
            }
        }

        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < columnCount; j++) {
                if (rows[i] || columns[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    //space complexity: O(1)
    public void setZeroesSolution2(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return;
        }

        int rowCount = matrix.length;
        int columnCount = matrix[0].length;

        boolean firstRowHasZero = false;
        boolean firstColumnHasZero = false;

        for (int i = 0; i < columnCount; i++) {
            if (matrix[0][i] == 0) {
                firstRowHasZero = true;
                break;
            }
        }

        for (int i = 0; i < rowCount; i++) {
            if (matrix[i][0] == 0) {
                firstColumnHasZero = true;
            }
        }

        for (int i = 1; i < rowCount; i++) {
            for (int j = 1; j < columnCount; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for (int i = 1; i < rowCount; i++) {
            for (int j = 1; j < columnCount; j++) {
                if ((matrix[i][0] == 0) || (matrix[0][j] == 0)) {
                    matrix[i][j] = 0;
                }
            }
        }

        if (firstRowHasZero) {
            for (int i = 0; i < columnCount; i++) {
                matrix[0][i] = 0;
            }
        }

        if (firstColumnHasZero) {
            for (int i = 0; i < rowCount; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}
