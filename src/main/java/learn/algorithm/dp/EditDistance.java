package learn.algorithm.dp;

/**
 * 72. Edit Distance
 * Given two words word1 and word2, find the minimum number of operations required to convert word1 to word2.
 *
 * You have the following 3 operations permitted on a word:
 *
 * Insert a character
 * Delete a character
 * Replace a character
 */
public class EditDistance {
    /**
     * https://blog.csdn.net/qq_34552886/article/details/72556242
     *
     * @param word1
     * @param word2
     * @return
     */
    public int minDistance(String word1, String word2) {
        if(word1 == null || word2 == null) return -1;
        if(word1.length() == 0 || word2.length() == 0) return word1.length() + word2.length();
        int[][] distance = new int[word1.length() + 1][word2.length() + 1];
        for (int i = 0; i <= word1.length(); i ++) {
            distance[i][0] = i;
        }
        for (int j = 0; j <= word2.length(); j ++) {
            distance[0][j] = j;
        }

        for (int i = 1; i <= word1.length(); i ++) {
            for (int j = 1; j <= word2.length(); j ++) {
                if(word1.charAt(i-1) == word2.charAt(j-1)) {
                    distance[i][j] = distance[i-1][j-1];
                } else {
                    distance[i][j] = Math.min(distance[i-1][j-1], Math.min(distance[i][j-1], distance[i-1][j])) + 1;
                }
            }
        }
        return distance[word1.length()][word2.length()];
    }
}
