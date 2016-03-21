package algorithm.medium;

import algorithm.vo.TreeNode;

/**
 * Problem:
 * No: 106
 * Link: https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
 * <p/>
 * Analysis:
 * Get the root value from postorder array.
 * Partition left subtree and right subtree from inorder array.
 * Generate the tree recursively.
 * <p/>
 * Reference:
 * http://bangbingsyb.blogspot.jp/2014/11/leetcode-construct-binary-tree-from_11.html
 */
public class ConstructBinaryTreeFromInorderAndPostorderTraversal {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null || inorder.length != postorder.length || inorder.length == 0) {
            return null;
        }

        int endIndex = inorder.length - 1;
        return buildTree(inorder, 0, endIndex, postorder, 0, endIndex);
    }

    private TreeNode buildTree(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd) {
        if (postStart > postEnd || inStart > inEnd) {
            return null;
        }

        int rootValue = postorder[postEnd];
        TreeNode root = new TreeNode(rootValue);
        int inorderRootIndex = getIndex(inorder, rootValue);
        int leftSubtreeSize = inorderRootIndex - inStart;
        int rightSubtreeSize = inEnd - inorderRootIndex;
        root.left = buildTree(inorder, inStart, inorderRootIndex - 1, postorder, postStart, postStart + leftSubtreeSize - 1);
        root.right = buildTree(inorder, inorderRootIndex + 1, inEnd, postorder, postEnd - rightSubtreeSize, postEnd - 1);
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
