package easy;

import provided.vo.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Problem:
 * No: 102
 * Link: https://leetcode.com/problems/binary-tree-level-order-traversal/
 * <p/>
 * Analysis:
 * Use two queues to record current layer nodes and next layer nodes alternatively.
 */
public class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<List<Integer>>();
        }

        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Queue<TreeNode> queue1 = new LinkedList<TreeNode>();
        Queue<TreeNode> queue2 = new LinkedList<TreeNode>();
        queue1.add(root);
        while (queue1.size() > 0 || queue2.size() > 0) {
            List<Integer> currentLayer = null;
            if (queue1.size() > 0) {
                currentLayer = processLayers(queue1, queue2);
            } else if (queue2.size() > 0) {
                currentLayer = processLayers(queue2, queue1);
            }
            result.add(currentLayer);
        }
        return result;
    }

    private List<Integer> processLayers(Queue<TreeNode> upperLayer, Queue<TreeNode> lowerLayer) {
        List<Integer> upperLayerValues = new ArrayList<Integer>();
        while (upperLayer.size() > 0) {
            TreeNode node = upperLayer.poll();
            upperLayerValues.add(node.val);
            if (node.left != null) {
                lowerLayer.add(node.left);
            }
            if (node.right != null) {
                lowerLayer.add(node.right);
            }
        }
        return upperLayerValues;
    }
}
