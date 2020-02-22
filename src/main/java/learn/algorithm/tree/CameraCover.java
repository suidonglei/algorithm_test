package learn.algorithm.tree;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * Leetcode 968 Binary Tree Cameras
 *
 */

public class CameraCover {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public int minCameraCover(TreeNode root) {
        if (Objects.isNull(root)) return count;
        covered.add(null);
        dfs(root, null);
        return count;
    }
    //greedy dfs

    int count = 0;
    Set<TreeNode> covered = new HashSet<>();
    private void dfs(TreeNode node, TreeNode par) {
        if(node == null) return;

        dfs(node.left, node);
        dfs(node.right, node);

        if (par == null && !covered.contains(node) ||
                !covered.contains(node.left) ||
                !covered.contains(node.right) ) {
            count++;
            covered.add(node);
            covered.add(par);
            covered.add(node.left);
            covered.add(node.right);
        }
    }


    //dp

    public int minCameraCoverDp(TreeNode root) {
        int[] ans = solve(root);
        return Math.min(ans[1], ans[2]);
    }

    // 0: Strict ST; All nodes below this are covered, but not this one
    // 1: Normal ST; All nodes below and incl this are covered - no camera
    // 2: Placed camera; All nodes below this are covered, plus camera here
    public int[] solve(TreeNode node) {
        if (node == null)
            return new int[]{0, 0, 99999};

        int[] L = solve(node.left);
        int[] R = solve(node.right);
        int mL12 = Math.min(L[1], L[2]);
        int mR12 = Math.min(R[1], R[2]);

        int d0 = L[1] + R[1];
        int d1 = Math.min(L[2] + mR12, R[2] + mL12);
        int d2 = 1 + Math.min(L[0], mL12) + Math.min(R[0], mR12);
        return new int[]{d0, d1, d2};
    }

}
