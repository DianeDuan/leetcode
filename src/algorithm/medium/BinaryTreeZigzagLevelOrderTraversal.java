package algorithm.medium;

import algorithm.vo.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Problem:
 * No: 103
 * Link: https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
 *
 * Analysis:
 * Use a flag variable to indicate the direction.
 */
public class BinaryTreeZigzagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<List<Integer>>();
        }

        boolean isLeftFirst = true;
        Stack<TreeNode> stack1 = new Stack<TreeNode>(), stack2 = new Stack<TreeNode>();
        stack1.add(root);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        while (stack1.size() > 0 || stack2.size() > 0) {
            Stack<TreeNode> upper, lower;
            if (stack1.size() > 0) {
                upper = stack1;
                lower = stack2;
            } else {
                upper = stack2;
                lower = stack1;
            }
            List<Integer> layer = new ArrayList<Integer>();
            while (upper.size() > 0) {
                TreeNode node = upper.pop();
                layer.add(node.val);
                if (isLeftFirst) {
                    if (node.left != null) {
                        lower.add(node.left);
                    }
                    if (node.right != null) {
                        lower.add(node.right);
                    }
                } else {
                    if (node.right != null) {
                        lower.add(node.right);
                    }
                    if (node.left != null) {
                        lower.add(node.left);
                    }
                }
            }
            result.add(layer);
            isLeftFirst = !isLeftFirst;
        }
        return result;
    }
}
