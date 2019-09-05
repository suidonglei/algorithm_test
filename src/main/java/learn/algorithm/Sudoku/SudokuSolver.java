package learn.algorithm.Sudoku;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author suidonglei
 * @title: SudokuSolver
 * @projectName algorithm-test
 * @description: 37
 *
 * Write a program to solve a Sudoku puzzle by filling the empty cells.
 *
 * A sudoku solution must satisfy all of the following rules:
 *
 * Each of the digits 1-9 must occur exactly once in each row.
 * Each of the digits 1-9 must occur exactly once in each column.
 * Each of the the digits 1-9 must occur exactly once in each of the 9 3x3 sub-boxes of the grid.
 * Empty cells are indicated by the character '.'.
 * @date 2019/9/518:19
 */
public class SudokuSolver {

  /**
   * 回溯剪枝算法
   *
   * @param board
   */
  public void solveSudoku(char[][] board) {
    //剪枝集合
    List<Set<Character>> row = new ArrayList<>();
    List<Set<Character>> col = new ArrayList<>();
    List<Set<Character>> block = new ArrayList<>();
    int columnIndex = 0;
    helperSolver(columnIndex, board, row, col, block);
  }

  private void helperSolver(int columnIndex, char[][] board, List<Set<Character>> row, List<Set<Character>> col, List<Set<Character>> block) {
    if (columnIndex == 9) {
      return;
    }
    for (int rowIndex = 0; rowIndex < 9; rowIndex ++) {
      if('.' == board[rowIndex][columnIndex]) {
          for (char c = '1'; c <= '9'; c++) {
            Set<Character> rowSet = row.get(rowIndex);
            if(null == rowSet) {
              rowSet = new HashSet<>();
              row.add(rowIndex, rowSet);
            }
            Set<Character> colSet = col.get(columnIndex);
            if(null == colSet) {
              colSet = new HashSet<>();
              col.add(columnIndex, colSet);
            }
            Set<Character> blockSet = block.get(rowIndex*3 + columnIndex);
            if(null == blockSet) {
              blockSet = new HashSet<>();
              block.add(rowIndex*3 + columnIndex, blockSet);
            }

            if(rowSet.contains(c) || colSet.contains(c) || blockSet.contains(c)) {
              continue;
            }
            rowSet.add(c);colSet.add(c);blockSet.add(c);
            board[rowIndex][columnIndex] = c;
            helperSolver();


          }
      }
    }
  }
}
