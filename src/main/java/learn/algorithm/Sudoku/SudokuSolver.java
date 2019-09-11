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
    if (null == board || board.length == 0) return;
    solvehelper(board);
  }

  private boolean solvehelper(char[][] board) {
    for (int i = 0; i < board.length; i ++) {
      for (int j = 0; j < board.length; j ++) {
        if (board[i][j] == '.') {
          for (char c = '1'; c <= '9'; c++) {
            if (isValid(board, i, j, c)) {
              board[i][j] = c;
              if (solvehelper(board)) {
                return true;
              } else {
                board[i][j] = '.';
              }
            }
          }
          return false;
        }
      }
    }
    return true;
  }

  private boolean isValid(char[][] board, int row, int col, char c) {
    for (int i = 0; i < 9; i++) {
      if (board[i][col] != '.' && board[i][col] == c) {
        return false;
      }
      if (board[row][i] != '.' && board[row][i] == c) {
        return false;
      }
      if (board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] != '.'
          && board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == c) {
        return false;
      }
    }
    return true;
  }

}
