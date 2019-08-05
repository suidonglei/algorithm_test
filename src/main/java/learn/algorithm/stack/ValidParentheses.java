package learn.algorithm.stack;

import java.util.*;

/**
 * @author suidonglei
 * @title: ValidParentheses
 * @projectName javaTest
 * @description: 20
 * @date 2019/8/514:41
 */
public class ValidParentheses {
    public static boolean isValid(String s) {
        if(null == s) {
            return true;
        }
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        Set<Character> leftSet = new HashSet<>();
        leftSet.add('(');
        leftSet.add('[');
        leftSet.add('{');
        Set<Character> rightSet = new HashSet<>();
        rightSet.add(')');
        rightSet.add('}');
        rightSet.add(']');
        Map<Character, Character> map = new HashMap<>();
        map.put(')','(');
        map.put('}','{');
        map.put(']','[');
        for(char cha: chars) {
            if(leftSet.contains(cha)) {
                stack.push(cha);
            } else if(rightSet.contains(cha)) {
                if(stack.empty()) {
                    return false;
                }
                Character top = stack.pop();
                if(top != map.get(cha)) {
                    return false;
                }
            } else {
                return false;
            }
        }
        return stack.empty();
    }

    public static void main(String[] args) {
        System.out.println(isValid("()[]{}"));
    }

}
