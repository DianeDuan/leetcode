package algorithm.hard;

/**
 * Problem:
 * No: 123
 * Link: https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/
 * <p/>
 * Analysis:
 * We can only complete at most 2 transactions,
 * so we can separate these prices into two parts,
 * the first part for the first transaction and the second part for the second transaction.
 * Use preProfit array to record the max profit of the first transaction which is completed before or on day i,
 * and use postProfit array to record the max profit of the second transaction which is completed after or on day i.
 * The maximum of all the (preProfit[i] + postProfit[i]) is the maximum profit.
 * <p/>
 * Reference:
 * http://liangjiabin.com/blog/2015/04/leetcode-best-time-to-buy-and-sell-stock.html
 */
public class BestTimeToBuyAndSellStockIII {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }

        int[] preProfit = new int[prices.length];
        preProfit[0] = 0;
        int currentMin = prices[0];
        for (int i = 1; i < prices.length; i++) {
            preProfit[i] = Math.max(preProfit[i - 1], prices[i] - currentMin);
            if (prices[i] < currentMin) {
                currentMin = prices[i];
            }
        }

        int[] postProfit = new int[prices.length];
        postProfit[prices.length - 1] = 0;
        int currentMax = prices[prices.length - 1];
        for (int i = (prices.length - 2); i > -1; i--) {
            postProfit[i] = Math.max(postProfit[i + 1], currentMax - prices[i]);
            if (prices[i] > currentMax) {
                currentMax = prices[i];
            }
        }

        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            int totalProfit = preProfit[i] + postProfit[i];
            if (totalProfit > maxProfit) {
                maxProfit = totalProfit;
            }
        }
        return maxProfit;
    }
}
