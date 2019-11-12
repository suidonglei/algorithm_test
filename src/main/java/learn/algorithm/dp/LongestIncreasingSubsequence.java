package learn.algorithm.dp;

/**
 * 300
 * Given an unsorted array of integers, find the length of longest increasing subsequence.
 *
 */
public class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        if(null == nums || nums.length == 0) return 0;
        if(nums.length == 1) return 1;
        int maxCount[] = new int[nums.length];
        maxCount[0] = 1;
        for (int i = 1; i < nums.length; i ++) {
            Integer tempIndex = null;
            for (int j = 0; j < i; j++) {
                if(nums[j] < nums[i]) {
                    if(tempIndex == null) tempIndex = j;
                    else if(maxCount[tempIndex] < maxCount[j]) {
                        tempIndex = j;
                    }
                }
            }
            if(tempIndex != null) {
                maxCount[i] = maxCount[tempIndex] + 1;
            } else {
                maxCount[i] = 1;
            }
        }
        return getMax(maxCount);
    }

    int getMax(int[] nums) {
        int max = 0;
        for (int num: nums) {
            if(num > max) {
                max = num;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        LongestIncreasingSubsequence longestIncreasingSubsequence = new LongestIncreasingSubsequence();
        System.out.println(longestIncreasingSubsequence.lengthOfLIS(new int[]{10,9,2,5,3,7,101,18}));
    }
}
