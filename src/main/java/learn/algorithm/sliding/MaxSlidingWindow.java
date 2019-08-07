package learn.algorithm.sliding;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

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
        int[] returnArray = new int[nums.length - k + 1];
        int returnIndex = 0;
        Deque<Integer> deque = new ArrayDeque<>(k);//存储下标
        for(int i = 0; i < nums.length; i ++) {
            if(i >= k && deque.peekFirst() <= i-k) {
                deque.removeFirst();
            }
            while(deque.size() > 0 && nums[deque.peekLast()] <= nums[i]){
                deque.removeLast();
            }
            deque.addLast(i);
            if(i >= k - 1) {
                returnArray[returnIndex] = nums[deque.peekFirst()];
                returnIndex ++;
            }
        }
        return returnArray;
    }

    public static void main(String[] args) {
        int[] intArray = new int[]{1, 3, 1, 2, 0, 5};
        System.out.println(maxSlidingWindow(intArray, 3));
    }
}
