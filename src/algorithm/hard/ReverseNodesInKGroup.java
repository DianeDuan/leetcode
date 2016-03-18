package algorithm.hard;

import algorithm.vo.ListNode;

/**
 * Problem:
 * No: 25
 * Link: https://leetcode.com/problems/reverse-nodes-in-k-group/
 * <p/>
 * Analysis:
 */
public class ReverseNodesInKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) {
            return null;
        }

        ListNode dummyHead = new ListNode(0);
        ListNode currentHead = head;
        ListNode currentTail;
        ListNode current = head;
        int count = 1;
        while (current != null) {
            if (count == k) {
                currentTail = current;
                currentTail.next = dummyHead.next;
                dummyHead.next = reverse(currentHead, currentTail);
                current = current.next;
                currentHead = current;
                count = 2;
            } else {
                count++;
                current = current.next;
            }
        }
        if (count > 0) {//the count of elements in the last group is less than k
        }
        return dummyHead.next;
    }

    private ListNode reverse(ListNode head, ListNode tail) {
        if (head == null || tail == null) {
            return null;
        }

        ListNode previous = head;
        ListNode current = head.next;
        previous.next = null;
        while (current != null) {
            ListNode tmp = current.next;
            current.next = previous;
            previous = current;
            current = tmp;
        }
        return previous;
    }
}
