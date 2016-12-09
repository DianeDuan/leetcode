package algorithm.medium;

/**
 * Problem:
 * No: 122
 * Link: https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
 * <p/>
 * Analysis:
 * Greedy algorithm for this problem: if the price of dat i is higher than the day (i-1),
 * buy one on the day (i-1), and sell it on the day i.
 * Attention: the greedy algorithm can be used to make the maximal profit here is because
 * we are allowed to complete as many transactions as we want,
 * and that means after you sell one share, you can buy one share the same day.
 */
public class BestTimeToBuyAndSellStockII {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
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
