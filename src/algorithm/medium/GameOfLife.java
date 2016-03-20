package algorithm.medium;

/**
 * Problem:
 * No: 289
 * Link: https://leetcode.com/problems/game-of-life/
 * <p/>
 * Analysis:
 * Use different number to represent this generation status and next generation status.
 * These numbers are:
 * 0 this generation is dead
 * 1 this generation is live
 * 2 this generation is dead, next generation is live
 * 3 this generation is dead, next generation is dead
 * 4 this generation is live, next generation is live
 * 5 this generation is live, next generation is dead
 */
public class GameOfLife {
    public void gameOfLife(int[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return;
        }

        int rowCount = board.length;
        int columnCount = board[0].length;
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < columnCount; j++) {
                int count = countLiveNeighbors(board, i, j);
                boolean isNextGenAlive = isNextGenAlive(board[i][j], count);
                if (board[i][j] == 0) {
                    if (isNextGenAlive) {
                        board[i][j] = 2;
                    } else {
                        board[i][j] = 3;
                    }
                } else if (board[i][j] == 1) {
                    if (isNextGenAlive) {
                        board[i][j] = 4;
                    } else {
                        board[i][j] = 5;
                    }
                }
            }
        }

        //change to next generation board
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < columnCount; j++) {
                if (board[i][j] == 2 || board[i][j] == 4) {
                    board[i][j] = 1;
                } else {
                    board[i][j] = 0;
                }
            }
        }
    }

    private int countLiveNeighbors(int[][] board, int row, int column) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return 0;
        }

        int count = 0;
        if (isAlive(board, row - 1, column)) {//the upper neighbor
            count++;
        }
        if (isAlive(board, row + 1, column)) {//the lower neighbor
            count++;
        }
        if (isAlive(board, row, column - 1)) {//the left neighbor
            count++;
        }
        if (isAlive(board, row, column + 1)) {//the right neighbor
            count++;
        }
        if (isAlive(board, row - 1, column - 1)) {//the left upper neighbor
            count++;
        }
        if (isAlive(board, row + 1, column - 1)) {//the left lower neighbor
            count++;
        }
        if (isAlive(board, row - 1, column + 1)) {//the right upper neighbor
            count++;
        }
        if (isAlive(board, row + 1, column + 1)) {//the right lower neighbor
            count++;
        }
        return count;
    }

    private boolean isAlive(int[][] board, int row, int column) {
        if (row > -1 && row < board.length && column > -1 && column < board[0].length) {
            return board[row][column] == 1 || board[row][column] == 4 || board[row][column] == 5;
        }
        return false;
    }

    private boolean isNextGenAlive(int current, int aliveNeighborCount) {
        if (current == 0 && aliveNeighborCount == 3) {
            return true;
        } else if (current == 1 && aliveNeighborCount == 2 || aliveNeighborCount == 3) {
            return true;
        } else {
            return false;
        }
    }
}