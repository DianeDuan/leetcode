package algorithm.easy;

/**
 * Problem:
 * No: 344
 * Link: https://leetcode.com/problems/reverse-string/
 *
 * Analysis:
 * Swap characters' positions.
 */
public class ReverseString {
    public String reverseString(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }

        char[] chars = s.toCharArray();
        for (int i = 0, j = chars.length - 1; i < j; i++, j--) {
            char tmp = chars[i];
            chars[i] = chars[j];
            chars[j] = tmp;
        }
        return new String(chars);
    }
}
