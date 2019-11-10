package learn.algorithm.dp;

import java.util.Arrays;
import java.util.Collections;

/**
 * 188. Best Time to Buy and Sell Stock IV
 *
 *
 * Say you have an array for which the i-th element is the price of a given stock on day i.
 *
 * Design an algorithm to find the maximum profit. You may complete at most k transactions.
 *
 * Note:
 * You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 *
 */
public class BestTimeBuySellStockK {

    /**
     * 动态规划算法求解
     *
     * @param k
     * @param prices
     * @return
     */
    public int maxProfit(int k, int[] prices) {
        if (null == prices || prices.length < 2 || k == 0) return 0;
        //if k >= n/2, then you can make maximum number of transactions.
        if (k >=  prices.length/2) {
            int maxPro = 0;
            for (int i = 1; i < prices.length; i++) {
                if (prices[i] > prices[i-1])
                    maxPro += prices[i] - prices[i-1];
            }
            return maxPro;
        }
        //状态标识
        Integer[][][] maxPro = new Integer[prices.length][k + 1][2];
        maxPro[0][1][1] = -prices[0];
        maxPro[0][0][0] = 0;
        for (int i = 1; i < prices.length; i ++) {
            for (int t = 0; t <= k; t++) {
                if (t == 0) {
                    maxPro[i][t][0] = maxPro[i-1][t][0];
                } else {
                    if(null != maxPro[i-1][t][1] && null != maxPro[i-1][t][0]) {
                        maxPro[i][t][0] = Math.max(maxPro[i-1][t][0], maxPro[i-1][t][1] + prices[i]);
                    } else if (null != maxPro[i-1][t][1]) {
                        maxPro[i][t][0] = maxPro[i-1][t][1] + prices[i];
                    } else {
                        maxPro[i][t][0] = maxPro[i-1][t][0];
                    }
                    if(null != maxPro[i-1][t][1] && null != maxPro[i-1][t-1][0]) {
                        maxPro[i][t][1] = Math.max(maxPro[i-1][t][1], maxPro[i-1][t-1][0] - prices[i]);
                    } else  if (null != maxPro[i-1][t-1][0]) {
                        maxPro[i][t][1] = maxPro[i-1][t-1][0] - prices[i];
                    } else {
                        maxPro[i][t][1] = maxPro[i-1][t][1];
                    }
                }
                if(maxPro[i-1][t][0] == null && maxPro[i-1][t][1] == null) {
                    break;
                }
            }
        }
        Integer[] profs = new Integer[k + 1];
        for(int i = 0; i <= k; i ++) {
            if(null != maxPro[prices.length - 1][i][0])
                profs[i] = maxPro[prices.length - 1][i][0];
            else
                profs[i] = 0;
        }
        return Collections.max(Arrays.asList(profs));
    }

    public static void main(String[] args) {
        BestTimeBuySellStockK bestTimeBuySellStockK = new BestTimeBuySellStockK();
        System.out.println(bestTimeBuySellStockK.maxProfit(1, new int[]{1,2,4,1}));
        System.out.println(bestTimeBuySellStockK.maxProfit(1, new int[]{2,1,5,1,8}));
        System.out.println(bestTimeBuySellStockK.maxProfit(2, new int[]{1,2,4,9}));
        System.out.println(bestTimeBuySellStockK.maxProfit(2, new int[]{2,4,1}));
    }

}
