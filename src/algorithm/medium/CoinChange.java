package algorithm.medium;

/**
 * Problem:
 * No: 322
 * Link: https://leetcode.com/problems/coin-change/
 * <p/>
 * Analysis:
 * Dynamic programming.
 * The minCounts[i] equals to the minimal count of coins that can make up amount whose value is i.
 * <p/>
 * Reference:
 * https://www.hrwhisper.me/leetcode-coin-change/
 */
public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        if (coins == null || amount < 0) {
            return -1;
        }

        int[] minCounts = new int[amount + 1];
        for (int i = 1; i < minCounts.length; i++) {
            minCounts[i] = -1;
        }

        for (int i = 0; i <= amount; i++) {
            for (int denomination : coins) {
                int min;
                if ((i + denomination) <= amount && (min = nonNegativeMin(minCounts[i] + 1, minCounts[i + denomination])) > 0) {
                    minCounts[i + denomination] = min;
                }
            }
        }
        return minCounts[amount];
    }

    private int nonNegativeMin(int a, int b) {
        if (a < 0) {
            return b;
        }
        if (b < 0) {
            return a;
        }
        return Math.min(a, b);
    }
}
