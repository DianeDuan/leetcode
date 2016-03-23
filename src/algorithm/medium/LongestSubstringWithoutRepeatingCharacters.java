package algorithm.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem:
 * No: 3
 * Link: https://leetcode.com/problems/longest-substring-without-repeating-characters/
 * <p/>
 * Analysis:
 * Use a list to record used characters of current substring.
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int max = 0;
        StringBuilder current = new StringBuilder();
        List<Character> used = new ArrayList<Character>();
        for (int i = 0; i < s.length(); i++) {
            if (!used.contains(s.charAt(i))) {
                used.add(s.charAt(i));
                current.append(s.charAt(i));
            } else {
                max = Math.max(max, current.length());
                int pos = current.indexOf(String.valueOf(s.charAt(i)));
                String before = current.substring(0, pos + 1);
                String after = current.substring(pos + 1);
                clearBefore(used, before);
                current = new StringBuilder(after);
                current.append(s.charAt(i));
                used.add(s.charAt(i));

            }
        }
        return Math.max(max, current.length());
    }

    private void clearBefore(List<Character> used, String before) {
        if (used == null || before == null) {
            return;
        }

        for (Character c : before.toCharArray()) {
            used.remove(c);
        }
    }
}
