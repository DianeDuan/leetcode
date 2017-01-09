package medium;

import java.util.*;

/**
 * Problem:
 * No: 451
 * Link: https://leetcode.com/problems/sort-characters-by-frequency/
 * <p>
 * Analysis:
 * Scan the string and record its characters and their counts in a Map.
 * Sort the counts.
 * Scan the sorted counts and add corresponding characters into a result string.
 */
public class SortCharactersByFrequency {
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            Integer count = map.get(c);
            if (count != null) {
                map.put(c, count + 1);
            } else {
                map.put(c, 1);
            }
        }

        List<Integer> counts = new ArrayList<>();
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            counts.add(entry.getValue());
        }
        Collections.sort(counts, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (o1 > o2) {
                    return -1;
                } else if (o1 < o2) {
                    return 1;
                } else {
                    return 0;
                }
            }
        });

        StringBuilder sb = new StringBuilder();
        for (int count : counts) {
            for (Map.Entry<Character, Integer> entry : map.entrySet()) {
                if (entry.getValue() == count) {
                    sb.append(repeat(entry.getKey(), count));
                    map.remove(entry.getKey());
                    break;
                }
            }
        }
        return sb.toString();
    }

    private String repeat(char c, int count) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            sb.append(c);
        }
        return sb.toString();
    }
}
