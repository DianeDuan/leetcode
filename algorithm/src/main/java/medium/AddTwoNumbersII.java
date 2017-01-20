package medium;

import provided.vo.ListNode;

/**
 * Problem:
 * No: 445
 * Link: https://leetcode.com/problems/add-two-numbers-ii/
 * <p>
 * Analysis:
 * Reverse the two linked list and add them node by node.
 */
public class AddTwoNumbersII {
    public ListNode addTwoNumbersSolution1(ListNode l1, ListNode l2) {
        ListNode p1 = reverse(l1);
        ListNode p2 = reverse(l2);

        int carry = 0;
        ListNode result = new ListNode(-1);
        ListNode current = result;
        while (p1 != null && p2 != null) {
            int sum = p1.val + p2.val + carry;
            carry = sum / 10;
            current.next = new ListNode(sum % 10);
            current = current.next;
            p1 = p1.next;
            p2 = p2.next;
        }

        while (p1 != null) {
            int sum = p1.val + carry;
            carry = sum / 10;
            current.next = new ListNode(sum % 10);
            current = current.next;
            p1 = p1.next;
        }
        while (p2 != null) {
            int sum = p2.val + carry;
            carry = sum / 10;
            current.next = new ListNode(sum % 10);
            current = current.next;
            p2 = p2.next;
        }

        while (carry != 0) {
            current.next = new ListNode(carry % 10);
            carry = carry / 10;
        }

        ListNode tmp = result.next;
        result.next = null;
        return reverse(tmp);
    }

    private ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode previous = head;
        ListNode current = head.next;
        while (current != null) {
            ListNode next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        head.next = null;
        return previous;
    }
}
