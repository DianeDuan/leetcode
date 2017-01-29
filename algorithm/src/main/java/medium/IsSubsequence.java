package medium;

/**
 * Problem:
 * No: 392
 * Link: https://leetcode.com/problems/is-subsequence/
 * <p>
 * Analysis:
 * Scan the two strings to check if s is a substring of t.
 */
public class IsSubsequence {
    public boolean isSubsequence(String s, String t) {
        return isSubsequence(s, 0, t, 0);
    }

    private boolean isSubsequence(String s, int sStart, String t, int tStart) {
        int i = sStart;
        while (i < s.length()) {
            int j = tStart;
            while (j < t.length()) {
                if (s.charAt(i) == t.charAt(j)) {
                    return isSubsequence(s, i + 1, t, j + 1);
                }
                j++;
            }
            if (j == t.length()) {
                return false;
            }
            i++;
        }
        return i == s.length();
    }
}
