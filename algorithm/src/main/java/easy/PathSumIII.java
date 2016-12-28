package easy;

import vo.TreeNode;

/**
 * Problem:
 * No: 437
 * Link: https://leetcode.com/problems/path-sum-iii/
 * <p>
 * Analysis:
 * Choose root node as the start of the path, use depth-first search to find the path count.
 * Then choose the root's left child and right child as the start of the path,  use depth-first search to find the path count.
 * And then their children as the start nodes of the path...
 */
public class PathSumIII {
    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }

        return dfs(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }

    private int dfs(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }

        int pathCount = 0;
        if (sum == root.val) {
            pathCount++;
        }
        pathCount += dfs(root.left, sum - root.val);
        pathCount += dfs(root.right, sum - root.val);
        return pathCount;
    }
}
