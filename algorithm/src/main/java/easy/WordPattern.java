package easy;

import java.util.HashMap;
import java.util.Map;

/**
 * Problem:
 * No: 290
 * Link: https://leetcode.com/problems/word-pattern/
 * <p/>
 * Analysis:
 * Use a map to record mappings between pattern chars and words.
 */
public class WordPattern {
    public boolean wordPattern(String pattern, String str) {
        if (pattern == null || str == null) {
            return false;
        }

        String[] words = str.split(" ");
        if (pattern.length() != words.length) {
            return false;
        }

        Map<Character, String> mapping = new HashMap<Character, String>();
        char[] patternChars = pattern.toCharArray();
        for (int i = 0; i < patternChars.length; i++) {
            if (!mapping.containsKey(patternChars[i])) {
                if (mapping.containsValue(words[i])) {
                    return false;
                } else {
                    mapping.put(patternChars[i], words[i]);
                }
            } else if (!mapping.get(patternChars[i]).equals(words[i])) {
                return false;
            }
        }
        return true;
    }
}
