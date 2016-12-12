package medium;

import vo.TreeNode;

import java.util.Stack;

/**
 * Problem:
 * No: 230
 * Link: https://leetcode.com/problems/kth-smallest-element-in-a-bst/
 * <p/>
 * Analysis:
 * BST's property is every node in left subtree is less than current node,
 * and every node in right subtree is greater than current node.
 * So to find the kth smallest element problem equals to find the kth node in an inorder traverse.
 * <p/>
 * Follow up:
 * If the BST is modified (insert/delete operations) often and the operation of finding the kth smallest is frequent,
 * we can add a variable to TreeNode class which record the count of nodes in the left subtree of current node.
 */
public class KthSmallestElementInABST {
    public int kthSmallest(TreeNode root, int k) {
        //inorderTraverse(root, 0);
        int counter = 0;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode current = root;
        while (current != null || stack.size() > 0) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            if (stack.size() > 0) {
                current = stack.pop();
                counter++;
                if (counter == k) {
                    return current.val;
                } else {
                    current = current.right;
                }
            }
        }
        return -1;
    }
}
