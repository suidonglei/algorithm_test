package learn.algorithm.trie;

/**
 *
 * 208
 * Implement a trie with insert, search, and startsWith methods.
 *
 * You may assume that all inputs are consist of lowercase letters a-z.
 * All inputs are guaranteed to be non-empty strings.
 *
 */
public class Trie {
    private final char startChar = 'a';
    private boolean endFlag = false;
    private Trie[] childs = null;
    /** Initialize your data structure here. */
    public Trie() {
        childs = new Trie[26];
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        if(null == word || word.length() == 0) return;
        char[] charArray = word.toCharArray();
        Trie current = this;
        for(char cha : charArray) {
            if(current.childs[cha - startChar] == null) {
                current.childs[cha - startChar] = new Trie();
            }
            current = current.childs[cha - startChar];
        }
        current.endFlag = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        if(null == word || word.length() == 0) return true;
        char[] charArray = word.toCharArray();
        Trie current = this;
        for(char cha : charArray) {
            if(current == null || current.childs == null || current.childs[cha-startChar] == null) return false;
            current = current.childs[cha-startChar];
        }
        if(current.endFlag == false) return false;
        return true;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        if(null == prefix || prefix.length() == 0) return true;
        char[] charArray = prefix.toCharArray();
        Trie current = this;
        for(char cha : charArray) {
            if(current == null || current.childs == null || current.childs[cha-startChar] == null) return false;
            current = current.childs[cha-startChar];
        }
        return true;
    }

    public static void main(String[] args) {
        int i = "a".charAt(0)-97;
        System.out.println(i);
        Trie trie = new Trie();
        trie.insert("aple");
        System.out.println(trie.search("aple"));
        System.out.println(trie.search("aplell"));
    }
}
