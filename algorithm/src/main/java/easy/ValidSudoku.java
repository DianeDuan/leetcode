package easy;

import java.util.HashMap;
import java.util.Map;

/**
 * Problem:
 * No: 36
 * Link: https://leetcode.com/problems/valid-sudoku/
 * <p/>
 * Analysis:
 * Check every row.
 * Check every column.
 * Check every sub-box.
 */
public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            char[] row = board[i];
            if (!isValid(row)) {
                return false;
            }
        }

        for (int i = 0; i < 9; i++) {
            char[] column = getColumn(board, i);
            if (!isValid(column)) {
                return false;
            }
        }

        Map<Integer, int[]> subBoxIndexes = initSubBoxIndexes();
        for (int i = 0; i < 9; i++) {
            int[] rowAndCol = subBoxIndexes.get(i);
            char[] subBox = getSubBox(board, rowAndCol[0], rowAndCol[1]);
            if (!isValid(subBox)) {
                return false;
            }
        }

        return true;
    }

    private boolean isValid(char[] array) {
        if (array == null || array.length != 9) {
            return false;
        }
        Map<Character, Boolean> map = init();
        for (char ch : array) {
            if (ch == '.') {
                continue;
            }
            if (!map.containsKey(ch)) {
                return false;
            }
            if (map.get(ch)) {
                return false;
            } else {
                map.put(ch, true);
            }
        }
        return true;
    }

    private Map<Character, Boolean> init() {
        Map<Character, Boolean> map = new HashMap<Character, Boolean>();
        map.put('0', false);
        map.put('1', false);
        map.put('2', false);
        map.put('3', false);
        map.put('4', false);
        map.put('5', false);
        map.put('6', false);
        map.put('7', false);
        map.put('8', false);
        map.put('9', false);
        return map;
    }

    private char[] getColumn(char[][] board, int columnNo) {
        char[] column = new char[9];
        for (int i = 0; i < 9; i++) {
            column[i] = board[i][columnNo];
        }
        return column;
    }

    private Map<Integer, int[]> initSubBoxIndexes() {
        Map<Integer, int[]> result = new HashMap<Integer, int[]>();
        result.put(0, new int[]{0, 0});
        result.put(1, new int[]{0, 3});
        result.put(2, new int[]{0, 6});
        result.put(3, new int[]{3, 0});
        result.put(4, new int[]{3, 3});
        result.put(5, new int[]{3, 6});
        result.put(6, new int[]{6, 0});
        result.put(7, new int[]{6, 3});
        result.put(8, new int[]{6, 6});
        return result;
    }

    private char[] getSubBox(char[][] board, int rowNo, int columnNo) {
        char[] box = new char[9];
        int position = 0;
        for (int i = 0; i < 3; i++) {
            int row = rowNo + i;
            for (int j = 0; j < 3; j++) {
                int column = columnNo + j;
                box[position] = board[row][column];
                position++;
            }
        }
        return box;
    }
}
