package learn.algorithm.greedy;

/**
 * 122
 * Say you have an array for which the ith element is the price of a given stock on day i.
 *
 * Design an algorithm to find the maximum profit. You may complete as many transactions as you like (i.e., buy one and sell one share of the stock multiple times).
 *
 * Note: You may not engage in multiple transactions at the same time (i.e., you must sell the stock before you buy again).
 *
 * possible solutions:
 * DFS
 * greedy :只要后一天的价格比前一天的价格高就在前一天买入后一天卖出 o(n)
 * dynamic programing
 *
 */
public class SellStock {
    public int maxProfit(int[] prices) {
        int profit = 0;
        for(int i = 0; i < prices.length; i++) {
            if(i + 1 < prices.length && prices[i+1] > prices[i]) {
                profit += prices[i+1] - prices[i];
            }
        }
        return  profit;

    }
}
