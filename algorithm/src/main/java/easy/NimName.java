package easy;

/**
 * Problem:
 * No: 292
 * Link: https://leetcode.com/problems/nim-game/
 * <p/>
 * Analysis:
 * If you want to win a nim game of removing 1 to k stones,
 * the key point is you can make sure at least you have one chance that after you finish your removing,
 * the number of stones left is a multiple of (k + 1), and after that no matter how many stones your opponent removes,
 * you can always keep the the number of stones left after your turn is a multiple of (k + 1),
 * and in the last round you can easily win the game by removing all the left stones.
 * In this problem, you will take the first turn to remove stones, and we assume your opponent knows this strategy too,
 * so only the number of all the stones at the beginning of the game is decisive. That means if after you removes 1, 2
 * or 3 stones, the number of stones left is a multiple of 4, you will win.
 */

public class NimName {
    public boolean canWinNim(int n) {
        int k = 3;
        for (int i = 1; i <= k; i++) {
            if (((n - i) % (k + 1)) == 0) {
                return true;
            }
        }
        return false;
    }
}