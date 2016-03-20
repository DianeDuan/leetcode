package algorithm.easy;

import algorithm.vo.TreeNode;

/**
 * Problem:
 * No: 235
 * Link: https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
 * <p/>
 * Analysis:
 * <p/>
 * Solution1:
 * Binary search tree has a property: a node's left node's value is less than this node's value,
 * and its right node's value is greater than its value.
 * So if p's value and q's value are both less than root's value, that means their ancestor is in the left tree of the root,
 * if p's value and q's value are both greater than root's value, that means their ancestor is in the right tree of the root,
 * if one of p's and q's values is less and the other is greater, that means their ancestor is the root.
 * <p/>
 * Solution2:
 * Deep first search to mark if the p or q is found,
 * if p or q is found, but still don't reach the ancestor yet,
 * pass the mark to the parent node,
 * until reach the common ancestor.
 * <p/>
 * Reference:
 * http://segmentfault.com/a/1190000003509399
 * https://en.wikipedia.org/wiki/Binary_search_tree?oldformat=true
 */
public class LowestCommonAncestorOfABinarySearchTree {
    public TreeNode lowestCommonAncestor_solution1(TreeNode root, TreeNode p, TreeNode q) {
        if (root.val > p.val && root.val > q.val) {
            return lowestCommonAncestor_solution1(root.left, p, q);
        } else if (root.val < p.val && root.val < q.val) {
            return lowestCommonAncestor_solution1(root.right, p, q);
        }
        return root;
    }

    public TreeNode lowestCommonAncestor_solution2(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }

        TreeNode left = lowestCommonAncestor_solution2(root.left, p, q);
        TreeNode right = lowestCommonAncestor_solution2(root.right, p, q);

        if (left != null && right != null) {
            return root;
        }

        if (left == null) {
            return right;
        } else {
            return left;
        }
    }
}
