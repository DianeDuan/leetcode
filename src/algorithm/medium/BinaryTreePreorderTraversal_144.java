package algorithm.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Problem:
 * https://leetcode.com/problems/binary-tree-preorder-traversal/
 * <p/>
 * Analysis:
 * <p/>
 * Solution1:
 * Recursion solution.
 * <p/>
 * Solution2:
 * Non-recursion solution, use a stack to keep a record of nodes in the tree.
 */
public class BinaryTreePreorderTraversal_144 {
    public List<Integer> preorderTraversal_solution1(TreeNode root) {
        if (root == null) {
            return new ArrayList<Integer>();
        }

        List<Integer> result = new ArrayList<Integer>();
        result.add(root.val);
        result.addAll(preorderTraversal_solution1(root.left));
        result.addAll(preorderTraversal_solution1(root.right));
        return result;
    }

    public List<Integer> preorderTraversal_solution2(TreeNode root) {
        if (root == null) {
            return new ArrayList<Integer>();
        }

        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.add(root);
        List<Integer> result = new ArrayList<Integer>();
        while (stack.size() != 0) {
            TreeNode node = stack.pop();
            result.add(node.val);
            if (node.right != null) {
                stack.add(node.right);
            }
            if (node.left != null) {
                stack.add(node.left);
            }
        }
        return result;
    }
}
