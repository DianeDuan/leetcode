package easy;

import vo.TreeNode;

/**
 * Problem:
 * No: 100
 * Link: https://leetcode.com/problems/same-tree/
 * <p/>
 * Analysis:
 * Recursively compare the nodes' values and their left trees and right trees.
 */
public class SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null || q == null) {
            return p == q;
        }
        return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
