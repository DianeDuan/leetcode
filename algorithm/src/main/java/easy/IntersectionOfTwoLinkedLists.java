package easy;

import vo.ListNode;

/**
 * Problem:
 * No: 160
 * Link: https://leetcode.com/problems/intersection-of-two-linked-lists/
 * <p/>
 * Analysis:
 * If there is a intersection node of two lists,
 * move a few steps first from the longer list,
 * the count of steps is the difference between the length of longer list and the length of shorter list,
 * and then the distance1, which is between the moved pointer and the intersection node ,
 * and the distance2, which is between the shorter list's head node and the intersection node,
 * is equal.
 * <p/>
 * Reference:
 * http://www.danielbit.com/blog/puzzle/leetcode/leetcode-intersection-of-two-linked-lists
 * http://bookshadow.com/weblog/2014/12/04/leetcode-intersection-two-linked-lists/
 */
public class IntersectionOfTwoLinkedLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        int lengthA = getListLength(headA);
        int lengthB = getListLength(headB);
        ListNode currentA = headA;
        ListNode currentB = headB;
        if (lengthA > lengthB) {
            currentA = move(currentA, lengthA - lengthB);
        } else {
            currentB = move(currentB, lengthB - lengthA);
        }

        while (currentA != null && currentB != null) {
            if (currentA == currentB) {
                return currentA;
            }
            currentA = currentA.next;
            currentB = currentB.next;
        }

        return null;
    }

    private int getListLength(ListNode head) {
        int length = 0;
        ListNode current = head;
        while (current != null) {
            length++;
            current = current.next;
        }
        return length;
    }

    private ListNode move(ListNode current, int step) {
        while (current != null && step > 0) {
            current = current.next;
            step--;
        }
        return current;
    }
}
