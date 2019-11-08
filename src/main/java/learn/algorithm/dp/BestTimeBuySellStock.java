package learn.algorithm.dp;

/**
 * 121  121. Best Time to Buy and Sell Stock
 * Say you have an array for which the ith element is the price of a given stock on day i.
 *
 * If you were only permitted to complete at most one transaction (i.e., buy one and sell one share of the stock),
 * design an algorithm to find the maximum profit.
 *
 * Note that you cannot sell a stock before you buy one.
 *
 */
public class BestTimeBuySellStock {
    /**
     * 记录一个最小值  和 最大 利润
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        if (null == prices || prices.length < 2) return 0;
        int minPrice = prices[0];
        int maxProfit = prices[1] - prices[0];
        for (int i = 1; i < prices.length; i ++) {
            if (prices[i] < minPrice) minPrice = prices[i];
            if ((prices[i] - minPrice) > maxProfit) maxProfit = prices[i] - minPrice;
        }
        return maxProfit;
    }
}
