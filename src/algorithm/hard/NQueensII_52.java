package algorithm.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Problem:
 * https://leetcode.com/problems/n-queens-ii/
 * <p/>
 * Analysis:
 * Recursive backtrace solution.
 */
public class NQueensII_52 {
    public int totalNQueens(int n) {
        if (n <= 0) {
            return 0;
        }

        return getSolutionCount(n, new ArrayList<String>(), 0);
    }

    private int getSolutionCount(int n, List<String> currentSolution, int count) {
        int currentRow = currentSolution.size();
        if (currentRow >= n) {
            return count + 1;
        }

        for (int i = 0; i < n; i++) {
            if (canBePlaced(currentSolution, i)) {
                currentSolution.add(buildRow(n, i));
                count = getSolutionCount(n, currentSolution, count);
                currentSolution.remove(currentRow);
            }
        }
        return count;
    }

    private boolean canBePlaced(List<String> currentSolution, int newColumn) {
        int currentRow = currentSolution.size();
        for (int j = 0; j < currentRow; j++) {//check from the first row to the upper row of current row
            int queenColumn = currentSolution.get(j).indexOf('Q');//get the queen column number in the jth row
            if (queenColumn == newColumn || (Math.abs(newColumn - queenColumn) == (currentRow - j))) {
                return false;
            }
        }
        return true;//all upper rows checked, this row's queen can be placed here
    }

    private String buildRow(int column, int qPos) {
        char[] row = new char[column];
        Arrays.fill(row, '.');
        row[qPos] = 'Q';
        return new String(row);
    }
}
