package algorithm.medium;

import algorithm.vo.ListNode;

/**
 * Problem:
 * https://leetcode.com/problems/linked-list-cycle-ii/
 * <p/>
 * Analysis:
 * Floyd's cycle-finding algorithm.
 */
public class LinkedListCycleII_142 {
    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode tortoise = head;
        ListNode hare = head;
        while ((tortoise != null) && (hare != null)) {
            if (hare.next != null) {
                hare = hare.next.next;
            } else {
                return null;
            }
            tortoise = tortoise.next;
            if (tortoise == hare) {//the list has cycle
                return findCycleStart(head, tortoise);
            }
        }
        return null;//the list doesn't have cycle
    }

    private ListNode findCycleStart(ListNode head, ListNode meet) {
        ListNode p1 = head;
        ListNode p2 = meet;
        while (p1 != p2) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1;
    }
}
