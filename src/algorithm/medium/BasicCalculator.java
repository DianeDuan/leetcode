package algorithm.medium;

import java.util.Stack;

/**
 * Problem:
 * No: 224
 * Link: https://leetcode.com/problems/basic-calculator/
 * <p/>
 * Analysis:
 * Use a stack to record operation signs.
 * <p/>
 * Reference:
 * https://segmentfault.com/a/1190000003796804
 */
public class BasicCalculator {
    public int calculate(String s) {
        if (s == null) {
            return 0;
        }

        s = s.replace(" ", "");
        Stack<Integer> opStack = new Stack<Integer>();
        opStack.push(1);
        int i = 0, result = 0, sign = 1;
        while (i < s.length()) {
            char c = s.charAt(i);
            if (c == '+') {
                sign = 1;
                i++;
            } else if (c == '-') {
                sign = -1;
                i++;
            } else if (c == '(') {
                opStack.push(sign * opStack.peek());
                sign = 1;
                i++;
            } else if (c == ')') {
                opStack.pop();
                i++;
            } else {
                int num = 0;
                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    num = num * 10 + s.charAt(i) - '0';
                    i++;
                }
                result += num * sign * opStack.peek();
            }
        }
        return result;
    }
}
