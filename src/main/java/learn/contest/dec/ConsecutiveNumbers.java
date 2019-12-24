package learn.contest.dec;

import java.util.*;

/**
 * 1296. Divide Array in Sets of K Consecutive Numbers
 *
 * Given an array of integers nums and a positive integer k,
 * find whether it's possible to divide this array into sets of k consecutive numbers
 * Return True if its possible otherwise return False.
 */
public class ConsecutiveNumbers {
    public boolean isPossibleDivide(int[] nums, int k) {
        if(Objects.isNull(nums))
            return false;
        if(nums.length % k != 0)
            return false;
        //greedy algorithm
        int[] operNums = Arrays.copyOf(nums, nums.length);
        Arrays.sort(operNums);

        Map<Integer, Integer> numMap = new HashMap<>();
        for (int num : operNums) {
            if(Objects.isNull(numMap.get(num))) {
                numMap.put(num, 1);
            } else {
                numMap.put(num, numMap.get(num) + 1);
            }
        }
        int start = operNums[0];
        while (start < operNums[operNums.length - 1]) {
            int startCount = numMap.get(start);
            for(int i = 0; i < k; i ++) {
                if(Objects.isNull(numMap.get(start + i)))
                    return false;
                if(numMap.get(start + i) - numMap.get(start) < 0)
                    return false;
                numMap.put(start + i, numMap.get(start + i) - startCount);
            }
            start ++;
            while((Objects.isNull(numMap.get(start)) || numMap.get(start) == 0) && start <= operNums[operNums.length - 1]) {
                start ++;
            }
        }
        return true;

        /*int[] operNums = Arrays.copyOf(nums, nums.length);
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
        return count > 0;*/
    }

    public boolean isPossibleDividePriority(int[] nums, int k) {
        int len = nums.length;
        if (len % k != 0) {
            return false;
        }

        PriorityQueue<Integer> minHeap = new PriorityQueue<>(len);
        for (int num : nums) {
            minHeap.offer(num);
        }

        while (!minHeap.isEmpty()) {
            Integer top = minHeap.poll();

            for (int i = 1; i < k; i++) {
                // 从 1 开始，正好需要移除 k - 1 个元素
                // i 正好就是相对于 top 的偏移
                // 注意：这个 remove 操作会线性去扫 top + i 的索引，时间复杂度是 O(N)
                if (!minHeap.remove(top + i)) {
                    // 如果移除失败，说明划分不存在，直接返回 false 即可
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        ConsecutiveNumbers consecutiveNumbers = new ConsecutiveNumbers();
        System.out.println(consecutiveNumbers.isPossibleDivide(new int[]{1,2,3,3,4,4,5,6}, 4));
    }
}
