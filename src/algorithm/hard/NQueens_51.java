package algorithm.hard;

import java.util.*;

/**
 * Problem:
 * https://leetcode.com/problems/n-queens/
 * <p/>
 * Analysis:
 * Recursive backtrace solution.
 */
public class NQueens_51 {
    public List<List<String>> solveNQueens(int n) {
        if (n <= 0) {
            return new ArrayList<List<String>>();
        }

        return getNQueensSolutions(n, new ArrayList<String>());
    }

    private List<List<String>> getNQueensSolutions(int n, List<String> currentSolution) {
        List<List<String>> result = new ArrayList<List<String>>();

        int currentRow = currentSolution.size();
        if (currentRow >= n) {
            result.add(new ArrayList<String>(currentSolution));
            return result;
        }

        for (int i = 0; i < n; i++) {
            if (canBePlaced(currentSolution, i)) {
                currentSolution.add(buildRow(n, i));
                result.addAll(getNQueensSolutions(n, currentSolution));
                currentSolution.remove(currentRow);
            }
        }
        return result;
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
