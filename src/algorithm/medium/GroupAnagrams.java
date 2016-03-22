package algorithm.medium;

import java.util.*;

/**
 * Problem:
 * No: 49
 * Link: https://leetcode.com/problems/anagrams/
 * <p/>
 * Analysis:
 * Sort every string by lexicographic order to find its anagram group.
 */
public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> result = new HashMap<String, List<String>>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String currentKey = new String(chars);
            if (result.containsKey(currentKey)) {
                result.get(currentKey).add(str);
            } else {
                List<String> list = new ArrayList<String>();
                list.add(str);
                result.put(currentKey, list);
            }
        }
        for (String key : result.keySet()) {
            Collections.sort(result.get(key));
        }
        return new ArrayList<List<String>>(result.values());
    }
}
