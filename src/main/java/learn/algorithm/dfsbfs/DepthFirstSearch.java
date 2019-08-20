package learn.algorithm.dfsbfs;

public class DepthFirstSearch {
    public static void dfs(TreeNode treeNode) {
        if(null == treeNode) {
            return;
        }
        System.out.println(treeNode.val);
        dfs(treeNode.left);
        dfs(treeNode.right);
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);
        treeNode.left.left = new TreeNode(4);
        treeNode.left.right = new TreeNode(5);
        dfs(treeNode);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
