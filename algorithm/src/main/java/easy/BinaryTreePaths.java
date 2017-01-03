package easy;

import provided.vo.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem:
 * No: 257
 * Link: https://leetcode.com/problems/binary-tree-paths/
 * <p/>
 * Analysis:
 * Recursively get path string.
 */
public class BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        return getPaths(root, "");
    }

    private List<String> getPaths(TreeNode root, String currentPath) {
        if (root == null) {
            return new ArrayList<String>();
        }

        if (!currentPath.equals("")) {
            currentPath += "->";
        }

        List<String> paths = new ArrayList<String>();
        if (root.left == null && root.right == null) {
            currentPath += root.val;
            paths.add(currentPath);
            return paths;
        }

        if (root.left != null) {
            paths.addAll(getPaths(root.left, currentPath + root.val));
        }
        if (root.right != null) {
            paths.addAll(getPaths(root.right, currentPath + root.val));
        }
        return paths;
    }
}
