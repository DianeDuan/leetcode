package medium;

import vo.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Problem:
 * No: 94
 * Link: https://leetcode.com/problems/binary-tree-inorder-traversal/
 * <p/>
 * Analysis:
 * <p/>
 * Solution1:
 * Recursive solution.
 * <p/>
 * Solution1:
 * Non-recursive solution.
 */
public class BinaryTreeInorderTraversal {
    public List<Integer> inorderTraversalSolution1(TreeNode root) {
        if (root == null) {
            return new ArrayList<Integer>();
        }

        List<Integer> result = new ArrayList<Integer>();
        result.add(root.val);
        result.addAll(inorderTraversalSolution1(root.left));
        result.addAll(inorderTraversalSolution1(root.right));
        return result;
    }

    public List<Integer> inorderTraversalSolution2(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode current = root;
        List<Integer> result = new ArrayList<Integer>();
        while (current != null || stack.size() > 0) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            if (stack.size() > 0) {
                current = stack.pop();
                result.add(current.val);
                current = current.right;
            }
        }
        return result;
    }
}
