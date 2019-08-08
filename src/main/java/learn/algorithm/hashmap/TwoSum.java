package learn.algorithm.hashmap;

import java.util.HashMap;
import java.util.Map;

/**
 * @author suidonglei
 * @title: TwoSum
 * @projectName algorithm-test
 * @description: 1
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * possible solutions:
 * 1.Traversal O(n2)
 * 2.hashMap(value:index) O(n)
 *
 * @date 2019/8/716:39
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        if (null == nums || nums.length < 2) return new int[]{};
        Map<Integer, Integer> valueMap = new HashMap<>();
        for(int index = 0; index < nums.length; index ++) {
            if(null != valueMap.get(target - nums[index])){
                return new int[]{index, valueMap.get(target - nums[index])};
            }
            valueMap.put(nums[index], index);
        }
        return new int[0];
    }
}
