package algorithm.easy;

import algorithm.vo.TreeNode;

/**
 * Problem:
 * No: 110
 * Link: https://leetcode.com/problems/balanced-binary-tree/
 * <p/>
 * Analysis:
 * If current node's left subtree's height and right subtree's height differ less than 1,
 * and both left subtree and right subtree are alse balanced, the tree is balanced.
 */
public class BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }

        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        return Math.abs(leftHeight - rightHeight) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    private int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }
}
