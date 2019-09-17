package learn.algorithm.trie;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author suidonglei
 * @title: WordSearch
 * @projectName algorithm-test
 * @description: 212
 *
 * Intuitively, start from every cell and try to build a word in the dictionary.
 * Backtracking (dfs) is the powerful way to exhaust every possible ways.
 * Apparently, we need to do pruning when current character is not in any word.
 *
 * How do we instantly know the current character is invalid? HashMap?
 * How do we instantly know what's the next valid character? LinkedList?
 * But the next character can be chosen from a list of characters. "Mutil-LinkedList"?
 * Combing them, Trie is the natural choice. Notice that:
 *
 * TrieNode is all we need. search and startsWith are useless.
 * No need to store character at TrieNode. c.next[i] != null is enough.
 * Never use c1 + c2 + c3. Use StringBuilder.
 * No need to use O(n^2) extra space visited[m][n].
 * No need to use StringBuilder. Storing word itself at leaf node is enough.
 * No need to use HashSet to de-duplicate. Use "one time search" trie.
 *
 * Code Optimization
 * UPDATE: Thanks to @dietpepsi we further improved from 17ms to 15ms.
 *
 * 59ms: Use search and startsWith in Trie class like this popular solution.
 * 33ms: Remove Trie class which unnecessarily starts from root in every dfs call.
 * 30ms: Use w.toCharArray() instead of w.charAt(i).
 * 22ms: Use StringBuilder instead of c1 + c2 + c3.
 * 20ms: Remove StringBuilder completely by storing word instead of boolean in TrieNode.
 * 20ms: Remove visited[m][n] completely by modifying board[i][j] = '#' directly.
 * 18ms: check validity, e.g., if(i > 0) dfs(...), before going to the next dfs.
 * 17ms: De-duplicate c - a with one variable i.
 * 15ms: Remove HashSet completely. dietpepsi's idea is awesome.
 *
 *
 * @date 2019/9/16 18:18
 */
public class WordSearch {

  private final char visitedWord = '@';

  private Set<String> foundString = new HashSet<>();

  public List<String> findWords(char[][] board, String[] words) {
    List<String> returnList = new ArrayList<>();
    if(null == board || null == board) return returnList;
    TrieNode trieNode = new TrieNode();
    for (String word : words) {
      trieNode.insert(word);
    }
    for (int row = 0; row < board.length; row ++) {
      for (int col = 0; col < board[row].length; col ++) {
        StringBuilder stringBuilder = new StringBuilder();
        dfs(trieNode, board, row, col, stringBuilder);
      }
    }
    returnList.addAll(foundString);
    return returnList;
  }

  private void dfs(TrieNode trieNode, char[][] board, int row,
      int col, StringBuilder stringBuilder) {
    String currentWord = stringBuilder.toString();
    if (trieNode.search(currentWord)) {
      foundString.add(currentWord);
    }
    if(col == -1 || row == -1 || row == board.length || col == board[row].length) return;
    char temp = board[row][col];
    if (temp == visitedWord) return;
    if (!trieNode.startsWith(currentWord)) return;
    stringBuilder.append(temp);
    board[row][col] = visitedWord;
    dfs(trieNode, board, row + 1, col, stringBuilder);
    dfs(trieNode, board, row - 1, col, stringBuilder);
    dfs(trieNode, board, row, col + 1, stringBuilder);
    dfs(trieNode, board, row, col - 1, stringBuilder);
    board[row][col] = temp;
    stringBuilder.deleteCharAt(stringBuilder.length() - 1);
  }


  class TrieNode{
    private final char startChar = 'a';
    private TrieNode[] children = new TrieNode[26];
    private boolean endFlag = false;

    /** Inserts a word into the trie. */
    public void insert(String word) {
      if(null == word || word.length() == 0) return;
      char[] charArray = word.toCharArray();
      TrieNode current = this;
      for(char cha : charArray) {
        if(current.children[cha - startChar] == null) {
          current.children[cha - startChar] = new TrieNode();
        }
        current = current.children[cha - startChar];
      }
      current.endFlag = true;
    }
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
      if(null == word || word.length() == 0) return false;
      char[] charArray = word.toCharArray();
      TrieNode current = this;
      for(char cha : charArray) {
        if(current == null || current.children == null || current.children[cha-startChar] == null) return false;
        current = current.children[cha-startChar];
      }
      if(current.endFlag == false) return false;
      return true;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
      if(null == prefix || prefix.length() == 0) return true;
      char[] charArray = prefix.toCharArray();
      TrieNode current = this;
      for(char cha : charArray) {
        if(current == null || current.children == null || current.children[cha-startChar] == null) return false;
        current = current.children[cha-startChar];
      }
      return true;
    }
  }

}
