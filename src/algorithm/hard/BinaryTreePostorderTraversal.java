package algorithm.hard;

import algorithm.vo.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * Problem:
 * No: 145
 * Link: https://leetcode.com/problems/binary-tree-postorder-traversal/
 * <p/>
 * Analysis:
 * <p/>
 * Solution1:
 * Recursive solution.
 * <p/>
 * Solution2:
 * Iterative solution.
 * <p/>
 * Reference:
 * http://noalgo.info/832.html
 */
public class BinaryTreePostorderTraversal {
    public List<Integer> postorderTraversal_solution1(TreeNode root) {
        if (root == null) {
            return new ArrayList<Integer>();
        }

        List<Integer> result = new ArrayList<Integer>();
        result.addAll(postorderTraversal_solution1(root.left));
        result.addAll(postorderTraversal_solution1(root.right));
        result.add(root.val);
        return result;
    }

    public List<Integer> postorderTraversal_solution2(TreeNode root) {
        if (root == null) {
            return new ArrayList<Integer>();
        }

        Stack<TreeNode> stack = new Stack<TreeNode>();
        Stack<Integer> result = new Stack<Integer>();//keep the preorder traversal result: root -> right subtree -> left subtree
        stack.push(root);
        while (stack.size() > 0) {
            TreeNode current = stack.pop();
            result.push(current.val);
            if (current.left != null) {
                stack.push(current.left);
            }
            if (current.right != null) {
                stack.push(current.right);
            }
        }

        Collections.reverse(result);//reverse the preorder traversal result to get: left subtree -> right subtree -> root
        return result;
    }
}
