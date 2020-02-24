package learn.contest.jen;

import java.util.HashSet;
import java.util.Set;

/**
 * 5170. Validate Binary Tree Nodes
 *
 * You have n binary tree nodes numbered from 0 to n - 1 where node i has two children leftChild[i] and rightChild[i], return true if and only if all the given nodes form exactly one valid binary tree.
 *
 * If node i has no left child then leftChild[i] will equal -1, similarly for the right child.
 *
 * Note that the nodes have no values and that we only use the node numbers in this problem.
 */
public class ValidateBinaryTree {

    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        Set<Integer> visited = new HashSet<>();
        int[] indegrees = new int[n];

        visited.add(0);
        for(int i = 0 ; i < n; i ++) {
            if(leftChild[i] != -1) {
                if(visited.contains(leftChild[i])) {
                    return false;
                }
                visited.add(leftChild[i]);
                indegrees[leftChild[i]] ++;
            }

            if(rightChild[i] != -1) {
                if(visited.contains(rightChild[i])) {
                    return false;
                }
                visited.add(rightChild[i]);
                indegrees[rightChild[i]] ++;
            }
        }
        for(int i = 1; i < n ; i ++) {
            if (indegrees[i] != 1) return false;
        }

        return true;
    }
}
