package learn.contest.dec;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * 1296. Divide Array in Sets of K Consecutive Numbers
 *
 * Given an array of integers nums and a positive integer k,
 * find whether it's possible to divide this array into sets of k consecutive numbers
 * Return True if its possible otherwise return False.
 */
public class ConsecutiveNumbers {
    public boolean isPossibleDivide(int[] nums, int k) {
        if(Objects.isNull(nums)) return false;
        int[] operNums = Arrays.copyOf(nums, nums.length);
        if(nums.length % k != 0) return false;
        Arrays.sort(operNums);
        Map<Integer, Integer> numMap = new HashMap<>();
        for (int num : operNums) {
            if(Objects.isNull(numMap.get(num))) {
                numMap.put(num, 1);
            } else {
                numMap.put(num, numMap.get(num) + 1);
            }
        }
        if(numMap.size() < k) return false;
        int tempMinValue = operNums[0], start = operNums[0];
        int tempMinCount = numMap.get(operNums[0]);
        int count = 0;
        while(operNums[operNums.length-1] - tempMinValue >= k - 1) {
            for(int i = 1; i < k; i ++) {
                //获取num 到 num + k - 1 的最小出现次数 及 num1
                if(Objects.isNull(numMap.get(start + i))) {
                    return false;
                }
                if(numMap.get(start + i) <= tempMinCount) {
                    tempMinValue = start + i;
                    tempMinCount = numMap.get(start + i);
                }
            }
            for(int t = start; t <= tempMinValue; t ++) {
                if((numMap.get(t) - tempMinCount) != 0)
                    return false;
                numMap.put(t, 0);
            }
            count = count + tempMinCount;
            for(int j = tempMinValue + 1; j < start + k; j++) {
                numMap.put(j, numMap.get(j) - tempMinCount);
            }
            start = tempMinValue + 1;
            while (Objects.isNull(numMap.get(start)) && start < operNums[operNums.length-1])
                start ++;
            tempMinValue = start;
            if(Objects.nonNull(numMap.get(start))) {
                tempMinCount = numMap.get(start);
            } else {
                tempMinCount = 0;
            }
        }
        return count > 0;
    }

    public static void main(String[] args) {
        ConsecutiveNumbers consecutiveNumbers = new ConsecutiveNumbers();
        System.out.println(consecutiveNumbers.isPossibleDivide(new int[]{3,2,1,2,3,4,3,4,5,9,10,11}, 3));
    }

}
