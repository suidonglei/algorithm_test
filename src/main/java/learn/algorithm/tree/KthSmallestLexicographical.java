package learn.algorithm.tree;

import java.util.Objects;

/**
 * 440. K-th Smallest in Lexicographical Order
 *
 */
public class KthSmallestLexicographical {
    public int findKthNumber(int n, int k) {
        int curr = 0;
        if (k > n || n < 1) {
            return curr;
        }
        curr ++;
        k--;
        while (k>0) {
            int curStep = countStep(n, curr, curr + 1);
            if(curStep > k) {
                curr *= 10;
                k --;
            } else {
                k -= curStep;
                curr ++;
            }
        }

        return curr;
    }

    private int countStep(int n, long curr, long next) {
        int steps = 0;
        while(curr <= n) {
            steps += Math.min(n + 1, next) - curr;
            curr *= 10;
            next *= 10;
        }
        return steps;
    }

    public static int lengthOfLIS(int[] nums) {
        /**
         * int length[];
         *
         * length[x] = max(length[0...x-1])         nums[max] >= nums[x]
         *           = max(length[0...x-1])  + 1    nums[max] < nums[x]
         *
         *
         * */
         if(nums== null || nums.length< 1) return 0;

         int[] length = new int[nums.length];
         length[0] = 1;

         for(int i = 1; i < nums.length; i ++) {
         int tempCount = 0;
         for(int j = 0; j <= i; j ++) {
         if(nums[j] < nums[i] && length[j] >= tempCount) {
         tempCount = length[j] + 1;
         }
         if(nums[j] >= nums[i] && length[j] > tempCount) {
         tempCount = length[j];
         }
         }
         length[i] = tempCount;
         }

         return length[nums.length -1];

    }


    public static int getMaxSum(int[] nums) {
        if(Objects.isNull(nums) || nums.length == 0) return 0;
        int[] sums = new int[nums.length];
        sums[0] = nums [0];
        if(nums.length < 2) {
            return nums[0];
        }
        sums[1] = Math.max(nums[0], nums[1]);

        for(int i = 2; i < nums.length; i ++) {
            int tempMax = 0;
            for(int j = 0; j < i - 1; j ++) {
                if(sums[j] > tempMax) tempMax = sums[j];
            }
            sums[i] = Math.max(sums[i-1], tempMax + nums[i]);
        }
        return sums[nums.length - 1];
    }

    public static void main(String[] args) {


        System.out.println(getMaxSum(new int[]{1,5,2,1,7}));
    }


}
