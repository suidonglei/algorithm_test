package learn.algorithm.dfsbfs;

import java.util.ArrayList;
import java.util.List;

/**
 * @author suidonglei
 * @title: GenerateParentheses
 * @projectName algorithm-test
 * @description: 22
 *
 * Given n pairs of parentheses, write a function to generate all combinations of
 * well-formed parentheses.
 *
 * possible solutions: Approach 1: Brute Force:  2^2n
 * @date 2019/8/2016:08
 */
public class GenerateParentheses {

  /**
   * Brute Force
   */
  public List<String> generateParenthesis(int n) {
    List<String> returnList = new ArrayList<>();
    if (n < 1) {
      return returnList;
    }
    generateResult(n, n, "", returnList);
    return returnList;
  }

  private void generateResult(int left, int right, String result, List<String> returnList) {
    if (left == 0 && right == 0) {
      returnList.add(result);
      return;
    }
    if (left > 0) {
      generateResult(left - 1, right, result + "(", returnList);
    }
    if (right >  left) {
      generateResult(left, right - 1, result + ")", returnList);
    }
  }

  public static void main(String[] args) {
    GenerateParentheses generateParentheses = new GenerateParentheses();
    generateParentheses.generateParenthesis(2);
  }

}

/**
 * Approach 3: Closure Number
 * Intuition
 *
 * To enumerate something, generally we would like to express it as a sum of disjoint subsets that are easier to count.
 *
 * Consider the closure number of a valid parentheses sequence
 * S: the least index >= 0 so that S[0], S[1], ..., S[2*index+1] is valid.
 * Clearly, every parentheses sequence has a unique closure number. We can try to enumerate them individually.
 *
 * Algorithm
 *
 * For each closure number c, we know the starting and ending brackets must be at index 0 and 2*c + 1.
 * Then, the 2*c elements between must be a valid sequence, plus the rest of the elements must be a valid sequence.
 */
class Solution {
  public List<String> generateParenthesis(int n) {
    List<String> ans = new ArrayList();
    if (n == 0) {
      ans.add("");
    } else {
      for (int c = 0; c < n; ++c)
        for (String left: generateParenthesis(c))
          for (String right: generateParenthesis(n-1-c))
            ans.add("(" + left + ")" + right);
    }
    return ans;
  }
}

