package easy;

import java.util.Arrays;

/**
 * Problem:
 * No: 389
 * Link: https://leetcode.com/problems/find-the-difference/
 * <p>
 * Analysis:
 * Sort the chars of the two strings, compare from the first char to the last char to find the first different char
 */
public class FindTheDifference {
    public char findTheDifference(String s, String t) {
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();

        Arrays.sort(sChars);
        Arrays.sort(tChars);

        char result = tChars[tChars.length - 1];
        for (int i = 0; i < sChars.length; i++) {
            if (tChars[i] != sChars[i]) {
                result = tChars[i];
                break;
            }
        }
        return result;
    }
}
