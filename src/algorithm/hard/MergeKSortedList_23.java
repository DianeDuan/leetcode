package algorithm.hard;

import algorithm.vo.ListNode;

/**
 * Problem:
 * https://leetcode.com/problems/merge-k-sorted-lists/
 * <p/>
 * Analysis:
 * Merge sort.
 * <p/>
 * Reference:
 * http://www.cnblogs.com/springfor/p/3869217.html
 */
public class MergeKSortedList_23 {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        return mergeSort(lists, 0, lists.length - 1);
    }

    private ListNode mergeSort(ListNode[] lists, int start, int end) {
        if (start >= end) {
            return lists[end];
        }

        int mid = (start + end) / 2;
        ListNode leftHead = mergeSort(lists, start, mid);
        ListNode rightHead = mergeSort(lists, mid + 1, end);
        return mergeTwoSortedList(leftHead, rightHead);
    }

    private ListNode mergeTwoSortedList(ListNode head1, ListNode head2) {
        if (head1 == null) {
            return head2;
        }
        if (head2 == null) {
            return head1;
        }

        ListNode current1 = head1, current2 = head2;
        ListNode dummyHead = new ListNode(0);
        ListNode tail = dummyHead;
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
