import org.junit.Test;

import java.util.*;

public class ThreeSumTest {
    @Test
    public void should_() {
        Solution solution = new Solution();
//        List<List<Integer>> indexLists
    }
}

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> returnList = new ArrayList<>();
        if(null == nums || nums.length < 3) {
            return returnList;
        }
        Arrays.sort(nums);
        //solution 1:两次loop 运用set结构去除第三次循环
        Set<String> contSet = new HashSet<>();
        for(int i = 0; i < nums.length - 2; i ++) {
            //去重
            if(i >= 1 && nums[i] == nums[i-1]) {
                continue;
            }
            Set<Integer> tempSet = new HashSet<>();
            for(int j = i+1; j < nums.length; j ++) {
                if(tempSet.contains(nums[j])) {
                    List<Integer> tempList = new ArrayList<>();
                    tempList.add(nums[i]);
                    tempList.add(-nums[i]-nums[j]);
                    tempList.add(nums[j]);
                    if(contSet.add(tempList.toString())) {
                        returnList.add(tempList);
                    }
                } else {
                    tempSet.add(-nums[i]-nums[j]);
                }
            }
        }
        return returnList;
    }
}