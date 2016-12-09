package algorithm.medium;

import algorithm.vo.TreeNode;

/**
 * Problem:
 * No: 106
 * Link: https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 * <p/>
 * Analysis:
 * This problem is similar to the "Construct Binary Tree from Inorder and Postorder Traversal" problem.
 * Get the root value from preorder array.
 * Partition left subtree and right subtree from inorder array.
 * Generate the tree recursively.
 */
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length != inorder.length || preorder.length == 0) {
            return null;
        }

        int endIndex = preorder.length - 1;
        return buildTree(preorder, 0, endIndex, inorder, 0, endIndex);
    }

    private TreeNode buildTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }

        int rootValue = preorder[preStart];
        TreeNode root = new TreeNode(rootValue);
        int inRootIndex = getIndex(inorder, rootValue);
        int leftSubtreeSize = inRootIndex - inStart;
        int rightSubtreeSize = inEnd - inRootIndex;
        root.left = buildTree(preorder, preStart + 1, preStart + leftSubtreeSize, inorder, inStart, inRootIndex - 1);
        root.right = buildTree(preorder, preEnd - rightSubtreeSize + 1, preEnd, inorder, inRootIndex + 1, inEnd);
        return root;
    }

    private int getIndex(int[] array, int target) {
        if (array == null) {
            return -1;
        }

        for (int i = 0; i < array.length; i++) {
            if (array[i] == target) {
                return i;
            }
        }
        return -1;
    }
}
