package easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem:
 * No: 459
 * Link: https://leetcode.com/problems/repeated-substring-pattern/
 * <p>
 * Analysis:
 * Find all the characters in the string which are the same letter with the first character,
 * thus we can get all the possible repeated substring length.
 * Then try to test every possible substring if it is the repeated substring.
 */
public class RepeatedSubstringPattern {
    public boolean repeatedSubstringPattern(String str) {
        List<Integer> possibleSubstrLengths = new ArrayList<>();
        char firstChar = str.charAt(0);

        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == firstChar) {
                possibleSubstrLengths.add(i);
            }
        }

        for (int curLength : possibleSubstrLengths) {
            String substr = str.substring(0, curLength);
            boolean result = true;
            int start = curLength;
            while (start < str.length() && (start + curLength) <= str.length()) {
                if (!str.substring(start, start + curLength).equals(substr)) {
                    result = false;
                    break;
                }
                start += curLength;
            }
            if (result && start >= str.length()) {
                return true;
            }
        }
        return false;
    }
}
