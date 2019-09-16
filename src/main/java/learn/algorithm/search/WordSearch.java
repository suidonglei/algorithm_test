package learn.algorithm.search;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author suidonglei
 * @title: WordSearch
 * @projectName algorithm-test
 * @description: 212
 * Word Search II
 *
 * Given a 2D board and a list of words from the dictionary, find all words in the board.
 *
 * Each word must be constructed from letters of sequentially adjacent cell, where "adjacent"
 * cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.
 *
 * @date 2019/9/1614:39
 */
public class WordSearch {

  public List<String> findWords(char[][] board, String[] words) {

    return null;
  }

  /**
   * 79. Word Search
   * Given a 2D board and a word, find if the word exists in the grid.
   *
   * The word can be constructed from letters of sequentially adjacent cell,
   * where "adjacent" cells are those horizontally or vertically neighboring.
   * The same letter cell may not be used more than once.
   *
   * @param board
   * @param word
   * @return
   */
  public boolean exist(char[][] board, String word) {
    if (null == word || word.length() == 0) return true;
    if (null == board) return false;
    char[] wordChars = word.toCharArray();
    for(int row = 0; row < board.length; row ++) {
//      char[] charRow =
      for(int col = 0; col < board[row].length; col ++) {
        if(board[row][col] == wordChars[0] && dfs(board, wordChars, row, col, 0))
          return true;
      }
    }
    return false;
  }

  private boolean dfs(char[][] board, char[] wordChars, int row, int col, int index) {
    if (index == wordChars.length) return true;
    if (row == -1 || row == board.length || col == -1 || col == board[0].length || board[row][col] != wordChars[index])
      return false;
    char temp = board[row][col];
    board[row][col] = ' ';
    boolean found = dfs(board, wordChars, row + 1, col, index + 1) ||
        dfs(board, wordChars, row - 1, col, index + 1) ||
        dfs(board, wordChars, row, col + 1, index + 1) ||
        dfs(board, wordChars, row, col - 1, index + 1);
    board[row][col] = temp;
    return found;
  }


  public static void main(String[] args) {
    WordSearch wordSearch = new WordSearch();
    char[][] board = new char[][]{{'a','a'}};
    System.out.println(wordSearch.exist(board, "aaa"));
  }
}
