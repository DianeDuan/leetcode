package algorithm.medium;

/**
 * Problem:
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/
 * <p/>
 * Analysis:
 * This is a dynamic programming problem.
 * Use a buy array to record the max profit when at the end of the i day you have a stock.
 * And use a sell array to record the max profit when at the end of the i day you don't have a stock.
 * The value of variable i is from 0 to (prices.length - 1).
 * If you have a stock in the day i, you can either buy a stock or do nothing in the day i,
 * the max profit of buying a stock in the day i is sell[i-2] - prices[i],
 * the max profit of doing nothing in the day i is buy[i-1],
 * so there is a equation: buy[i] = max(sell[i-2] - prices[i], buy[i-1]).
 * If you don't have a stock in the day i, you can either sell a stock or do nothing in the day i,
 * the max profit of selling a stock in the day i is buy[i-1] + prices[i],
 * the max profit of doing nothing in the day i is sell[i-1],
 * so there is a equation: sell[i] = max(buy[i-1] + prices[i], sell[i-1]).
 * <p/>
 * Reference:
 * https://segmentfault.com/a/1190000004193861
 */
public class BestTimeToBuyAndSellStockWithCooldown_309 {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }

        int[] buy = new int[prices.length];
        int[] sell = new int[prices.length];

        buy[0] = -prices[0];
        buy[1] = Math.max(-prices[0], -prices[1]);
        sell[0] = 0;
        sell[1] = Math.max(0, prices[1] - prices[0]);

        for (int i = 2; i < prices.length; i++) {
            sell[i] = Math.max(sell[i - 1], buy[i - 1] + prices[i]);
            buy[i] = Math.max(buy[i - 1], sell[i - 2] - prices[i]);
        }

        return sell[prices.length - 1];
    }
}
