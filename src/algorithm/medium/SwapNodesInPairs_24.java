package algorithm.medium;

import algorithm.vo.ListNode;

/**
 * Problem:
 * https://leetcode.com/problems/swap-nodes-in-pairs/
 * <p/>
 * Analysis:
 * Swap nodes from head pair by pair.
 */
public class SwapNodesInPairs_24 {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode newHead = head.next;
        ListNode preNode = null;
        ListNode current = head;
        while (current != null && current.next != null) {
            ListNode p1 = current;
            ListNode p2 = current.next;
            current = current.next.next;
            p2.next = p1;
            p1.next = current;
            if (preNode != null) {
                preNode.next = p2;
            }
            preNode = p1;
        }

        return newHead;
    }
}