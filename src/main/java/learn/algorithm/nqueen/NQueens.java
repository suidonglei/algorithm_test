package learn.algorithm.nqueen;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author suidonglei
 * @title: NQueens
 * @projectName algorithm-test
 * @description: 51、52
 *
 * The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.（任意两个皇后都不能处于同一行、同一列或同一斜线上）
 * Given an integer n, return all distinct solutions to the n-queens puzzle.
 * Each solution contains a distinct board configuration of the n-queens' placement,
 * where 'Q' and '.' both indicate a queen and an empty space respectively.
 *
 * @date 2019/8/2214:27
 */
public class NQueens {

  /**
   * solutions:
   * 回溯算法，每一个层级依次遍历列，如果没有问题就进到下一个层级，每一个层级使用剪枝算法
   *
   * 采用回溯法,即逐一位置放置,然后放置下一行,如果下一行没有合法位置,则回溯到上一行,调整位置,直到得到所有值.
   * @param n
   * @return
   */
  public List<List<String>> solveNQueens(int n) {
    List<List<String>> resultList = new ArrayList<>();
    //设计数据结构存贮占用的斜线
    Set<Integer> positiveLine = new HashSet<>();//点(x,y)  斜线为 x-y=n
    Set<Integer> negativeLine = new HashSet<>();//点(x,y)  斜线为 x+y=n
    Set<Integer> yLine = new HashSet<>();
    dfs(0, n, positiveLine, negativeLine, yLine, resultList, new ArrayList<>());
    return resultList;
  }

  private void dfs(int row, int n, Set<Integer> positiveLine, Set<Integer> negativeLine,
      Set<Integer> yLine, List<List<String>> resultList, List<String> subResult) {
    //terminator
    if (row == n) {
      resultList.add(new ArrayList<>(subResult));
      return;
    }

    for(int col = 0; col < n; col ++) {
      int pos = row + col;
      int neg = row - col;
      if(positiveLine.contains(pos) || negativeLine.contains(neg) || yLine.contains(col)) {
        //剪枝
        continue;
      }
      positiveLine.add(pos);
      negativeLine.add(neg);
      yLine.add(col);
      char[] chars = new char[n];
      Arrays.fill(chars, '.');
      chars[col] = 'Q';
      String subStr = new String(chars);
      subResult.add(subStr);
      dfs(row + 1, n, positiveLine, negativeLine, yLine, resultList, subResult);
      subResult.remove(subStr);
      positiveLine.remove(pos);
      negativeLine.remove(neg);
      yLine.remove(col);
    }
  }
  public static void main(String[] args) {
    NQueens nQueens = new NQueens();
    System.out.println(nQueens.solveNQueens(4));
  }
}

/**
 * 52
 * Given an integer n, return the number of distinct solutions to the n-queens puzzle.
 */
class NQueens_2 {
  private int count = 0;
  public int totalNQueens(int n) {
    if (n < 1) return count;
    dfs(0, 0, 0, 0, n);
    return count;
  }

  private void dfs(int row, int col, int pie, int na, int length) {
    // recursion terminator
    if (row >= length) {
      count ++;
      return;
    }
    //get location 转换为1可用0不可用
    int bits = (~(col | pie | na)) & ((1 << length) - 1);
    while (bits > 0) {
      int position = bits & -bits;//得到最后一个1 的位
      dfs(row + 1, col | position, (pie | position) << 1, (na | position) >> 1, length);
      bits &= bits - 1;
    }
  }

  public static void main(String[] args) {
    int input = 10;
    System.out.println( input & (-input));
  }
}