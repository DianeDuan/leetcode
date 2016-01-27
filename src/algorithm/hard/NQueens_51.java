package algorithm.hard;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem:
 * https://leetcode.com/problems/n-queens/
 * <p/>
 * Analysis:
 */
public class NQueens_51 {
    public List<List<String>> solveNQueens(int n) {
        if (n <= 0) {
            return new ArrayList<List<String>>();
        }
        List<List<String>> solutions = new ArrayList<List<String>>();
        return null;
    }

    private char[][] initChessboard(int n) {
        char[][] chessboard = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                chessboard[i][j] = '.';
            }
        }
        return chessboard;
    }
}
