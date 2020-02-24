package learn.contest.jen;

import java.util.Objects;

/**
 * 1262. Greatest Sum Divisible by Three
 *
 * Given an array nums of integers, we need to find the maximum possible sum of elements of the array such that it is divisible by three.
 */
public class GreatestSumDivisibleByThree {
    public static void main(String[] args) {
        GreatestSumDivisibleByThree greatestSumDivisibleByThree = new GreatestSumDivisibleByThree();
        greatestSumDivisibleByThree.maxSumDivThree(new int[]{3,6,5,1,8});
    }
    /**
     * dp[][]
     *
     *
     * @param nums
     * @return
     */
    public int maxSumDivThree(int[] nums) {
        int[][] dp = new int[nums.length + 1][3];

        dp[0][0] = 0;
        dp[0][1] = Integer.MIN_VALUE;
        dp[0][2] = Integer.MIN_VALUE;
        for(int i = 1; i <= nums.length; i ++) {
            if(nums[i - 1] % 3 == 0) {
                dp[i][0] = nums[i - 1] + dp[i-1][0];
                dp[i][1] = nums[i - 1] + dp[i-1][1];
                dp[i][2] = nums[i - 1] + dp[i-1][2];
            } else if(nums[i - 1] % 3 == 1) {
                dp[i][0] = Math.max(dp[i-1][0], nums[i - 1] + dp[i-1][2]);
                dp[i][1] = Math.max(dp[i-1][1], nums[i - 1] + dp[i-1][0]);
                dp[i][2] = Math.max(dp[i-1][2], nums[i - 1] + dp[i-1][1]);
            } else if(nums[i - 1] % 3 == 2) {
                dp[i][0] = Math.max(dp[i-1][0], nums[i - 1] + dp[i-1][1]);
                dp[i][1] = Math.max(dp[i-1][1], nums[i - 1] + dp[i-1][2]);
                dp[i][2] = Math.max(dp[i-1][2], nums[i - 1] + dp[i-1][0]);
            }
        }

        return dp[nums.length][0];
    }
}
