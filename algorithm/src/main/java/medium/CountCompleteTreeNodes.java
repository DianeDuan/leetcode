package medium;

import provided.vo.TreeNode;

/**
 * Problem:
 * No: 222
 * Link: https://leetcode.com/problems/count-complete-tree-nodes/
 * <p/>
 * Analysis:
 * The nodes' count of a full binary tree is 2^(height - 1) - 1.
 * <p/>
 * Reference:
 * http://blog.csdn.net/xudli/article/details/46385011
 */
public class CountCompleteTreeNodes {
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftHeight = getLeftHeight(root);
        int rightHeight = getRightHeight(root);

        if (leftHeight == rightHeight) {//this tree is full binary tree
            return (2 << (leftHeight - 1)) - 1;
        } else {
            return countNodes(root.left) + countNodes(root.right) + 1;
        }
    }

    private int getLeftHeight(TreeNode root) {
        int height = 0;
        TreeNode current = root;
        while (current != null) {
            height++;
            current = current.left;
        }
        return height;
    }

    private int getRightHeight(TreeNode root) {
        int height = 0;
        TreeNode current = root;
        while (current != null) {
            height++;
            current = current.right;
        }
        return height;
    }
}
