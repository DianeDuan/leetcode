package easy;

import vo.TreeNode;

/**
 * Problem:
 * No: 404
 * Link: https://leetcode.com/problems/sum-of-left-leaves/
 * <p>
 * Analysis:
 * Add sum of left leaves recursively.
 */
public class SumOfLeftLeaves {
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int sum = 0;
        TreeNode left = root.left;
        if (left != null) {
            if (left.left == null && left.right == null) {
                sum += left.val;
            } else {
                sum += sumOfLeftLeaves(left);
            }
        }
        TreeNode right = root.right;
        sum += sumOfLeftLeaves(right);
        return sum;
    }
}
