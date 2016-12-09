package algorithm.easy;

import java.util.LinkedList;
import java.util.List;

/**
 * Problem:
 * No: 155
 * Link: https://leetcode.com/problems/min-stack/
 * <p/>
 * Analysis:
 * Recalculate min element when push and pop.
 * Another solution is use a stack to record current minimum elements, it use twice memory.
 */
public class MinStack {
    private List<Integer> stack = new LinkedList<Integer>();
    private int min = Integer.MAX_VALUE;

    public void push(int x) {
        if (x < min) {
            min = x;
        }
        stack.add(x);
    }

    public void pop() {
        int element = stack.remove(stack.size() - 1);
        if (element == min) {
            min = Integer.MAX_VALUE;
            for (int item : stack) {
                if (item < min) {
                    min = item;
                }
            }
        }
    }

    public int top() {
        return stack.get(stack.size() - 1);
    }

    public int getMin() {
        return min;
    }
}
