package learn.algorithm.dp;

import java.util.Objects;

/**
 * 124. Binary Tree Maximum Path Sum
 *
 * Given a non-empty binary tree, find the maximum path sum.
 *
 * For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree along the parent-child connections.
 * The path must contain at least one node and does not need to go through the root.
 */
public class MaximumPathSum {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    public static void main(String[] args) {
        MaximumPathSum maximumPathSum = new MaximumPathSum();
        TreeNode treeNode = new TreeNode(-3);

        System.out.println(maximumPathSum.maxPathSum(treeNode));
    }
    int result = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        int all = dfs(root);
        return all > result ? all : result;
    }

    private int dfs(TreeNode node) {
        if (node == null) return 0;
        int left = Math.max(dfs(node.left), 0);
        int right = Math.max(dfs(node.right), 0);
        result = Math.max(result, left + right + node.val);
        return node.val + Math.max(left, right);
    }
}
