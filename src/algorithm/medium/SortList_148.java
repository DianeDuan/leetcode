package algorithm.medium;

import algorithm.vo.ListNode;

/**
 * Problem:
 * https://leetcode.com/problems/sort-list/
 * <p/>
 * Analysis:
 * Merge sort.
 * <p/>
 * Reference:
 * http://www.cnblogs.com/springfor/p/3869372.html
 */
public class SortList_148 {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode midNode = getMidNode(head);
        ListNode secondList = midNode.next;
        midNode.next = null;
        ListNode leftHead = null, rightHead = null;
        if (head != secondList) {
            leftHead = sortList(head);
            rightHead = sortList(secondList);
        }
        return mergeTwoSortedList(leftHead, rightHead);
    }

    private ListNode getMidNode(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode hare = head, tortoise = head;
        while (hare.next != null && hare.next.next != null) {
            hare = hare.next.next;
            tortoise = tortoise.next;
        }
        return tortoise;
    }

    private ListNode mergeTwoSortedList(ListNode head1, ListNode head2) {
        if (head1 == null) {
            return head2;
        }
        if (head2 == null) {
            return head1;
        }

        ListNode dummyHead = new ListNode(0);
        ListNode tail = dummyHead;
        ListNode current1 = head1, current2 = head2;
        while (current1 != null && current2 != null) {
            if (current1.val < current2.val) {
                tail.next = current1;
                current1 = current1.next;
            } else {
                tail.next = current2;
                current2 = current2.next;
            }
            tail = tail.next;
        }
        if (current1 != null) {
            tail.next = current1;
        }
        if (current2 != null) {
            tail.next = current2;
        }
        return dummyHead.next;
    }
}
