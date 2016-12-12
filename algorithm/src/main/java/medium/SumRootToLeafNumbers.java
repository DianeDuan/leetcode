package medium;

import vo.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem:
 * No: 129
 * Link: https://leetcode.com/problems/sum-root-to-leaf-numbers/
 * <p/>
 * Analysis:
 * Inorder traverse to get numbers,
 * and then add them together.
 */
public class SumRootToLeafNumbers {
    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }

        List<Integer> numbers = new ArrayList<Integer>();
        List<List<TreeNode>> paths = getPaths(root, new ArrayList<TreeNode>());
        for (List<TreeNode> path : paths) {
            numbers.add(getNumber(path));
        }
        return sum(numbers);
    }

    private List<List<TreeNode>> getPaths(TreeNode root, List<TreeNode> currentPath) {
        if (root == null) {
            return new ArrayList<List<TreeNode>>();
        }

        List<List<TreeNode>> result = new ArrayList<List<TreeNode>>();
        currentPath.add(root);
        if (root.left == null && root.right == null) {
            result.add(new ArrayList<TreeNode>(currentPath));
        } else {
            result.addAll(getPaths(root.left, currentPath));
            result.addAll(getPaths(root.right, currentPath));
        }
        currentPath.remove(currentPath.size() - 1);
        return result;
    }

    private int getNumber(List<TreeNode> list) {
        int number = 0;
        for (TreeNode node : list) {
            number *= 10;
            number += node.val;
        }
        return number;
    }

    private int sum(List<Integer> numbers) {
        if (numbers == null) {
            return 0;
        }

        int sum = 0;
        for (int i = numbers.size() - 1; i > -1; i--) {
            sum += numbers.get(i);
        }
        return sum;
    }
}
