package learn.algorithm.tree;

import java.util.Arrays;
import java.util.Vector;

/**
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 *
 * Assume a BST is defined as follows:
 *
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 *
 * possible solutions:
 * 1.in-order traversal
 * 2.recursively
 */
public class ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        if(null == root) {
            return true;
        }
        Vector<Integer> values = new Vector<>();
        inOrderTraversal(values, root);
        Integer[] intArray = values.toArray(new Integer[0]);
        Arrays.sort(intArray);
        for(int i = 0; i < values.size(); i ++) {
            if(!intArray[i].equals(values.get(i))) {
                return false;
            }
            if(i > 0) {
                if(intArray[i].equals(intArray[i - 1])) {
                    return false;
                }
            }
        }
        return true;
    }
    void inOrderTraversal(Vector<Integer> values, TreeNode treeNode) {
        if(null == treeNode) {
            return;
        }
        inOrderTraversal(values, treeNode.left);
        values.add(treeNode.val);
        inOrderTraversal(values, treeNode.right);
    }
}
class Solution01{
    private TreeNode previous;
    public boolean isValidBST(TreeNode root) {
        if(null == root) {
            return true;
        }
        return inOrderTraversal(root);
    }
    boolean  inOrderTraversal(TreeNode treeNode) {
        if(null == treeNode) {
            return true;
        }
        if (!inOrderTraversal(treeNode.left))
            return false;
        if(previous != null && previous.val >= treeNode.val)
            return false;
        previous = treeNode;
        return inOrderTraversal(treeNode.right);
    }
}
class Solution02{
    public boolean isValidBST(TreeNode root) {
        if(null == root) {
            return true;
        }
        return isValid(root, null, null);
    }
    public boolean isValid(TreeNode root, Integer min, Integer max) {
        if(null == root)
            return true;
        if(min != null && root.val <= min) return false;
        if(max != null && root.val >= max) return false;
        return isValid(root.left, min, root.val) && isValid(root.right, root.val, max);
    }
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}