package algorithm.medium;

import java.util.Stack;

/**
 * Problem:
 * No: 150
 * Link: https://leetcode.com/problems/evaluate-reverse-polish-notation/
 * <p/>
 * Analysis:
 */
public class EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
        if (tokens == null || tokens.length == 0) {
            return 0;
        }

        Stack<Integer> stack = new Stack<Integer>();
        for (String token : tokens) {
            if (!token.equals("+") && !token.equals("-") && !token.equals("*") && !token.equals("/")) {
                stack.push(Integer.parseInt(token));
            } else {
                int num1 = stack.pop();
                int num2 = stack.pop();
                if (token.equals("+")) {
                    stack.push(num2 + num1);
                } else if (token.equals("-")) {
                    stack.push(num2 - num1);
                } else if (token.equals("*")) {
                    stack.push(num2 * num1);
                } else {
                    stack.push(num2 / num1);
                }
            }
        }
        return stack.pop();
    }
}
