package medium;

import provided.vo.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem:
 * No: 95
 * Link: https://leetcode.com/problems/unique-binary-search-trees-ii/
 * <p/>
 * Analysis:
 * In a binary search tree,
 * if the root's value is i,
 * its left subtree's nodes' values' range is 1 to i-1,
 * and its right subtree's nodes' values' range is i+1 to n.
 * <p/>
 * Reference:
 * http://www.cnblogs.com/springfor/p/3884029.html
 */
public class UniqueBinarySearchTreesII {
    public List<TreeNode> generateTrees(int n) {
        return generate(1, n);
    }

    private List<TreeNode> generate(int left, int right) {
        if (left > right) {
            return new ArrayList<TreeNode>();
        }

        List<TreeNode> result = new ArrayList<TreeNode>();
        for (int i = left; i <= right; i++) {
            List<TreeNode> leftSubtrees = generate(left, i - 1);
            List<TreeNode> rightSubtrees = generate(i + 1, right);
            if (leftSubtrees.size() > 0 && rightSubtrees.size() > 0) {
                for (TreeNode leftTree : leftSubtrees) {
                    for (TreeNode rightTree : rightSubtrees) {
                        TreeNode root = new TreeNode(i);
                        root.left = leftTree;
                        root.right = rightTree;
                        result.add(root);
                    }
                }
            } else if (leftSubtrees.size() > 0) {
                for (TreeNode leftTree : leftSubtrees) {
                    TreeNode root = new TreeNode(i);
                    root.left = leftTree;
                    result.add(root);
                }
            } else if (rightSubtrees.size() > 0) {
                for (TreeNode rightTree : rightSubtrees) {
                    TreeNode root = new TreeNode(i);
                    root.right = rightTree;
                    result.add(root);
                }
            } else {
                TreeNode root = new TreeNode(i);
                result.add(root);
            }
        }
        return result;
    }
}
