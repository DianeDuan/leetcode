package easy;

import java.util.HashMap;
import java.util.Map;

/**
 * Problem:
 * No: 409
 * Link: https://leetcode.com/problems/longest-palindrome/
 * <p>
 * Analysis:
 * Scan the string to get a mapping between its characters and their appearance times.
 * Count the number of character pairs, and record if there is any character which appears odd times in the meantime.
 * If there is any character which appears odd times, which means you can use one in the middle of a palindrome string.
 */
public class LongestPalindrome {
    public int longestPalindrome(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            int count = map.containsKey(c) ? (map.get(c) + 1) : 1;
            map.put(c, count);
        }

        int pairCount = 0;
        boolean hasSingle = false;
        for (int count : map.values()) {
            pairCount += (count / 2);
            if (!hasSingle && (count % 2 == 1)) {
                hasSingle = true;
            }
        }

        return hasSingle ? (pairCount * 2 + 1) : (pairCount * 2);
    }
}
