package easy;

import provided.vo.TreeNode;

/**
 * Problem:
 * No: 112
 * Link: https://leetcode.com/problems/path-sum/
 * <p/>
 * Analysis:
 * Recursive solution.
 */
public class PathSum {
    public boolean hasPathSum(TreeNode root, int sum) {
        return hasPathSum(root, 0, sum);
    }

    private boolean hasPathSum(TreeNode root, int currentSum, int target) {
        if (root == null) {
            return false;
        }

        currentSum += root.val;
        if (root.left == null && root.right == null) {
            return currentSum == target;
        }

        return hasPathSum(root.left, currentSum, target) || hasPathSum(root.right, currentSum, target);
    }
}
