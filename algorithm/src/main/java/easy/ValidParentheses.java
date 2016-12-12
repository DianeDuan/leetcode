package easy;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Problem:
 * No: 20
 * Link: https://leetcode.com/problems/valid-parentheses/
 * <p/>
 * Analysis:
 * Use a stack, push when meet left parentheses and pop when meet right parentheses.
 */
public class ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        char[] chars = s.toCharArray();
        Map<Character, Character> parentheses = initParentheses();
        for (char ch : chars) {
            if (parentheses.keySet().contains(ch)) {
                stack.push(ch);
            } else if (parentheses.values().contains(ch) && stack.size() > 0) {
                char left = stack.pop();
                if (!isPaired(left, ch, parentheses)) {
                    return false;
                }
            } else {
                return false;
            }
        }
        return stack.size() == 0;
    }

    private boolean isPaired(char left, char right, Map<Character, Character> parentheses) {
        if (parentheses.containsKey(left)) {
            return right == parentheses.get(left);
        } else {
            return false;
        }
    }

    private Map<Character, Character> initParentheses() {
        Map<Character, Character> map = new HashMap<Character, Character>();
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');
        return map;
    }
}
