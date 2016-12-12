package easy;

import vo.TreeNode;

/**
 * Problem:
 * No: 104
 * Link: https://leetcode.com/problems/maximum-depth-of-binary-tree/
 * <p/>
 * Analysis:
 * Depth-first search.
 */
public class MaximumDepthOfBinaryTree {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        if (left > right) {
            return left + 1;
        } else {
            return right + 1;
        }
    }
}
