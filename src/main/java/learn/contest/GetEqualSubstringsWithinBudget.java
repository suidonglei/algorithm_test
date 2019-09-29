package learn.contest;

import java.util.Arrays;

/**
 * @author suidonglei
 * @title: GetEqualSubstringsWithinBudget
 * @projectName algorithm-test
 * @description: TODO
 * @date 2019/9/2911:09
 */
public class GetEqualSubstringsWithinBudget {
  public static int equalSubstring(String s, String t, int maxCost) {
    if(null == s || null == t) return 0;
    //order by cost
    int[] costs = new int[s.length()];
    for (int i = 0; i < costs.length; i ++) {
      costs[i] = Math.abs(s.charAt(i) - t.charAt(i));
    }
    int returnValue = 0;
    int tempValue = 0;
    int cost = 0;
    int circle = 0;
    for (int i = circle; i < costs.length; i++) {
      cost += costs[i];
      if(cost > maxCost) {
        circle ++;
        i = circle;
        if (tempValue > returnValue) returnValue = tempValue;
        if(costs[i] <= maxCost) {
          tempValue = 1;
          cost = costs[i];
        }
      } else {
        tempValue ++;
      }
    }
    if (tempValue > returnValue && cost <= maxCost) returnValue = tempValue;
    return returnValue;
  }

  public static void main(String[] args) {
    System.out.println(equalSubstring("ujteygggjwxnfl","nstsenrzttikoy",43));

    System.out.println('k'-'z');
  }
}
