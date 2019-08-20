package learn.algorithm.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author suidonglei
 * @title: MaximumDepth
 * @projectName algorithm-test
 * @description: 104
 * Maximum Depth of Binary Tree
 *
 * Given a binary tree, find its maximum depth.
 * The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 * Note: A leaf is a node with no children.
 *
 * possible solutions：
 * 1.DFS O(n)
 * 2.BFS O(n)
 *
 * @date 2019/8/20 11:41
 */
public class MaximumDepth {
    /**
     * DFS
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        if(null == root) {
            return 0;
        }
        return dfsMaxDepth(root, 0);
    }

    private int dfsMaxDepth(TreeNode root, int level) {
        if(null == root) {
            return level;
        }
        int leftLevel = dfsMaxDepth(root.left, level + 1);
        int rightLevel = dfsMaxDepth(root.right, level + 1);
        if(leftLevel > rightLevel)
            return leftLevel;
        else
            return rightLevel;
    }

    /**
     * BFS
     * @param root
     * @return
     */
    public int minDepth(TreeNode root) {
        if(null == root) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int depth = 0;
        while(!queue.isEmpty()) {
            depth ++;
            boolean endFlag = false;
            for(int i = queue.size(); i > 0; i --) {
                TreeNode current = queue.poll();
                if(current.left == null && current.right == null) {
                    endFlag = true;
                    break;
                }
                if(null != current.left) {
                    queue.add(current.left);
                }
                if(null != current.right) {
                    queue.add(current.right);
                }
            }
            if(endFlag) {
                break;
            }
        }
        return depth;
    }
}
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
