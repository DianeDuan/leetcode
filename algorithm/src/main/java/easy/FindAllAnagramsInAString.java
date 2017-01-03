package easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem:
 * No: 438
 * Link: https://leetcode.com/problems/find-all-anagrams-in-a-string/
 * <p>
 * Analysis:
 * Initialize an integer array to record the letter counts of p string.
 * Use a left pointer and a right pointer to compose a slide window.
 * Every time move the right pointer once and record if the corresponding character
 * matches one of unused p string characters,
 * and if the window size reaches p string size,
 * move the left pointer too.
 */
public class FindAllAnagramsInAString {
    public List<Integer> findAnagrams(String s, String p) {
        if (s == null || p == null || s.length() < p.length()) {
            return new ArrayList<>();
        }

        int[] pCharCounts = new int[26];
        for (char c : p.toCharArray()) {
            pCharCounts[c - 'a']++;
        }

        List<Integer> result = new ArrayList<>();
        int unusedCount = p.length(), left = 0, right = 0;
        while (right < s.length()) {
            //record if if the corresponding character matches one of unused p string characters
            if (pCharCounts[s.charAt(right) - 'a'] > 0) {
                unusedCount--;
            }

            //record the character's appearance, and move the right pointer
            pCharCounts[s.charAt(right) - 'a']--;
            right++;

            if (unusedCount == 0) {
                result.add(left);
            }

            if ((right - left) == p.length()) {
                //means the left pointer point to a character which have been recorded
                if (pCharCounts[s.charAt(left) - 'a'] >= 0) {
                    unusedCount++;
                }

                pCharCounts[s.charAt(left) - 'a']++;
                left++;
            }
        }
        return result;
    }
}