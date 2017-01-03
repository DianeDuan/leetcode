package easy;

import provided.GuessGame;

/**
 * Problem:
 * No: 374
 * Link: https://leetcode.com/problems/guess-number-higher-or-lower/
 * <p>
 * Analysis:
 * Binary search.
 */
public class GuessNumberHigherOrLower extends GuessGame {
    public int guessNumber(int n) {
        int left = 1, right = n;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int flag = guess(mid);
            if (flag == 0) {
                return mid;
            } else if (flag < 0) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return 0;
    }
}
