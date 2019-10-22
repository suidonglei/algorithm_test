package learn.algorithm.dp;

/**
 * @author suidonglei
 * @title: ClimbingStairs
 * @projectName algorithm-test
 * @description: 70.Climbing Stairs
 *
 * You are climbing a stair case. It takes n steps to reach to the top.
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 * Note: Given n will be a positive integer.
 *
 * @date 2019/10/11 14:47
 */
public class ClimbingStairs {
  public int climbStairs(int n) {
      if(n == 0 || n == 1 || n == 2) return n;
      int[] result = new int[n];
      result[0] = 1;
      result[1] = 2;
      for(int i = 2; i < n; i++) {
        result[i] = result[i-1] + result[i-2];
      }
      return result[n-1];
  }

    public static void main(String[] args) {
        ClimbingStairs climbingStairs = new ClimbingStairs();
        System.out.println(climbingStairs.climbStairs(44));
    }
}
