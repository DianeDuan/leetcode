package medium;

import provided.vo.TreeNode;

import java.util.Stack;

/**
 * Problem:
 * No: 173
 * Link: https://leetcode.com/problems/binary-search-tree-iterator/
 * <p/>
 * Analysis:
 * Use a stack to record elements,
 * keep the top of stack is current smallest elements.
 */
public class BinarySearchTreeIterator {
    Stack<TreeNode> stack = new Stack<TreeNode>();

    public BinarySearchTreeIterator(TreeNode root) {
        TreeNode current = root;
        while (current != null) {
            stack.push(current);
            current = current.left;
        }
    }

    /**
     * @return whether we have a next smallest number
     */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /**
     * @return the next smallest number
     */
    public int next() {
        TreeNode node = stack.pop();
        TreeNode current = node.right;
        while (current != null) {
            stack.push(current);
            current = current.left;
        }
        return node.val;
    }
}
