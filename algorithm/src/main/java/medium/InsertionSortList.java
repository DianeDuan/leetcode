package medium;

import vo.ListNode;

/**
 * Problem:
 * No: 147
 * Link: https://leetcode.com/problems/insertion-sort-list/
 * <p/>
 * Analysis:
 * Insertion sort.
 * Use a dummy head as the head of sorted list,
 * Traverse the linked list to insert every node into the sorted list.
 */
public class InsertionSortList {
    public ListNode insertionSortList(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode dummyHead = new ListNode(0);
        ListNode current = head;
        while (current != null) {
            ListNode tmp = dummyHead;
            ListNode next = current.next;
            //find the insertion position
            while (tmp.next != null && tmp.next.val <= current.val) {
                tmp = tmp.next;
            }
            //insert
            current.next = tmp.next;
            tmp.next = current;
            //move to next node in the unsorted list
            current = next;
        }
        return dummyHead.next;
    }
}
