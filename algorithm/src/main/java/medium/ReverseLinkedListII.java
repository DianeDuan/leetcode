package medium;

import vo.ListNode;

/**
 * Problem:
 * No: 92
 * Link: https://leetcode.com/problems/reverse-linked-list-ii/
 * <p/>
 * Analysis:
 * Add dummy head node to simplify the reverse process.
 * Record the node before the start and the start of the partial list which is needed to be reversed.
 * Reverse the partial list between mth node and nth node.
 * Link the reversed partial list to the whole list.
 */
public class ReverseLinkedListII {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null) {
            return null;
        }

        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        int position = 1;
        ListNode previous = dummyHead;
        ListNode current = head;
        while (position < m) {
            current = current.next;
            previous = previous.next;
            position++;
        }
        ListNode preStart = previous;
        ListNode start = current;
        ListNode next = current.next;
        while (position < n) {
            previous = current;
            current = next;
            next = next.next;
            current.next = previous;
            position++;
        }
        preStart.next = current;
        start.next = next;
        return dummyHead.next;
    }
}
