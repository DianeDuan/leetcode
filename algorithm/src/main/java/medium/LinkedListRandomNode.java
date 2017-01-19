package medium;

import provided.vo.ListNode;

import java.util.Random;

/**
 * Problem:
 * No: 382
 * Link: https://leetcode.com/problems/linked-list-random-node/
 * <p>
 * Analysis:
 * For this problem, we can surely traverse the linked list, thus find out its length n,
 * then we only need to generate a random number from range [0, n), and return the corresponding node value.
 * But if the linked list is so long that we can not know its length,
 * we can use the reservoir sampling algorithm to solve this problem.
 * <p>
 * Reference:
 * https://en.wikipedia.org/wiki/Reservoir_sampling?oldformat=true
 */
public class LinkedListRandomNode {
    private ListNode head;

    /**
     * @param head The linked list's head.
     *             Note that the head is guaranteed to be not null, so it contains at least one node.
     */
    public LinkedListRandomNode(ListNode head) {
        this.head = head;
    }

    /**
     * Returns a random node's value.
     */
    public int getRandom() {
        ListNode current = head.next;
        int k = 2;
        int result = head.val;
        while (current != null) {
            int i = new Random().nextInt(k);
            if (i == 0) {
                result = current.val;
            }
            current = current.next;
            k++;
        }
        return result;
    }
}
