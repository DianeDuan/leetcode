package easy;

import vo.ListNode;

/**
 * Problem:
 * No: 83
 * Link: https://leetcode.com/problems/remove-duplicates-from-sorted-list/
 * <p/>
 * Analysis:
 * Traverse the list,
 * if the next node has the same value with the current node, remove the next node,
 * and check next node, an so on,
 * don't move the current pointer until find a different value node.
 */
public class RemoveDuplicatesFromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode current = head;
        while (current != null && current.next != null) {
            if (current.val == current.next.val) {
                ListNode tmp = current.next;
                current.next = tmp.next;
                tmp.next = null;
            } else {
                current = current.next;
            }
        }
        return head;
    }
}
