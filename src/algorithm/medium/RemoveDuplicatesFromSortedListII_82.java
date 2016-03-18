package algorithm.medium;

import algorithm.vo.ListNode;

/**
 * Problem:
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/
 * <p/>
 * Analysis:
 * Use a variable to record the first node whose value is different from its previous node.
 * And use a variable to record if this node is duplicate,
 * and at first, treat it as it's not duplicate, until find the duplicates.
 */
public class RemoveDuplicatesFromSortedListII_82 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode previous = dummyHead, firstTmp = head, current = head.next;
        boolean isDuplicate = false;
        while (current != null) {
            if (current.val != firstTmp.val) {
                if (!isDuplicate) {
                    previous.next = firstTmp;
                    previous = firstTmp;
                }
                firstTmp = current;
                isDuplicate = false;
            } else {
                isDuplicate = true;
            }
            current = current.next;
        }
        //handle the last node or the last few duplicates
        if (isDuplicate) {
            previous.next = null;
        } else {
            previous.next = firstTmp;
        }
        return dummyHead.next;
    }
}
