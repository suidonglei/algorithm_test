package learn.algorithm.dfsbfs;

import java.util.ArrayList;
import java.util.List;

/**
 * @author suidonglei
 * @title: GenerateParentheses
 * @projectName algorithm-test
 * @description: 22 Given n pairs of parentheses, write a function to generate all combinations of
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
