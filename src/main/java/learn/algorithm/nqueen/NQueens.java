package learn.algorithm.nqueen;

import java.util.ArrayList;
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
   * 1.
   * @param n
   * @return
   */
  public List<List<String>> solveNQueens(int n) {
    List<List<String>> resultList = new ArrayList<>();
    //设计数据结构存贮占用的斜线
    Set<Integer> positiveLine = new HashSet<>();//点(x,y)  斜线为 x-y=n
    Set<Integer> negativeLine = new HashSet<>();//点(x,y)  斜线为 x+y=n
    Set<Integer> yLine = new HashSet<>();
    for (int x = 1; x <= n; x ++) {
      for (int y = 1; y <= n; y ++) {

      }
    }
    return resultList;
  }
}

/**
 * Given an integer n, return the number of distinct solutions to the n-queens puzzle.
 */
class NQueens_2 {
  public int totalNQueens(int n) {

  }
}