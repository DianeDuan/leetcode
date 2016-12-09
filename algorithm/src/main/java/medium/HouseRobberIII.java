package algorithm.medium;

import algorithm.vo.TreeNode;

/**
 * Problem:
 * No: 337
 * Link: https://leetcode.com/problems/house-robber-iii/
 * <p/>
 * Analysis:
 * Recursive solution.
 * To any node in the tree,
 * there are two choices,
 * the first choice is that rob this house and can't rob the left and right nodes houses,
 * the other choice is that don't rob this house and can robb the left and right nodes houses.
 */
public class HouseRobberIII {
    public int rob(TreeNode root) {
        if (root == null) {
            return 0;
        }

        //root house is robbed
        int amount1 = root.val;
        if (root.left != null) {
            amount1 += (rob(root.left.left) + rob(root.left.right));
        }
        if (root.right != null) {
            amount1 += (rob(root.right.left) + rob(root.right.right));
        }

        //root house isn't robbed
        int amount2 = rob(root.left) + rob(root.right);

        return Math.max(amount1, amount2);
    }
}
