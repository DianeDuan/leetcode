package algorithm.easy;

import algorithm.vo.TreeNode;

/**
 * Problem:
 * https://leetcode.com/problems/same-tree/
 * <p/>
 * Analysis:
 * Recursively compare the nodes' values and their left trees and right trees.
 */
public class SameTree_100 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null || q == null) {
            return p == q;
        }
        return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
