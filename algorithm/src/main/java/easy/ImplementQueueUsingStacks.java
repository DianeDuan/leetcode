package easy;

import java.util.Stack;

/**
 * Problem:
 * No: 232
 * Link: https://leetcode.com/problems/implement-queue-using-stacks/
 * <p/>
 * Analysis:
 * Put the last in element in the bottom of stack.
 */
public class ImplementQueueUsingStacks {
    Stack<Integer> queue = new Stack<Integer>();
    Stack<Integer> inner = new Stack<Integer>();

    // Push element x to the back of queue.
    public void push(int x) {
        while (!queue.empty()) {
            inner.push(queue.pop());
        }
        queue.push(x);
        while (!inner.empty()) {
            queue.push(inner.pop());
        }
    }

    // Removes the element from in front of queue.
    public void pop() {
        queue.pop();
    }

    // Get the front element.
    public int peek() {
        return queue.peek();
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return queue.empty();
    }
}
