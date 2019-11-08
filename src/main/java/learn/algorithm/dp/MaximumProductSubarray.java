package learn.algorithm.dp;

import java.util.Arrays;


/**
 * 152 max product substring  最大乘积子序列
 *
 * Given an integer array nums,
 * find the contiguous subarray within an array (containing at least one number) which has the largest product.
 *
 */
public class MaximumProductSubarray {
    /**
     * 动态规划算法
     * @param nums
     * @return
     */
    public int maxProduct(int[] nums) {
        if(null == nums) return 0;
        int[] max= new int[nums.length], min = new int[nums.length];
        max[0] = nums[0];
        min[0] = nums[0];
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] < 0) {
                max[i] = Math.max(min[i-1] * nums[i], nums[i]);
                min[i] = Math.min(max[i-1] * nums[i], nums[i]);
            } else {
                max[i] = Math.max(max[i-1] * nums[i], nums[i]);
                min[i] = Math.min(min[i-1] * nums[i], nums[i]);
            }
        }
        Arrays.sort(max);
        return max[max.length - 1];
    }
}
