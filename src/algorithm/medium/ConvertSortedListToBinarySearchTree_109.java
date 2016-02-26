package algorithm.medium;

import algorithm.vo.ListNode;
import algorithm.vo.TreeNode;

/**
 * Problem:
 * https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/
 * <p/>
 * Analysis:
 * <p/>
 * Solution1:
 * Build the tree from top to bottom.
 * <p/>
 * Solution2:
 * Build the tree from bottom to top.
 */
public class ConvertSortedListToBinarySearchTree_109 {
    private ListNode current;

    public TreeNode sortedListToBST_solution1(ListNode head) {
        return buildBSTFromTop(head, null);
    }

    public TreeNode sortedListToBST_solution2(ListNode head) {
        if (head == null) {
            return null;
        }

        int length = getListLength(head);
        current = head;
        return buildBSTFromBottom(0, length - 1);
    }

    private TreeNode buildBSTFromTop(ListNode head, ListNode tail) {
        if (head == null || head == tail) {
            return null;
        }

        ListNode hare = head;
        ListNode tortoise = head;
        while (hare != tail) {
            hare = hare.next;
            if (hare != tail) {
                hare = hare.next;
                tortoise = tortoise.next;
            }
        }

        TreeNode root = new TreeNode(tortoise.val);
        root.left = buildBSTFromTop(head, tortoise);
        root.right = buildBSTFromTop(tortoise.next, tail);
        return root;
    }

    private int getListLength(ListNode head) {
        ListNode tmp = head;
        int length = 0;
        while (tmp != null) {
            tmp = tmp.next;
            length++;
        }
        return length;
    }

    private TreeNode buildBSTFromBottom(int start, int end) {
        if (start > end) {
            return null;
        }

        int mid = (start + end) / 2;
        TreeNode left = buildBSTFromBottom(start, mid - 1);
        TreeNode root = new TreeNode(current.val);
        root.left = left;
        current = current.next;
        root.right = buildBSTFromBottom(mid + 1, end);
        return root;
    }
}
