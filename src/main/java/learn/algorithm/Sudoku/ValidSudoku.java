package learn.algorithm.Sudoku;

/**
 * @author suidonglei
 * @title: ValidSudoku
 * @projectName algorithm-test
 * @description: 36
 *
 * Determine if a 9x9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:
 *
 * Each row must contain the digits 1-9 without repetition.
 * Each column must contain the digits 1-9 without repetition.
 * Each of the 9 3x3 sub-boxes of the grid must contain the digits 1-9 without repetition.
 *
 * @date 2019/8/2815:43
 */
public class ValidSudoku {

  /**
   * 搜索和剪枝
   * @param board
   * @return
   */
  public static boolean isValidSudoku(char[][] board) {
    char[][] row = new char[9][9];
    char[][] col = new char[9][9];
    char[][][] block  = new char[3][3][9];
    for(int rowIndex = 0; rowIndex < 9; rowIndex ++) {
      for(int colIndex = 0; colIndex < 9; colIndex ++) {
        char charValue = board[rowIndex][colIndex];
        if('.' == charValue) continue;
        int intValue = Character.getNumericValue(charValue);
        if(intValue > 9 || intValue < 1) return false;
        if (charValue == row[rowIndex][intValue - 1]) {
          return false;
        } else {
          row[rowIndex][intValue - 1] = charValue;
        }
        if (charValue == col[colIndex][intValue - 1]) {
          return false;
        } else {
          col[colIndex][intValue - 1] = charValue;
        }
        if (charValue == block[rowIndex/3][colIndex/3][intValue - 1]) {
          return false;
        } else {
          block[rowIndex/3][colIndex/3][intValue - 1] = charValue;
        }
      }
    }
    return true;
  }

  public static void main(String[] args) {
    char[][] board = new char[][]
        { {'.','.','4','.','.','.','6','3','.'},
          {'.','.','.','.','.','.','.','.','.'},
          {'5','.','.','.','.','.','.','9','.'},
          {'.','.','.','5','6','.','.','.','.'},
          {'4','.','3','.','.','.','.','.','1'},
          {'.','.','.','7','.','.','.','.','.'},
          {'.','.','.','5','.','.','.','.','.'},
          {'.','.','.','.','.','.','.','.','.'},
          {'.','.','.','.','.','.','.','.','.'}};
    System.out.println(isValidSudoku(board));
  }
}
