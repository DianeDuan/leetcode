package algorithm.easy;

import algorithm.vo.ListNode;

import java.util.Stack;

/**
 * Problem:
 * https://leetcode.com/problems/palindrome-linked-list/
 * <p/>
 * Analysis:
 * <p/>
 * Solution1:
 * Use a fast and a slow pointer to find the middle node of list.
 * Push the first half part of nodes's values into stack,
 * compare them with the second half part of nodes' values.
 * <p/>
 * Solution2:
 * Use a fast and a slow pointer to find the middle node of list.
 * Reverse second half list,
 * and the compare the first half list with the second half list.
 * <p/>
 * Reference:
 * http://www.cnblogs.com/grandyang/p/4635425.html
 */
public class PalindromeLinkedList_234 {
    //time complexity: O(n), space complexity: O(n)
    public boolean isPalindrome_solution1(ListNode head) {
        if (head == null) {
            return true;
        }

        Stack<Integer> stack = new Stack<Integer>();
        ListNode tortoise = head;
        ListNode hare = head;
        stack.add(head.val);
        while (hare.next != null && hare.next.next != null) {
            hare = hare.next.next;
            tortoise = tortoise.next;
            stack.add(tortoise.val);
        }

        if (hare.next == null) {//the count of nodes is odd
            stack.pop();
        }

        while (tortoise.next != null) {
            tortoise = tortoise.next;
            if (tortoise.val != stack.pop()) {
                return false;
            }
        }

        return true;
    }

    //time complexity: O(n), space complexity: O(1)
    public boolean isPalindrome_solution2(ListNode head) {
        if (head == null) {
            return true;
        }

        ListNode tortoise = head;
        ListNode hare = head;
        while (hare != null && hare.next != null) {
            hare = hare.next.next;
            tortoise = tortoise.next;
        }

        ListNode rightHead = reverse(tortoise);
        ListNode leftHead = head;
        while (leftHead != null && rightHead != null) {
            if (leftHead.val != rightHead.val) {
                return false;
            }
            leftHead = leftHead.next;
            rightHead = rightHead.next;
        }

        return true;
    }

    private ListNode reverse(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode tmp = null;
        ListNode current = head;
        ListNode previous = current.next;
        while (previous != null) {
            current.next = tmp;
            tmp = current;
            current = previous;
            previous = previous.next;
        }
        current.next = tmp;
        return current;
    }
}
