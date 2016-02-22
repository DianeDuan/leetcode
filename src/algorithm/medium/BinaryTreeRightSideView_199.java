package algorithm.medium;

import algorithm.vo.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem:
 * https://leetcode.com/problems/binary-tree-right-side-view/
 * <p/>
 * Analysis:
 * The result is composed of the elements,
 * which are the rightmost ones of every layer of the tree.
 */
public class BinaryTreeRightSideView_199 {
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) {
            return new ArrayList<Integer>();
        }

        List<TreeNode> queue = new ArrayList<TreeNode>();
        queue.add(root);
        List<Integer> result = new ArrayList<Integer>();
        while (queue.size() != 0) {
            result.add(queue.get(queue.size() - 1).val);
            getNextLayer(queue);
        }
        return result;
    }

    private void getNextLayer(List<TreeNode> layer) {
        if (layer == null) {
            return;
        }

        int currentLayerSize = layer.size();
        for (int i = 0; i < currentLayerSize; i++) {
            TreeNode node = layer.remove(0);
            if (node.left != null) {
                layer.add(node.left);
            }
            if (node.right != null) {
                layer.add(node.right);
            }
        }
    }
}
