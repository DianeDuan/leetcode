package medium;

/**
 * Problem:
 * No: 79
 * Link: https://leetcode.com/problems/word-search/
 * <p/>
 * Analysis:
 * Recursive backtrace solution.
 * <p/>
 * Reference:
 * http://www.cnblogs.com/springfor/p/3883942.html
 */
public class WordSearch {
    public boolean exist(char[][] board, String word) {
        if (board == null || word == null) {
            return false;
        }

        int rowCount = board.length;
        int columnCount = board[0].length;
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < columnCount; j++) {
                if (isExist(board, i, j, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isExist(char[][] board, int row, int column, String word, int pos) {
        if (pos >= word.length()) {
            return true;
        }
        if (row < 0 || row >= board.length || column < 0 || column >= board[0].length) {
            return false;
        }
        if (word.charAt(pos) != board[row][column]) {
            return false;
        }

        board[row][column] = '#';
        boolean result = isExist(board, row + 1, column, word, pos + 1)
                || isExist(board, row - 1, column, word, pos + 1)
                || isExist(board, row, column + 1, word, pos + 1)
                || isExist(board, row, column - 1, word, pos + 1);
        board[row][column] = word.charAt(pos);
        return result;
    }
}
