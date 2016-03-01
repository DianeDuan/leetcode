package algorithm.medium;

import algorithm.vo.ListNode;

/**
 * Problem:
 * https://leetcode.com/problems/insertion-sort-list/
 * <p/>
 * Analysis:
 */
public class InsertionSortList_147 {
    public ListNode insertionSortList(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode dummyHead = new ListNode(0);
        ListNode current = head;
        while (current != null) {
            ListNode tmp = dummyHead;
            ListNode next = current.next;
            while (tmp.next != null && tmp.next.val <= current.val) {
                tmp = tmp.next;
            }
            current.next = tmp.next;
            tmp.next = current;
            current = next;
        }
        return dummyHead.next;
    }
}
