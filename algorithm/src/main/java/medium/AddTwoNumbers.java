package medium;

import vo.ListNode;

/**
 * Problem:
 * No: 2
 * Link: https://leetcode.com/problems/add-two-numbers/
 * <p/>
 * Analysis:
 * Use a variable to record carry value.
 * Traverse the two list simultaneously,
 * and add the corresponding nodes's value to get new nodes and set carry variable.
 */
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        int carry = 0;
        ListNode p1 = l1, p2 = l2;
        ListNode dummyHead = new ListNode(0);
        ListNode tail = dummyHead;
        while (p1 != null || p2 != null) {
            int sum = carry;
            if (p1 != null) {
                sum += p1.val;
                p1 = p1.next;
            }
            if (p2 != null) {
                sum += p2.val;
                p2 = p2.next;
            }
            carry = sum / 10;
            sum %= 10;
            tail.next = new ListNode(sum);
            tail = tail.next;
        }
        if (carry != 0) {
            tail.next = new ListNode(carry);
        }
        return dummyHead.next;
    }
}
