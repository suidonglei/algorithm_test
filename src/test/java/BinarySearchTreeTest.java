import org.junit.Test;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class BinarySearchTreeTest {
    @Test
    public void should_() {
        //given

        //when

        //then

    }
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
class Solution1 {
    public boolean isValidBST(TreeNode root) {
        if(root == null) {
            return true;
        }
        return isBSTHelper(root, null, null);
    }

    private boolean isBSTHelper(TreeNode root, Integer lower, Integer upper) {
        if(lower != null && root.val <= lower) {
            return false;
        }
        if(upper != null && root.val >= upper) {
            return false;
        }
        boolean left = root.left == null ? true : isBSTHelper(root.left, lower, root.val);
        if(left) {
            return root.right == null ? true : isBSTHelper(root.right, root.val, upper);
        } else {
            return false;
        }
    }
}
class SolutionIterator {
    //SolutionIterator first version
    public boolean isValidBST(TreeNode root) {
        if(root == null) {
            return true;
        }

        LinkedList<TreeNode> stack = new LinkedList<>();
        LinkedList<Integer> upperStack = new LinkedList<>();
        LinkedList<Integer> lowerStack = new LinkedList<>();
        stack.add(root);
        upperStack.add(null);
        upperStack.add(null);
        while(!stack.isEmpty()) {
            TreeNode treeNodeTop = stack.poll();
            Integer upper = upperStack.poll();
            Integer lower = lowerStack.poll();
            if(treeNodeTop.right != null) {
                if(treeNodeTop.right.val <= treeNodeTop.val) {
                    return false;
                }
                if(lower != null && lower >= treeNodeTop.right.val) {
                    return false;
                }
                stack.add(treeNodeTop.right);
                lowerStack.add(treeNodeTop.val);
            }

            if(treeNodeTop.left != null) {
                if(treeNodeTop.left.val >= treeNodeTop.val) {
                    return false;
                }
                if(upper != null && upper <= treeNodeTop.left.val) {
                    return false;
                }
                stack.add(treeNodeTop.left);
                upperStack.add(treeNodeTop.val);
            }

        }
        return true;
    }
}

class Solution3 {
    public boolean isValidBST(TreeNode root) {
        if (root == null)
            return true;

        LinkedList<TreeNode> stack = new LinkedList();
        LinkedList<Integer> upper_limits = new LinkedList();
        LinkedList<Integer> lower_limits = new LinkedList();
        stack.add(root);
        upper_limits.add(null);
        lower_limits.add(null);

        while (!stack.isEmpty()) {
            TreeNode node = stack.poll();
            Integer lower_limit = lower_limits.poll();
            Integer upper_limit = upper_limits.poll();
            if (node.right != null) {
                if (node.right.val > node.val) {
                    if ((upper_limit != null) && (node.right.val >= upper_limit))
                        return false;
                    stack.add(node.right);
                    lower_limits.add(node.val);
                    upper_limits.add(upper_limit);
                } else
                    return false;
            }

            if (node.left != null) {
                if (node.left.val < node.val) {
                    if ((lower_limit != null) && (node.left.val <= lower_limit))
                        return false;
                    stack.add(node.left);
                    lower_limits.add(lower_limit);
                    upper_limits.add(node.val);
                } else
                    return false;
            }
        }
        return true;
    }
}