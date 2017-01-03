package hard;

import provided.vo.RandomListNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Problem:
 * No: 138
 * Link: https://leetcode.com/problems/copy-list-with-random-pointer/
 * <p/>
 * Analysis:
 * <p/>
 * Solution1:
 * Use a map to record the original nodes and the new copy nodes' mappings.
 * Copy the original nodes and link the copy nodes as a new list.
 * Use the map to copy the random relations.
 * <p/>
 * Solution2:
 * Copy new nodes and insert them next to the original ones.
 * Copy the random pointers.
 * Decouple the original list and the copy list
 * <p/>
 * Reference:
 * http://blog.csdn.net/linhuanmars/article/details/22463599
 * http://fisherlei.blogspot.com/2013/11/leetcode-copy-list-with-random-pointer.html
 */
public class CopyListWithRandomPointer {
    //time complexity: O(n), space complexity: O(n)
    public RandomListNode copyRandomListSolution1(RandomListNode head) {
        if (head == null) {
            return null;
        }

        Map<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
        RandomListNode current = head;
        RandomListNode dummyHead = new RandomListNode(0);
        RandomListNode tail = dummyHead;
        while (current != null) {
            RandomListNode newNode = new RandomListNode(current.label);
            map.put(current, newNode);
            tail.next = newNode;
            tail = tail.next;
            current = current.next;
        }
        for (Map.Entry<RandomListNode, RandomListNode> entry : map.entrySet()) {
            entry.getValue().random = map.get(entry.getKey().random);
        }
        return dummyHead.next;
    }

    //time complexity: O(n), space complexity: O(1)
    public RandomListNode copyRandomListSolution2(RandomListNode head) {
        if (head == null) {
            return null;
        }

        //copy new nodes and insert them next to the original ones
        RandomListNode current = head;
        while (current != null) {
            RandomListNode newNode = new RandomListNode(current.label);
            RandomListNode next = current.next;
            current.next = newNode;
            newNode.next = next;
            current = next;
        }
        //copy the random pointers
        current = head;
        while (current != null) {
            if (current.random != null) {
                current.next.random = current.random.next;
            }
            current = current.next.next;
        }
        //decouple the original list and the copy list
        current = head;
        RandomListNode newHead = head.next;
        while (current != null) {
            RandomListNode copy = current.next;
            RandomListNode nextCopy = null;
            if (current.next.next != null) {
                nextCopy = current.next.next.next;
            }

            current.next = current.next.next;
            current = current.next;
            copy.next = nextCopy;
        }
        return newHead;
    }
}
