package learn.algorithm.search;

public class SmallerThanCurrentNumber {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] result = new int[nums.length];

        for(int i = 0; i < nums.length; i ++) {
            int tempValue =  nums[i];
            for(int j = 0; j < nums.length; j++) {
                if (tempValue < nums[j]) {
                    result[j] ++;
                }
            }
         }

        return result;
    }
}
