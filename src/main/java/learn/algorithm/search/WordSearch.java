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
        if (board[row][col] == wordChars[0]) {
          Set<String> path = new HashSet<>();
          path.add(row + "," + col);
          if (dfs(board, wordChars, row, col, 0, path)) return true;
        }
      }
    }

    return false;
  }

  private boolean dfs(char[][] board, char[] wordChars, int row, int col, int index, Set<String> path) {
    if (index == wordChars.length - 1) return true;
    index ++;
    //up
    if (row > 0) {
      row = row - 1;
      if (dfsCheck(board, wordChars, row, col, index, path)) {
        return true;
      }
      row = row + 1;
    }
    //down
    if (row < board.length - 1) {
      row = row + 1;
      if (dfsCheck(board, wordChars, row, col, index, path)) {
        return true;
      }
      row = row - 1;
    }
    //left
    if (col > 0) {
      col = col - 1;
      if (dfsCheck(board, wordChars, row, col, index, path)) {
        return true;
      }
      col = col + 1;
    }

    //right
    if (col < board[row].length - 1) {
      col = col + 1;
      if (dfsCheck(board, wordChars, row, col, index, path)) {
        return true;
      }
      col = col - 1;
    }

    return false;
  }

  private boolean dfsCheck(char[][] board, char[] wordChars, int row, int col, int index,
      Set<String> path) {
    String pat = row + "," + col;
    if (!path.contains(pat)) {
      path.add(pat);
      if (board[row][col] == wordChars[index]) {
        if (dfs(board, wordChars, row, col, index, path))
          return true;
      }
      path.remove(pat);
    }
    return false;
  }

  public static void main(String[] args) {
    WordSearch wordSearch = new WordSearch();
    char[][] board = new char[][]{{'c','a','a'},{'a','a','a'},{'b','c','d'}};
    System.out.println(wordSearch.exist(board, "aab"));
  }
}
