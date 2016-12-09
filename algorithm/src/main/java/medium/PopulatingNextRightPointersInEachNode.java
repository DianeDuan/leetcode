package algorithm.medium;

import algorithm.vo.TreeLinkNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Problem:
 * No: 116
 * Link: https://leetcode.com/problems/populating-next-right-pointers-in-each-node/
 * <p/>
 * Analysis:
 * <p/>
 * Solution1:
 * Process layer by layer from root.
 * Use one queue to record the current layer nodes and
 * the other queue to record the next layer nodes.
 * <p/>
 * Solution2:
 * Processing layer by layer from root can assure that
 * when process a layer, the upper layer nodes' next pointers have right values.
 * Use the upper layer nodes' next pointer to connect the right node of a subtree to the left node of the subtree next to it.
 */
public class PopulatingNextRightPointersInEachNode {
    public void connectSolution1(TreeLinkNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeLinkNode> queue1 = new LinkedList<TreeLinkNode>();
        Queue<TreeLinkNode> queue2 = new LinkedList<TreeLinkNode>();
        queue1.add(root);
        while (queue1.size() > 0 || queue2.size() > 0) {
            if (queue1.size() > 0) {
                processCurrentLayer(queue1, queue2);
            } else if (queue2.size() > 0) {
                processCurrentLayer(queue2, queue1);
            }
        }
    }

    public void connectSolution2(TreeLinkNode root) {
        while (root != null && root.left != null) {
            root.left.next = root.right;
            TreeLinkNode p = root;
            while (p.next != null) {
                p.right.next = p.next.left;
                p = p.next;
                p.left.next = p.right;
            }
            root = root.left;
        }
    }

    private void processCurrentLayer(Queue<TreeLinkNode> occupiedQueue, Queue<TreeLinkNode> vacantQueue) {
        if (occupiedQueue == null || vacantQueue == null ||
                occupiedQueue.size() == 0 || vacantQueue.size() != 0) {
            return;
        }

        TreeLinkNode previousNode = null;
        while (occupiedQueue.size() > 0) {
            TreeLinkNode node = occupiedQueue.poll();
            if (previousNode != null) {
                previousNode.next = node;
                previousNode = node;
            } else {
                previousNode = node;
            }
            if (node.left != null) {
                vacantQueue.add(node.left);
            }
            if (node.right != null) {
                vacantQueue.add(node.right);
            }
        }
    }
}
