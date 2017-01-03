package hard;

import provided.vo.TreeLinkNode;

/**
 * Problem:
 * No: 117
 * Link: https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/
 * <p/>
 * Analysis:
 * <p/>
 * Reference:
 * https://gist.github.com/benjaminwu7/4702357
 */
public class PopulatingNextRightPointersInEachNodeII {
    public void connect(TreeLinkNode root) {
        while (root != null) {
            TreeLinkNode current = root;
            while (current != null) {
                if (current.left != null && current.right != null) {
                    current.left.next = current.right;
                    current.right.next = getNextLevelFirst(current.next);
                } else if (current.left != null || current.right != null) {
                    getNextLevelFirst(current).next = getNextLevelFirst(current.next);
                }
                current = current.next;
            }
            root = getNextLevelFirst(root);
        }
    }

    public TreeLinkNode getNextLevelFirst(TreeLinkNode root) {
        if (root == null) return null;
        else if (root.left != null) return root.left;
        else if (root.right != null) return root.right;
        else return getNextLevelFirst(root.next);
    }
}
