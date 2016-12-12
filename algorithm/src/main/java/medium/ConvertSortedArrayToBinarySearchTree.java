package medium;

import vo.TreeNode;

/**
 * Problem:
 * No: 108
 * Link: https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
 * <p/>
 * Analysis:
 * Use middle element as root and build subtrees in the same way.
 */
public class ConvertSortedArrayToBinarySearchTree {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        return buildTree(0, nums.length - 1, nums);
    }

    private TreeNode buildTree(int start, int end, int[] nums) {
        if (start > end) {
            return null;
        }
        int mid = (start + end) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = buildTree(start, mid - 1, nums);
        root.right = buildTree(mid + 1, end, nums);
        return root;
    }
}
