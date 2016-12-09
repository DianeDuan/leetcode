package algorithm.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem:
 * No: 22
 * Link: https://leetcode.com/problems/generate-parentheses/
 * <p/>
 * Analysis:
 * Recursive solution.
 * <p/>
 * Reference:
 * http://blog.csdn.net/linhuanmars/article/details/19873463
 */
public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        if (n <= 0) {
            return new ArrayList<String>();
        }

        return generate(n, n, "");
    }

    private List<String> generate(int left, int right, String currentStr) {
        List<String> result = new ArrayList<String>();
        if (left == 0 && right == 0) {
            result.add(currentStr);
        } else if (left <= right) {
            if (left > 0) {
                result.addAll(generate(left - 1, right, currentStr + "("));
            }
            if (right > 0) {
                result.addAll(generate(left, right - 1, currentStr + ")"));
            }
        }
        return result;
    }
}
