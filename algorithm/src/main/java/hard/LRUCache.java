package hard;

import vo.DoublyLinkedListNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Problem:
 * No: 146
 * Link: https://leetcode.com/problems/lru-cache/
 * <p/>
 * Analysis:
 * Use a map to get value in O(1),
 * and use a doubly linked list to keep the access order of nodes.
 * <p/>
 * Reference:
 * http://www.cnblogs.com/springfor/p/3869393.html
 */
public class LRUCache {
    private Map<Integer, DoublyLinkedListNode> map;
    private int capacity = -1;
    private DoublyLinkedListNode head = new DoublyLinkedListNode(-1, -1);
    private DoublyLinkedListNode tail = new DoublyLinkedListNode(-1, -1);

    public LRUCache(int capacity) {
        if (capacity >= 0) {
            this.capacity = capacity;
            map = new HashMap<Integer, DoublyLinkedListNode>(capacity);
            head.next = tail;
        }
    }

    public int get(int key) {
        if (map != null && map.containsKey(key)) {
            DoublyLinkedListNode node = map.get(key);
            moveToHead(node);
            return node.value;
        } else {
            return -1;
        }
    }

    public void set(int key, int value) {
        if (map == null) {
            return;
        }

        //modify existing node
        if (map.containsKey(key)) {
            DoublyLinkedListNode node = map.get(key);
            node.value = value;
            moveToHead(node);
            return;
        }

        //add new node
        DoublyLinkedListNode newNode = new DoublyLinkedListNode(key, value);
        if (map.size() >= capacity) {
            DoublyLinkedListNode lruNode = removeBeforeTail();
            if (lruNode != null) {
                map.remove(lruNode.key);
            }
        }
        addBehindHead(newNode);
        map.put(key, newNode);
    }

    private void remove(DoublyLinkedListNode node) {
        if (node == null || node.previous == null || node.next == null) {
            return;
        }

        node.previous.next = node.next;
        node.next.previous = node.previous;
    }

    private DoublyLinkedListNode removeBeforeTail() {
        if (head == null || tail == null || head.next == tail) {
            return null;
        }

        DoublyLinkedListNode lastNode = tail.previous;
        remove(lastNode);
        return lastNode;
    }

    private void addBehindHead(DoublyLinkedListNode newNode) {
        if (head == null || tail == null) {
            return;
        }

        newNode.next = head.next;
        head.next.previous = newNode;
        head.next = newNode;
        newNode.previous = head;
    }

    private void moveToHead(DoublyLinkedListNode node) {
        if (node == null) {
            return;
        }

        remove(node);
        addBehindHead(node);
    }
}

