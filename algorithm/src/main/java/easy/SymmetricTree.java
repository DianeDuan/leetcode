package algorithm.easy;

import algorithm.vo.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Problem:
 * No: 101
 * Link: https://leetcode.com/problems/symmetric-tree/
 * <p/>
 * Analysis:
 * <p/>
 * Solution1:
 * Recursive solution.
 * <p/>
 * Solution2:
 * Iterative solution.
 * <p/>
 * Reference:
 * http://www.cnblogs.com/springfor/p/3879595.html
 */
public class SymmetricTree {
    public boolean isSymmetricSolution1(TreeNode root) {
        if (root == null) {
            return true;
        }

        if (root.left == null || root.right == null) {
            return root.left == root.right;
        }

        return isSymmetric(root.left, root.right);
    }

    public boolean isSymmetricSolution2(TreeNode root) {
        if (root == null) {
            return true;
        }

        if (root.left == null || root.right == null) {
            return root.left == root.right;
        }

        Queue<TreeNode> queue1 = new LinkedList<TreeNode>();
        Queue<TreeNode> queue2 = new LinkedList<TreeNode>();
        queue1.add(root.left);
        queue2.add(root.right);
        while (queue1.size() > 0 && queue2.size() > 0) {
            TreeNode node1 = queue1.poll();
            TreeNode node2 = queue2.poll();
            if (node1.val != node2.val) {
                return false;
            }
            if ((node1.left != null && node2.right == null) || (node1.left == null && node2.right != null)) {
                return false;
            }
            if ((node1.right != null && node2.left == null) || (node1.right == null && node2.left != null)) {
                return false;
            }
            if (node1.left != null) {
                queue1.add(node1.left);
                queue2.add(node2.right);
            }
            if (node1.right != null) {
                queue1.add(node1.right);
                queue2.add(node2.left);
            }
        }
        return true;
    }

    private boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left == null || right == null) {
            return left == right;
        }

        return left.val == right.val && isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
    }
}
