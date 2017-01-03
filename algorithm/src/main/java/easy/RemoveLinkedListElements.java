package easy;

import provided.vo.ListNode;

/**
 * Problem:
 * No: 203
 * Link: https://leetcode.com/problems/remove-linked-list-elements/
 * <p/>
 * Analysis:
 * First remove the nodes' whose value are val in the head part of the list,
 * then continue to use previous pointer and current pointer to traverse the list and remove elements.
 */
public class RemoveLinkedListElements {
    public ListNode removeElements(ListNode head, int val) {
        while (head != null && head.val == val) {
            head = head.next;
        }

        if (head == null) {
            return null;
        }

        ListNode current = head.next;
        ListNode previous = head;
        while (current != null) {
            if (current.val == val) {
                previous.next = current.next;
                current = current.next;
            } else {
                current = current.next;
                previous = previous.next;
            }
        }
        return head;
    }
}
