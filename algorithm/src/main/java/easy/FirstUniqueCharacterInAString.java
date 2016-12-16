package easy;

import java.util.HashMap;
import java.util.Map;

/**
 * Problem:
 * No: 387
 * Link: https://leetcode.com/problems/first-unique-character-in-a-string/
 * <p>
 * Analysis:
 * Scan the string to get a mapping between its characters and their appearance times.
 * Scan the string again to get the first character which only appears once according to the mapping.
 */
public class FirstUniqueCharacterInAString {
    public int firstUniqChar(String s) {
        if (s == null || s.length() == 0) {
            return -1;
        }

        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            int count = map.containsKey(c) ? (map.get(c) + 1) : 1;
            map.put(c, count);
        }

        for (int i = 0; i < s.length(); i++) {
            int count = map.get(s.charAt(i));
            if (count == 1) {
                return i;
            }
        }
        return -1;
    }
}
