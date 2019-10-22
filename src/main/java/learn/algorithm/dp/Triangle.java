package learn.algorithm.dp;

import java.util.List;

/**
 * 120 triangle
 *
 * Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.
 *
 * For example, given the following triangle
 *
 * [
 *      [2],
 *     [3,4],
 *    [6,5,7],
 *   [4,1,8,3]
 * ]
 * The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
 *
 */
public class Triangle {
    Integer result;
    public int minimumTotal(List<List<Integer>> triangle) {
        if(null == triangle || triangle.size() == 0) return 0;
        dfs(triangle, 0, 0, 0);
        return result;
    }
    void dfs(List<List<Integer>> triangle, int depth, int index, int sum) {
        if (depth == triangle.size()) {
            if(result == null || sum < result) result = sum;
            return;
        }
        if (result != null && sum >= result) return;
        if(index == triangle.get(depth).size()) return;
        sum += triangle.get(depth).get(index);
        dfs(triangle, depth + 1, index, sum);
        dfs(triangle, depth + 1, index + 1, sum);
        sum -= triangle.get(depth).get(index);
    }

    public static void main(String[] args) {

    }
}
