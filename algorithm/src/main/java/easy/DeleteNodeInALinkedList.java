package easy;


import provided.vo.ListNode;

/**
 * Problem:
 * No: 237
 * Link: https://leetcode.com/problems/delete-node-in-a-linked-list/
 * <p/>
 * Analysis:
 * The node is in a singly linked list, and only the node which need to be deleted is given,
 * that means there's no way to reach the previous node of the node to be deleted.
 * As only the target node and nodes behind it can be accessed,
 * we can copy the node next to the target node's value to the target node,
 * and then delete the node next to the target node,
 * it's the same as deleting the target node.
 * For example,
 * The original linked list is 1 -> 2 -> 3 -> 4
 * After copy, the linked list change to 1 -> 2 -> 4 -> 4
 * After deletion, the linked list change to 1 -> 2 -> 4, that's exactly what is needed.
 */
public class DeleteNodeInALinkedList {
    public void deleteNode(ListNode node) {
        if (node == null || node.next == null) {
            return;
        }
        ListNode nextNode = node.next;
        node.val = nextNode.val;
        node.next = nextNode.next;
    }
}
