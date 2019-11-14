package learn.algorithm.dp;

/**
 * 322. Coin Change
 *
 * You are given coins of different denominations and a total amount of money amount.
 * Write a function to compute the fewest number of coins that you need to make up that amount.
 * If that amount of money cannot be made up by any combination of the coins, return -1.
 */
public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        if(null == coins || coins.length < 1) return -1;
        if(amount < 1) return -1;
        int[] changes = new int[amount + 1];
        for(int i = 1; i < changes.length; i ++) {
            changes[i] = -1;
        }
        for (int i = 1; i <= amount; i ++) {
            int min = Integer.MAX_VALUE;
            for(int j = 0; j < coins.length; j ++) {
                if (i - coins[j] >= 0 && changes[i - coins[j]] != -1 && changes[i - coins[j]] < min) {
                    min = changes[i - coins[j] ];
                }
            }
            if(min != Integer.MAX_VALUE) changes[i] = min + 1;
        }
        return changes[amount];
    }

    public int coinChange1(int[] coins, int amount) {
        if(null == coins || coins.length < 1) return -1;
        if(amount < 1) return -1;
        int[] changes = new int[amount + 1];
        for(int i = 1; i < changes.length; i ++) {
            changes[i] = -1;
        }
        for (int i = 1; i <= amount; i ++) {
            int min = Integer.MAX_VALUE;
            for(int j = 0; j < coins.length; j ++) {
                if (i - coins[j] >= 0 && changes[i - coins[j]] != -1 && changes[i - coins[j]] < min) {
                    min = changes[i - coins[j] ];
                }
            }
            if(min != Integer.MAX_VALUE) changes[i] = min + 1;
        }
        return changes[amount];
    }
}
