package algorithm.medium;

import algorithm.vo.ListNode;

/**
 * Problem:
 * No: 86
 * Link: https://leetcode.com/problems/partition-list/
 * <p/>
 * Analysis:
 * Use two lists to record the nodes whose values are less than x and
 * the nodes whose values are greater than or equals to x respectively.
 * Then link the two lists together.
 */
public class PartitionList {
    public ListNode partition(ListNode head, int x) {
        if (head == null) {
            return null;
        }

        ListNode lessListHead = new ListNode(0);
        ListNode lessListTail = lessListHead;
        ListNode greaterListHead = new ListNode(0);
        ListNode greaterListTail = greaterListHead;
        ListNode current = head;
        while (current != null) {
            if (current.val < x) {
                lessListTail.next = current;
                lessListTail = current;
            } else {
                greaterListTail.next = current;
                greaterListTail = current;
            }
            current = current.next;
        }
        lessListTail.next = greaterListHead.next;
        greaterListTail.next = null;
        return lessListHead.next;
    }
}
