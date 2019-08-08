package learn.algorithm.hashmap;

import java.util.HashMap;
import java.util.Map;

/**
 * @author suidonglei
 * @title: ValidAnagram
 * @projectName algorithm-test
 * @description: 242
 * Given two strings s and t , write a function to determine if t is an anagram of s.
 * possible solutions:
 * 1.sort  O(n·logn)
 * 2.hash count O(n)
 * @date 2019/8/716:24
 */
public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        if(s == null && t == null) return true;
        if(s == null || t == null) return false;
        Map<Character, Integer> countMap = new HashMap<>();
        char[] chars = s.toCharArray();
        for(char cha: chars) {
            if(null == countMap.get(cha)){
                countMap.put(cha, 1);
            } else {
                countMap.put(cha, countMap.get(cha) + 1);
            }
        }
        char[] twoChars = t.toCharArray();
        for(char cha: twoChars) {
            Integer count = countMap.get(cha);
            if(null == count || count < 1) {
                return false;
            } else {
                if(count == 1){
                    countMap.remove(cha);
                } else {
                    countMap.put(cha, count - 1);
                }
            }
        }
        if(countMap.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
}
