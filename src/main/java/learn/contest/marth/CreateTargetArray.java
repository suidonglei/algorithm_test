package learn.contest.marth;

import java.util.LinkedList;
import java.util.List;

public class CreateTargetArray {
    public int[] createTargetArray(int[] nums, int[] index) {
        List<Integer> resultList = new LinkedList<>();
        for(int i = 0; i < nums.length; i++) {
            resultList.add(index[i], nums[i]);
        }
        int[] resut = new int[nums.length];
        for(int i = 0; i < resut.length; i++) {
            resut[i] = resultList.get(i);
        }
        return resut;
    }
}
