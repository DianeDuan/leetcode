package algorithm.medium;

import algorithm.vo.TreeNode;

import java.util.Stack;

/**
 * Problem:
 * https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
 * <p/>
 * Analysis:
 * Preorder traverse the tree and link the previous node to the next node.
 */
public class FlattenBinaryTreeToLinkedList_114 {
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }

        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.add(root);
        TreeNode previous = new TreeNode(0);//add a head
        while (stack.size() > 0) {
            TreeNode node = stack.pop();
            previous.right = node;
            previous.left = null;
            previous = node;
            if (node.right != null) {
                stack.add(node.right);
            }
            if (node.left != null) {
                stack.add(node.left);
            }
        }
    }
}
