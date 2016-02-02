package algorithm.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem:
 * https://leetcode.com/problems/pascals-triangle/
 * <p/>
 * Analysis:
 * Calculate current row elements by the last rows' elements.
 * The first and the last element of current row is 1,
 * other elements satisfy this equation: row[i] = lastRow[i-1] + lastRow[i]
 */
public class PascalTriangle_118 {
    public List<List<Integer>> generate(int numRows) {
        if (numRows <= 0) {
            return new ArrayList<List<Integer>>();
        }

        List<List<Integer>> result = init();
        for (int rowNumber = 2; rowNumber <= numRows; rowNumber++) {
            List<Integer> row = new ArrayList<Integer>();
            List<Integer> lastRow = result.get(rowNumber - 2);
            result.add(row);

            row.add(1);//add the first element of current row
            for (int j = 1; j < rowNumber; j++) {
                int element;
                if (j != (rowNumber - 1)) {//current element is not the last element of this row
                    element = lastRow.get(j - 1) + lastRow.get(j);
                } else {
                    element = 1;//the last element of current row
                }
                row.add(element);
            }
        }

        return result;
    }

    private List<List<Integer>> init() {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> firstRow = new ArrayList<Integer>();
        firstRow.add(1);
        result.add(firstRow);
        return result;
    }
}
