package learn.contest.dec;

import java.util.Objects;

public class EvenNumber {
    class Solution {
        public int findNumbers(int[] nums) {
            int result = 0;
            if(Objects.isNull(nums)) return result;
            for(int num:nums) {
                int length = String.valueOf(num).length();
                if((length & 1) == 0)  result ++;
            }
            return result;
        }
    }
}