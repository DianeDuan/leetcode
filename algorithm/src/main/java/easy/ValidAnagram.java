package easy;

import java.util.HashMap;
import java.util.Map;

/**
 * Problem:
 * No: 242
 * Link: https://leetcode.com/problems/valid-anagram/
 * <p/>
 * Analysis:
 * <p/>
 * Solution1:
 * If only process english 26 characters, use an array to record 26 numbers is enough.
 * Traverse the string s to add 1 to the corresponding number for every character's occurrence,
 * and then traverse the string t to minus 1 from the corresponding number for every character's occurrence.
 * If string t is valid anagram of string s, all of the array's number should be zero.
 * <p/>
 * Solution2:
 * Use map to record the characters' times of occurrence for each string,
 * and then compare if the two maps is equal.
 * As java supports unicode, this solution supports all the unicode characters.
 */
public class ValidAnagram {
    //input can only contains english 26 characters
    public boolean isAnagramSolution1(String s, String t) {
        if (s == null || t == null) {
            return s == t;
        }

        int[] charCount = new int[26];
        for (char ch : s.toCharArray()) {
            int position = Character.getNumericValue(ch) - 10;
            charCount[position]++;
        }
        for (char ch : t.toCharArray()) {
            int position = Character.getNumericValue(ch) - 10;
            charCount[position]--;
        }
        for (int count : charCount) {
            if (count != 0) {
                return false;
            }
        }
        return true;
    }

    //input can contains all the unicode character
    public boolean isAnagramSolution2(String s, String t) {
        if (s == null || t == null) {
            return s == t;
        }
        Map<Character, Integer> charCountMap1 = getCharCount(s.toCharArray());
        Map<Character, Integer> charCountMap2 = getCharCount(t.toCharArray());
        return compareCharCountMaps(charCountMap1, charCountMap2);
    }

    private Map<Character, Integer> getCharCount(char[] chars) {
        Map<Character, Integer> charCount = new HashMap<Character, Integer>();
        if (chars != null) {
            for (char ch : chars) {
                if (charCount.containsKey(ch)) {
                    int count = charCount.get(ch);
                    charCount.put(ch, count + 1);
                } else {
                    charCount.put(ch, 1);
                }
            }
        }
        return charCount;
    }

    private boolean compareCharCountMaps(Map<Character, Integer> m1, Map<Character, Integer> m2) {
        if (m1 == null || m2 == null) {
            return m1 == m2;
        }
        if (m1.size() != m2.size()) {
            return false;
        }
        for (Character key : m1.keySet()) {
            if (!m2.containsKey(key) || !m2.get(key).equals(m1.get(key))) {
                return false;
            }
        }
        return true;
    }
}
