package medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Problem:
 * No: 187
 * Link: https://leetcode.com/problems/repeated-dna-sequences/
 * <p/>
 * Analysis:
 * Use a map to record previous ten-letters substrings.
 * <p/>
 * Reference:
 * https://segmentfault.com/a/1190000003922976
 */
public class RepeatedDNASequences {
    public List<String> findRepeatedDnaSequences(String s) {
        if (s == null || s.length() < 10) {
            return new ArrayList<String>();
        }

        List<String> result = new ArrayList<String>();
        Map<String, Integer> map = new HashMap<String, Integer>();
        for (int i = 0; i < (s.length() - 9); i++) {
            String current = s.substring(i, i + 10);
            if (map.containsKey(current)) {
                if (map.get(current) == 1) {
                    result.add(current);
                }
                map.put(current, map.get(current) + 1);
            } else {
                map.put(current, 1);
            }
        }
        return result;
    }
}
