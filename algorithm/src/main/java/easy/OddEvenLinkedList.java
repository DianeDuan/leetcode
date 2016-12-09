package algorithm.easy;

import algorithm.vo.ListNode;

/**
 * Problem:
 * No: 328
 * Link: https://leetcode.com/problems/odd-even-linked-list/
 * <p/>
 * Analysis:
 * Use a node to record the head of even list.
 * Use current nodes for the odd list and even list to split them.
 * In the end, link the last node of the odd list to the head node of the even list.
 */
public class OddEvenLinkedList {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode evenHead = head.next;
        ListNode oddCurrent = head;
        ListNode evenCurrent = evenHead;
        while (evenCurrent != null && evenCurrent.next != null) {
            oddCurrent.next = oddCurrent.next.next;
            oddCurrent = oddCurrent.next;
            evenCurrent.next = evenCurrent.next.next;
            evenCurrent = evenCurrent.next;
        }
        oddCurrent.next = evenHead;
        return head;
    }
}
