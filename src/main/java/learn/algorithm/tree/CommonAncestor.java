package learn.algorithm.tree;

import java.util.Stack;

/**
 * @author suidonglei
 * @title: CommonAncestor
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
public class CommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return findPorQ(root, p, q);
    }

    /**
     * Intuition
     *
     * The approach is pretty intuitive. Traverse the tree in a depth first manner. The moment you encounter either of the nodes p or q,
     * return some boolean flag. The flag helps to determine if we found the required nodes in any of the paths.
     * The least common ancestor would then be the node for which both the subtree recursions return a True flag.
     * It can also be the node which itself is one of p or q and for which one of the subtree recursions returns a True flag.
     *
     * Let us look at the formal algorithm based on this idea.
     *
     * Algorithm
     *
     * Start traversing the tree from the root node.
     * If the current node itself is one of p or q, we would mark a variable mid as True and continue the search for the other node in the left and right branches.
     * If either of the left or the right branch returns True, this means one of the two nodes was found below.
     * If at any point in the traversal, any two of the three flags left, right or mid become True, this means we have found the lowest common ancestor for the nodes p and q.
     * Let us look at a sample tree and we search for the lowest common ancestor of two nodes 9 and 11 in the tree.
     * @param root
     * @param p
     * @param q
     * @return
     */
    TreeNode findPorQ(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return root;
        if(root.val == p.val) return root;
        if(root.val == q.val) return root;
        TreeNode left = findPorQ(root.left, p, q);
        TreeNode right = findPorQ(root.right, p, q);
        return left == null ? right : right == null ? left : root;
    }
    public TreeNode lowestCommonAncestorNoRecursion(TreeNode root, TreeNode p, TreeNode q) {
        //非递归的方式
        while(root != null){
            //判断两个值是否都小于根节点
            if(p.val < root.val && q.val < root.val){
                //直接排查左节点
                root = root.left;
            }
            //判断两个值是否都大于右节点
            else if(p.val > root.val && q.val > root.val){
                root = root.right;
            }
            else{
                return root;
            }
        }
        return null;
    }
}

//class TreeNode {
//    int val;
//    TreeNode left;
//    TreeNode right;
//    TreeNode(int x) { val = x; }
//}