package hard;

/**
 * Problem:
 * No: 188
 * Link: https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/
 * <p/>
 * Analysis:
 * Use a local array to record the maximum profit when in the ith day you complete the jth  transaction.
 * Use a global array to record the maximum profit when before the end of ith day you complete j transactions.
 * <p/>
 * Reference:
 * http://liangjiabin.com/blog/2015/04/leetcode-best-time-to-buy-and-sell-stock.html
 * http://www.cnblogs.com/grandyang/p/4295761.html
 */
public class BestTimeToBuyAndSellStockIV {
    public int maxProfit(int k, int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }

        if (k >= prices.length) {
            return maxProfitInFreeTrade(prices);
        }

        int[][] global = new int[prices.length][k + 1];
        int[][] local = new int[prices.length][k + 1];
        for (int i = 1; i < prices.length; i++) {
            int diff = prices[i] - prices[i - 1];
            for (int j = 1; j <= k; j++) {
                local[i][j] = Math.max(global[i - 1][j - 1], local[i - 1][j] + diff);
                global[i][j] = Math.max(global[i - 1][j], local[i][j]);
            }
        }
        return global[prices.length - 1][k];
    }

    //the maximum profit you can make by trading as many times as you want.
    private int maxProfitInFreeTrade(int[] prices) {
        if (prices == null) {
            return 0;
        }

        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                maxProfit += (prices[i] - prices[i - 1]);
            }
        }
        return maxProfit;
    }
}
