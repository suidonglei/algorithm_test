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
        TreeNode treeNode = new TreeNode(11);
        treeNode.left = new TreeNode(22);
        treeNode.right = new TreeNode(33);
        treeNode.left.left = new TreeNode(44);
        treeNode.left.right = new TreeNode(55);
        dfs(treeNode);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
