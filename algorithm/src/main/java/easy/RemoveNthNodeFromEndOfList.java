package easy;

import provided.vo.ListNode;

/**
 * Problem:
 * No: 19
 * Link: https://leetcode.com/problems/remove-nth-node-from-end-of-list/
 * <p/>
 * Analysis:
 * Use two pointers.
 * The first pointer moves n step(s),
 * and the two pointers move together,
 * then when the first pointer reaches the last node,
 * the second pointer reaches the node before nth node from end of the list.
 */
public class RemoveNthNodeFromEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (n <= 0) {
            return head;
        }

        //the first pointer move n step(s) first
        ListNode p1 = head;
        for (int i = 0; i < n; i++) {
            p1 = p1.next;
        }

        //the nth node is head node
        if (p1 == null) {
            ListNode next = head.next;
            head.next = null;
            return next;
        }

        //the nth node is not head node
        ListNode p2 = head;
        while (p1.next != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        p2.next = p2.next.next;
        return head;
    }
}
