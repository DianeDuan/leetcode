package medium;

import vo.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem:
 * No: 113
 * Link: https://leetcode.com/problems/path-sum-ii/
 * <p/>
 * Analysis:
 * Preorder traverse binary tree and check if paths' sums.
 */
public class PathSumII {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        return getPaths(root, sum, new ArrayList<Integer>());
    }

    private List<List<Integer>> getPaths(TreeNode root, int sum, List<Integer> current) {
        if (root == null) {
            return new ArrayList<List<Integer>>();
        }

        current.add(root.val);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (root.left == null && root.right == null) {
            if (sum == sum(current)) {
                result.add(current);
            }
        } else {
            if (root.left != null) {
                result.addAll(getPaths(root.left, sum, new ArrayList<Integer>(current)));
            }
            if (root.right != null) {
                result.addAll(getPaths(root.right, sum, new ArrayList<Integer>(current)));
            }
        }
        return result;
    }

    private int sum(List<Integer> nums) {
        if (nums == null) {
            return 0;
        }

        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        return sum;
    }
}
