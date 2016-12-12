package medium;

import vo.ListNode;

/**
 * Problem:
 * No: 143
 * Link: https://leetcode.com/problems/reorder-list/
 * <p/>
 * Analysis:
 * Reverse the latter half list,
 * and combine the former half list and the latter half list.
 * <p/>
 * Reference:
 * http://fisherlei.blogspot.com/2013/11/leetcode-reorder-list-solution.html
 */
public class ReorderList {
    public void reorderList(ListNode head) {
        if (head == null) {
            return;
        }

        //get the first node of the latter half
        ListNode middle = getMiddleNode(head);
        //reverse the latter half list
        ListNode latterHead = reverseList(middle);
        //combine the former half list and the reversed latter half list
        combine(head, latterHead);
    }

    private ListNode getMiddleNode(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode hare = head, tortoise = head;
        while (hare != null) {
            hare = hare.next;
            tortoise = tortoise.next;
            if (hare != null) {
                hare = hare.next;
            }
        }
        return tortoise;
    }

    private ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;

        ListNode previous = dummyHead;
        ListNode current = head;
        while (current != null) {
            ListNode next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        head.next = null;//remove dummy head
        return previous;
    }

    private void combine(ListNode head1, ListNode head2) {
        ListNode current1 = head1;
        ListNode current2 = head2;
        while (current1 != null && current2 != null) {
            ListNode next1 = current1.next;
            ListNode next2 = current2.next;
            current1.next = current2;
            current2.next = next1;
            current1 = next1;
            current2 = next2;
        }
        if (current1 != null) {
            current1.next = null;
        }
    }
}
