package learn.algorithm.dp;

import java.util.ArrayList;
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
    /**
     * 动态规划方式
     *
     */
    public int dpMinimumTotal(List<List<Integer>> triangle) {
        if(null == triangle || triangle.size() == 0) return 0;
        List<Integer> resultList = new ArrayList<>();
        resultList.addAll(triangle.get(triangle.size() - 1));
        for(int index = triangle.size() - 2; index >= 0; index --) {
            List<Integer> tempList = triangle.get(index);
            for(int j = 0; j < tempList.size(); j ++) {
                resultList.set(j, (Math.min(resultList.get(j), resultList.get(j + 1)) + tempList.get(j)));
            }
        }
        return  resultList.get(0);
    }

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
        if(index == triangle.get(depth).size()) return;
        sum += triangle.get(depth).get(index);
        dfs(triangle, depth + 1, index, sum);
        dfs(triangle, depth + 1, index + 1, sum);
        sum -= triangle.get(depth).get(index);
    }

    public static void main(String[] args) {
        List<List<Integer>> triangleList = new ArrayList<>();
        List<Integer> integers = new ArrayList<>();
        integers.add(-1);
        List<Integer> integers1 = new ArrayList<>();
        integers1.add(2);
        integers1.add(3);
        List<Integer> integers2 = new ArrayList<>();
        integers2.add(1);
        integers2.add(-1);
        integers2.add(-3);
        triangleList.add(integers);
        triangleList.add(integers1);
        triangleList.add(integers2);
        Triangle triangle = new Triangle();
        System.out.println(triangle.minimumTotal(triangleList));
        System.out.println(triangle.dpMinimumTotal(triangleList));
    }
}
