package learn.algorithm.recursion;

/**
 * @author suidonglei
 * @title: MajorityElement
 * @projectName algorithm-test
 * @description: 169
 * Given an array of size n, find the majority element.
 * The majority element is the element that appears more than ⌊ n/2 ⌋ times.
 * You may assume that the array is non-empty and the majority element always exist in the array.
 *
 * possible solutions:
 * 1.Map            O(N)
 * 2.sort--->count  O(nlogn)
 * 3.divide         O(nlogn) wrong
 *
 * @date 2019/8/1515:17
 */
public class MajorityElement {
    public int majorityElement(int[] nums) {
        return devideElements(nums, 0, nums.length-1, 0);
    }

    private int devideElements(int[] nums, int left, int right, Integer count) {
        if(left == right) {
            count = 1;
            return nums[left];
        }
        Integer countLeft = 0;
        Integer countRight = 0;
        int mid = (left + right)/2;
        int leftReturn = devideElements(nums, left, mid, countLeft);
        int rightReturn = devideElements(nums, mid, right, countRight);
        if(leftReturn == rightReturn) {
            count = countLeft + countRight;
            return leftReturn;
        } else {
            if(countLeft > countRight) {
                count = countLeft;
                return leftReturn;
            }
            count = countRight;
            return rightReturn;
        }
    }

}
