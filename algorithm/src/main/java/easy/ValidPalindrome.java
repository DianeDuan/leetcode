package easy;

/**
 * Problem:
 * No: 125
 * Link: https://leetcode.com/problems/valid-palindrome/
 * <p/>
 * Analysis:
 * Need to pay attention to some special cases.
 */
public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        if (s == null) {
            return false;
        }
        s = s.toLowerCase();
        int start = 0;
        int end = s.length() - 1;
        while (start < end) {
            if (isValid(s.charAt(start)) && isValid(s.charAt(end))) {
                if (s.charAt(start) != s.charAt(end)) {
                    return false;
                }
                start++;
                end--;
            } else {
                if (!isValid(s.charAt(start))) {
                    start++;
                }
                if (!isValid(s.charAt(end))) {
                    end--;
                }
            }
        }
        return true;
    }

    private boolean isValid(char c) {
        if (c >= '0' && c <= '9') {
            return true;
        }
        if (c >= 'a' && c <= 'z') {
            return true;
        }
        if (c >= 'A' && c <= 'Z') {
            return true;
        }
        return false;
    }
}
