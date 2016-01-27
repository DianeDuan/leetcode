package algorithm.easy;

import algorithm.vo.TreeNode;

import java.util.Stack;

/**
 * Problem:
 * https://leetcode.com/problems/invert-binary-tree/
 * <p/>
 * Analysis:
 * <p/>
 * Solution1:
 * Recursively swap left node and right node from root to the bottom of the tree.
 * <p/>
 * Solution2:
 * Use a stack instead of of recursion.
 */
public class InvertBinaryTree_226 {
    public TreeNode invertTree_solution1(TreeNode root) {
        if (root != null && (root.left != null || root.right != null)) {
            swap(root);
            if (root.left != null) {
                invertTree_solution1(root.left);
            }
            if (root.right != null) {
                invertTree_solution1(root.right);
            }
        }
        return root;
    }

    public TreeNode invertTree_solution2(TreeNode root) {
        if (root != null) {
            Stack<TreeNode> stack = new Stack<TreeNode>();
            stack.push(root);
            while (stack.size() > 0) {
                TreeNode currentNode = stack.pop();
                swap(currentNode);
                if (currentNode.left != null) {
                    stack.push(currentNode.left);
                }
                if (currentNode.right != null) {
                    stack.push(currentNode.right);
                }
            }
        }
        return root;
    }

    private void swap(TreeNode node) {
        if (node != null) {
            TreeNode tmp = node.left;
            node.left = node.right;
            node.right = tmp;
        }
    }
}
