package easy;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Problem:
 * No: 225
 * Link: https://leetcode.com/problems/implement-stack-using-queues/
 * <p/>
 * Analysis:
 * Put last in element to the head of queue.
 */
public class ImplementStackUsingQueues {
    Queue<Integer> stack = new LinkedList<Integer>();
    Queue<Integer> inner = new LinkedList<Integer>();

    // Push element x onto stack.
    public void push(int x) {
        while (!stack.isEmpty()) {
            inner.add(stack.poll());
        }
        stack.add(x);
        while (!inner.isEmpty()) {
            stack.add(inner.poll());
        }
    }

    // Removes the element on top of the stack.
    public void pop() {
        stack.poll();
    }

    // Get the top element.
    public int top() {
        return stack.peek();
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return stack.isEmpty();
    }
}
