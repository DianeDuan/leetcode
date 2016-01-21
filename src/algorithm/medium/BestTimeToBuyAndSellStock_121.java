package algorithm.medium;

/**
 * Problem:
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 * <p/>
 * Analysis:
 * To make maximal profit, the difference between selling price and buying price should be maximal,
 * and there is an important condition: the selling day must behind the buying day.
 * So use a minPrice to record the minimal price before day i,
 * we can get the max profit value if we sell on day i,
 * and the max profit is the max of these values.
 */
public class BestTimeToBuyAndSellStock_121 {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }

        int maxProfit = 0;
        int minPrice = prices[0];
        for (int i = 1; i < prices.length; i++) {
            int currentMaxProfit = prices[i] - minPrice;
            if (currentMaxProfit > maxProfit) {
                maxProfit = currentMaxProfit;
            }
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            }
        }
        return maxProfit;
    }
}
