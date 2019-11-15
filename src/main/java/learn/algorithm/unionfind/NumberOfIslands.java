package learn.algorithm.unionfind;

import java.util.*;

/**
 * 200. Number of Islands
 *
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands.
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
 * You may assume all four edges of the grid are all surrounded by water.
 *
 */
public class NumberOfIslands {
    private List<Integer> union = new ArrayList<>();
    void addElements(char[][] grid) {
        if (null == grid || grid.length == 0 || grid[0].length == 0) return;
        for (int i = 0; i < grid.length; i ++) {
            for (int j = 0; j < grid[i].length; j ++) {
                if ('1' == grid[i][j]) {
                    int index = i * grid[i].length + j;
                    char left = getleft(grid, i, j);
                    char up = getUp(grid, i, j);
                    if('1' == left && '1' == up) {
                        int letRoot = getRoot(index - 1);
                        int upRoot = getRoot(index - grid[i].length);
                        if(letRoot != upRoot)
                            union.set(letRoot, index - grid[i].length);
                        union.set(index, index - grid[i].length);
                    } else if('1' == left) {
                        union.set(index, index - 1);
                    } else if('1' == up) {
                        union.set(index, index - grid[i].length);
                    } else {
                        union.set(index, index);
                    }
                }
            }
        }
    }

    private char getUp(char[][] grid, int i, int j) {
        if(i - 1 > -1) return grid[i - 1][j];
        return '0';
    }

    private char getleft(char[][] grid, int i, int j) {
        if(j - 1 > -1) return grid[i][j - 1];
        return '0';
    }

    private Integer getRoot(int index) {
        Integer root = union.get(index);
        while (root != index && root != -1) {
            index = union.get(index);
            root = union.get(index);
        }
        return index;
    }

    public int numIslands(char[][] grid) {
        if (null == grid || grid.length == 0 || grid[0].length == 0) return 0;
        for(int i = 0; i < grid.length* grid[0].length; i++) union.add(-1);
        addElements(grid);
        Set<Integer> rootSet = new HashSet<>();
        for (int i = 0; i < grid.length; i ++) {
            for (int j = 0; j < grid[i].length; j++) {
                int index = i * grid[i].length + j;
                if(union.get(index) != -1) {
                    rootSet.add(getRoot(index));
                }
            }
        }
        return rootSet.size();
    }

    public static void main(String[] args) {
        NumberOfIslands numberOfIslands = new NumberOfIslands();
        char[][] nums = new char[][]{{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};
        System.out.println(numberOfIslands.numIslands(nums));
    }
}
