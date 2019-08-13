package learn.algorithm.tree;

import java.util.Stack;

/**
 * @author suidonglei
 * @title: CommonAncesor
 * @projectName algorithm-test
 * @description: 235
 * Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.
 * According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q
 * as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”
 * Given binary search tree:  root = [6,2,8,0,4,7,9,null,null,3,5]
 *
 * possible solutions:
 * 1.recursion O(n)
 * 2.get path
 * @date 2019/8/1316:41
 */
public class CommonAncesor {
    private Stack<Integer> stack = new Stack<>();
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        return null;
    }
    private void preOrderTraversal(TreeNode root, TreeNode p, TreeNode q) {
        if(null != root) {
            stack.push(root.val);
        }
        if(root.val == p.val || root.val == q.val) {

        } else {
            preOrderTraversal(root.left, p, q);
            stack.pop();
            preOrderTraversal(root.right, p, q);
            stack.pop();
        }
    }

}

//class TreeNode {
//    int val;
//    TreeNode left;
//    TreeNode right;
//    TreeNode(int x) { val = x; }
//}