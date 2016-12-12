package easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem:
 * No: 119
 * Link: https://leetcode.com/problems/pascals-triangle-ii/
 * <p/>
 * Analysis:
 * Calculate from the first row of pascal's triangle to the kth row.
 * Use the same array to record the last row and current row by calculate element from right to left.
 */
public class PascalTriangleII {
    public List<Integer> getRow(int rowIndex) {
        if (rowIndex < 0) {
            return null;
        }

        int[] row = new int[rowIndex + 1];
        row[0] = 1;
        for (int i = 1; i <= rowIndex; i++) {
            row[i] = 1;
            for (int j = i - 1; j > 0; j--) {
                row[j] = row[j - 1] + row[j];
            }
        }
        return parseToList(row);
    }

    private List<Integer> parseToList(int[] row) {
        if (row == null) {
            return null;
        }

        List<Integer> result = new ArrayList<Integer>();
        for (int i : row) {
            result.add(i);
        }
        return result;
    }
}
