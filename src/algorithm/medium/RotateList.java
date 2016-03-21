package algorithm.medium;

import algorithm.vo.ListNode;

/**
 * Problem:
 * No: 61
 * Link: https://leetcode.com/problems/rotate-list/
 * <p/>
 * Analysis:
 * Traverse the list to get its length,
 * and use its length to avoid rotating to the original state several times.
 * Then partition the list into two parts,
 * the second part has the last k nodes.
 * Swap those two parts positions.
 */
public class RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k <= 0) {
            return head;
        }
        int length = getLength(head);
        k %= length;
        if (k == 0) {
            return head;
        }


        int step = 0;
        ListNode sentry = head;
        while (step < k) {
            sentry = sentry.next;
            step++;
        }
        ListNode newHead = head;
        while (sentry.next != null) {
            sentry = sentry.next;
            newHead = newHead.next;
        }
        ListNode newLast = newHead;
        newHead = newHead.next;
        newLast.next = null;
        sentry.next = head;
        return newHead;
    }

    private int getLength(ListNode head) {
        if (head == null) {
            return 0;
        }

        int length = 0;
        ListNode current = head;
        while (current != null) {
            current = current.next;
            length++;
        }
        return length;
    }
}
