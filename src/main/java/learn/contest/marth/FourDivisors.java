package learn.contest.marth;

import java.util.ArrayList;
import java.util.List;

public class FourDivisors {
    public int sumFourDivisors(int[] nums) {
        Integer sum = 0;
        for(int num: nums) {
            List<Integer> integerList = new ArrayList<>();
            for(int i = 1; i <= Math.sqrt(num); i ++) {
                if(i == Math.sqrt(num)) {
                    if(num % i == 0) {
                        integerList.add(i);
                    }
                } else if(num % i == 0) {
                    integerList.add(i);
                    integerList.add(num/i);
                }
                if(integerList.size() > 4) {
                    break;
                }
            }
            if(integerList.size() == 4) {
                sum = sum + integerList.get(0) + integerList.get(1) + integerList.get(2) + integerList.get(3);
            }
        }
        return sum;
    }
}
