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

    private TreeNode previous;
    public boolean isValidBST01(TreeNode root) {
        if(null == root) {
            return true;
        }
        return inOrderTraversal01(root);
    }
    boolean  inOrderTraversal01(TreeNode treeNode) {
        if(null == treeNode) {
            return true;
        }
        if (!inOrderTraversal01(treeNode.left))
            return false;
        if(previous != null && previous.val >= treeNode.val)
            return false;
        previous = treeNode;
        return inOrderTraversal01(treeNode.right);
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(11);
//        System.out.println(isValidBST01(treeNode));
    }
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}