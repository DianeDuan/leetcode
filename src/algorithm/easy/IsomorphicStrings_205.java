package algorithm.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * Problem:
 * https://leetcode.com/problems/isomorphic-strings/
 * <p/>
 * Analysis:
 * Use a map to record mappings.
 */
public class IsomorphicStrings_205 {
    public boolean isIsomorphic(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) {
            return false;
        }

        Map<Character, Character> replaceMap = new HashMap<Character, Character>();
        char[] src = s.toCharArray();
        char[] dst = t.toCharArray();
        StringBuilder replacedStrBuilder = new StringBuilder();
        for (int i = 0; i < src.length; i++) {
            if (!replaceMap.containsKey(src[i])) {
                if (replaceMap.values().contains(dst[i])) {
                    return false;
                } else {
                    replaceMap.put(src[i], dst[i]);
                }
            }
            replacedStrBuilder.append(replaceMap.get(src[i]));
        }
        return replacedStrBuilder.toString().equals(t);
    }
}
