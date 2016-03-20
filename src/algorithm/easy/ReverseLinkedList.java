package algorithm.easy;

import algorithm.vo.ListNode;

/**
 * Problem:
 * No: 206
 * Link: https://leetcode.com/problems/reverse-linked-list/
 * <p/>
 * Analysis:
 * <p/>
 * Solution1:
 * Iterative solution.
 * <p/>
 * Solution2:
 * Recursive solution.
 * <p/>
 * Reference:
 * https://leetcode.com/discuss/34474/in-place-iterative-and-recursive-java-solution
 */
public class ReverseLinkedList {
    public ListNode reverseList_solution1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode newHead = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = newHead;
            newHead = head;
            head = next;
        }
        return newHead;
    }

    public ListNode reverseList_solution2(ListNode head) {
        return reverse(head, null);
    }

    private ListNode reverse(ListNode head, ListNode newHead) {
        if (head == null) {
            return newHead;
        }
        ListNode next = head.next;
        head.next = newHead;
        return reverse(next, head);
    }
}
