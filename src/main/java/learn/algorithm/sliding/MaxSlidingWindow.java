package learn.algorithm.sliding;

/**
 * @author suidonglei
 * @title: MaxSlidingWindow
 * @projectName algorithm-test
 * @description: 239
 * Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right.
 * You can only see the k numbers in the window. Each time the sliding window moves right by one position. Return the max sliding window.
 *
 * possible solutions:
 * 1.sort O(n nlogn)
 * 2.without sort O(n)  in linear time
 *
 * @date 2019/8/618:39
 */
public class MaxSlidingWindow {
    /**
     * assume k is always valid, 1 ≤ k ≤ input array's size for non-empty array.
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] returnArray = new int[nums.length/k + 1];
        int index1 = 0, index2 = 0, value1 = nums[0], value2 = nums[0];
        for(int i = 0; i < nums.length; i ++) {
            if(nums[i] >= nums[index1]) {

            }
        }
        return null;
    }
}
