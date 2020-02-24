package learn.contest.jen;

import java.security.AllPermission;
import java.util.*;

/**
 * 1363. Largest Multiple of Three
 *
 * Given an integer array of digits, return the largest multiple of three that can be formed by concatenating some of the given digits in any order.
 *
 * Since the answer may not fit in an integer data type, return the answer as a string.
 *
 * If there is no answer return an empty string.
 */

public class LargestMultipleofThree {

    class Element{
        List<Integer> data = new ArrayList<>();
        int sum = 0;
        public Element add(Integer value) {
            Element element = new Element();
            element.data = new ArrayList<>();
            element.data.addAll(this.data);
            element.data.add(value);
            element.sum += value;
            return element;
        }
    }
    /**
     * dp
     *
     * @param digits
     * @return
     */
    public String largestMultipleOfThree(int[] digits) {
        Element[][] sp = new Element[digits.length + 1][3];
        sp[0][0] = new Element();

        for(int i = 1; i <= digits.length; i++) {
            if(digits[i] % 3 == 0) {
                sp[i][0] = sp[i-1][0].add(digits[i]);
                sp[i][1] = sp[i-1][1];
                sp[i][2] = sp[i-1][2];
            } else if(digits[i] % 3 == 1) {
                if(Objects.nonNull(sp[i-1][2]) && sp[i-1][2].sum + digits[i] > sp[i-1][0].sum) {
                    sp[i][0] = sp[i-1][2].add(digits[i]) ;
                } else {
                    sp[i][0] = sp[i-1][0];
                }

                if(Objects.nonNull(sp[i-1][0]) && sp[i-1][0].sum + digits[i] > sp[i-1][1].sum) {
                    sp[i][1] = sp[i-1][0].add(digits[i]) ;
                } else {
                    sp[i][1] = sp[i-1][1];
                }

                if(Objects.nonNull(sp[i-1][1]) && sp[i-1][1].sum + digits[i] > sp[i-1][2].sum) {
                    sp[i][2] = sp[i-1][1].add(digits[i]) ;
                } else {
                    sp[i][2] = sp[i-1][2];
                }

            } else if(digits[i] % 3 == 2) {
                if(Objects.nonNull(sp[i-1][1]) && sp[i-1][1].sum + digits[i] > sp[i-1][0].sum) {
                    sp[i][0] = sp[i-1][1].add(digits[i]) ;
                } else {
                    sp[i][0] = sp[i-1][0];
                }

                if(Objects.nonNull(sp[i-1][2]) && sp[i-1][2].sum + digits[i] > sp[i-1][1].sum) {
                    sp[i][1] = sp[i-1][0].add(digits[i]) ;
                } else {
                    sp[i][1] = sp[i-1][1];
                }

                if(Objects.nonNull(sp[i-1][0]) && sp[i-1][0].sum + digits[i] > sp[i-1][2].sum) {
                    sp[i][2] = sp[i-1][1].add(digits[i]) ;
                } else {
                    sp[i][2] = sp[i-1][2];
                }
            }
        }
        List<Integer> resultList =  sp[digits.length][0].data;
        if(Objects.nonNull(resultList) && resultList.size() > 0) {
            resultList.sort((o1, o2) -> {
                return o1-o2;
            });
            if(0 == resultList.get(0)) {
                return "0";
            }
            StringBuilder sb = new StringBuilder("");
            resultList.forEach(value -> {
                sb.append(value);
            });
            return sb.toString();
        }

        return "";
    }
}
