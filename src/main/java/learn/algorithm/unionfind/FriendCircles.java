package learn.algorithm.unionfind;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 547. Friend Circles
 *
 * There are N students in a class. Some of them are friends, while some are not.
 * Their friendship is transitive in nature.
 * For example, if A is a direct friend of B, and B is a direct friend of C, then A is an indirect friend of C.
 * And we defined a friend circle is a group of students who are direct or indirect friends.
 *
 * Given a N*N matrix M representing the friend relationship between students in the class. If M[i][j] = 1,
 * then the ith and jth students are direct friends with each other, otherwise not.
 * And you have to output the total number of friend circles among all the students.
 */
public class FriendCircles {
    private List<Integer> union = new ArrayList<>();
    void addElements(int[][] grid) {
        if (null == grid || grid.length == 0 || grid[0].length == 0) return;
        for (int i = 0; i < grid.length; i ++) {
            for (int j = i+1; j < grid[i].length; j ++) {
                if (1 == grid[i][j]) {
                    if(getRoot(i) != i && getRoot(j) != j) {
                        if(getRoot(i) < getRoot(j)) {
                            union.set(getRoot(j), getRoot(i));
                        }
                        if(getRoot(i) > getRoot(j)) {
                            union.set(getRoot(i), getRoot(j));
                        }
                    } else if (getRoot(i) != i) {
                        union.set(j, getRoot(i));
                    } else if (getRoot(j) != j) {
                        union.set(i, getRoot(j));
                    } else {
                        union.set(j, i);
                    }
                }
            }
        }
    }

    private Integer getRoot(int index) {
        Integer root = union.get(index);
        while (root != index && root != -1) {
            index = union.get(index);
            root = union.get(index);
        }
        return index;
    }
    public int findCircleNum(int[][] M) {

        if (null == M || M.length == 0 || M[0].length == 0) return 0;
        for(int i = 0; i < M.length; i++) union.add(i);
        addElements(M);
        Set<Integer> rootSet = new HashSet<>();
        for (int i = 0; i < M.length; i ++) {
            rootSet.add(getRoot(i));
        }
        return rootSet.size();
    }
}
