package medium;

/**
 * Problem:
 * No: 419
 * Link: https://leetcode.com/problems/battleships-in-a-board/
 * <p>
 * Analysis:
 * <p>
 * Solution1:
 * Count the horizontal battleships and then count the vertical battleships.
 * Note that we need to skip the vertilcal battileships when we count horizontal battleships.
 * <p>
 * Solution2:
 * Get the battleships total count by counting the first slots of those battleships,
 * which means only count those slots whose left slot and upper slot are not 'X'.
 * This is a one pass solution.
 */
public class BattleshipsInABoard {
    public int countBattleshipsSolution1(char[][] board) {
        if (board == null || board.length == 0) {
            return 0;
        }

        int count = 0;
        int rowCount = board.length, columnCount = board[0].length;
        for (int i = 0; i < rowCount; i++) {//count horizontal battleships
            for (int j = 0; j < columnCount; j++) {
                if (board[i][j] == 'X') {
                    boolean isVertical = false;
                    if ((i - 1) >= 0 && board[i - 1][j] == 'X') {
                        isVertical = true;
                    }
                    if ((i + 1) < rowCount && board[i + 1][j] == 'X') {
                        isVertical = true;
                    }

                    if (!isVertical) {
                        count++;

                        //skip horizontally consecutive X character
                        while ((j + 1) < columnCount && board[i][j + 1] == 'X') {
                            j++;
                        }
                    }
                }
            }
        }

        for (int j = 0; j < columnCount; j++) {//count vertical battleships
            for (int i = 0; i < rowCount; i++) {
                if (board[i][j] == 'X') {
                    if ((i + 1) < rowCount && board[i + 1][j] == 'X') {
                        count++;
                    }

                    //skip vertically consecutive X character
                    while ((i + 1) < rowCount && board[i + 1][j] == 'X') {
                        i++;
                    }
                }
            }
        }
        return count;
    }

    public int countBattleshipsSolution2(char[][] board) {
        if (board == null || board.length == 0) {
            return 0;
        }

        int count = 0;
        int rowCount = board.length, columnCount = board[0].length;
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < columnCount; j++) {
                if (board[i][j] == 'X') {
                    if ((i - 1) >= 0 && board[i - 1][j] == 'X') {
                        continue;
                    }
                    if ((j - 1) >= 0 && board[i][j - 1] == 'X') {
                        continue;
                    }
                    count++;
                }
            }
        }
        return count;
    }
}
