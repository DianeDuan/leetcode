package algorithm.medium;

import algorithm.vo.ListNode;

/**
 * Problem:
 * No: 141
 * Link: https://leetcode.com/problems/linked-list-cycle/
 * <p/>
 * Analysis:
 * Use Floyd's cycle-finding algorithm.
 * <p/>
 * Reference:
 * https://en.wikipedia.org/wiki/Cycle_detection?oldformat=true
 */
public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        ListNode hare = head;
        ListNode tortoise = head;
        while (hare != null) {
            if (hare.next != null && hare.next.next != null) {
                hare = hare.next.next;
                tortoise = tortoise.next;
                if (hare == tortoise) {
                    return true;
                }
            } else {
                return false;
            }
        }
        return false;
    }
}
