package learn.algorithm.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author suidonglei
 * @title: BinaryTreeLevelOrderTraversal
 * @projectName algorithm-test
 * @description: 102
 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
 * possible solutions:
 * 1.bfs  判断每一层的末尾信息
 * 2.DFS  每一层递归 记录level深度
 *
 * @date 2019/8/2010:23
 */
public class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> returnList = new ArrayList<>();
        if(null == root) {
            return returnList;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<Integer> subList = new ArrayList<>();
        Queue<TreeNode> queueNext = new LinkedList<>();
        while (queue.peek() != null) {
            TreeNode current = queue.poll();
            subList.add(current.val);
            if(null != current.left) {
                queueNext.add(current.left);
            }
            if(null != current.right) {
                queueNext.add(current.right);
            }
            if(queue.isEmpty()) {
                queue = queueNext;
                returnList.add(subList);
                queueNext = new LinkedList<>();
                subList = new ArrayList<>();
            }
        }
        return returnList;
    }
}
//class TreeNode {
//    int val;
//    TreeNode left;
//    TreeNode right;
//    TreeNode(int x) { val = x; }
//}