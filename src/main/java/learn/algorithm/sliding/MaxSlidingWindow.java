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
 * 1.sort O(n ·logK) 大顶堆
 * 2.without sort O(n ·1)  in linear time  deque
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
    public static int[] maxSlidingWindow(int[] nums, int k) {
        if(null == nums || nums.length == 0) return new int[]{};
        int[] returnArray = new int[nums.length - (k -1)];
        int index1 = 0, index2 = 0, value1 = nums[0], value2 = nums[0];
        if(nums.length > 1) {
            index2 = 1;
            value2 = nums[1];
        }
        int returnIndex = 0, firstIndex = 0;
        for(int i = 0; i < nums.length; i ++) {
            if((i - firstIndex + 1) > k) {//达到窗口
                returnArray[returnIndex] = value1;
                returnIndex ++;
                if(index1 <= firstIndex) {
                    index1 = index2;
                    value1 = value2;
                    if(index1 < (nums.length - 1)) {
                        index2 = index1 + 1;
                        value2 = nums[index1 + 1];
                    }
                }
                firstIndex ++;
            }
            if(nums[i] >= nums[index1]) {
                index1 = i;
                value1 = nums[i];
                if(index2 == index1) {
                    if(index1 < (nums.length - 1)) {
                        index2 = index1 + 1;
                        value2 = nums[index1 + 1];
                    }
                }
            } else if(nums[i] >= nums[index2]){
                index2 = i;
                value2 = nums[i];
            }
            if(i == nums.length - 1) {
                returnArray[returnIndex] = value1;
            }
        }
        return returnArray;
    }

    public static void main(String[] args) {
        int[] intArray = new int[]{1, 3, 1, 2, 0, 5};
        System.out.println(maxSlidingWindow(intArray, 3));
    }
}
