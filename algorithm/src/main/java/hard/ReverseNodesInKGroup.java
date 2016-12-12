package hard;

import vo.ListNode;

/**
 * Problem:
 * No: 25
 * Link: https://leetcode.com/problems/reverse-nodes-in-k-group/
 * <p/>
 * Analysis:
 * Traverse the list, record the head and the tail of every group,
 * and revere the nodes between them.
 * Add every reversed group to a new list.
 * If the count of nodes in the last group is less than k,
 * add the last group to the new list without reversion.
 */
public class ReverseNodesInKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k <= 0) {
            return head;
        }

        ListNode dummyHead = new ListNode(0);
        ListNode newTail = dummyHead;
        ListNode currentHead = head;
        ListNode current = head;
        int count = 0;
        while (current != null) {
            count++;
            if (count != k) {
                current = current.next;
            } else {
                ListNode next = current.next;
                newTail.next = reverse(currentHead, next);
                newTail = currentHead;
                current = next;
                currentHead = current;
                count = 0;
            }
        }
        if (count > 0) {//the count of elements in the last group is less than k
            newTail.next = currentHead;
        }
        return dummyHead.next;
    }

    private ListNode reverse(ListNode head, ListNode tail) {
        if (head == null) {
            return null;
        }

        ListNode previous = head;
        ListNode current = head.next;
        previous.next = null;
        while (current != tail) {
            ListNode tmp = current.next;
            current.next = previous;
            previous = current;
            current = tmp;
        }
        return previous;
    }
}
