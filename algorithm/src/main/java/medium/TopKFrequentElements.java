package medium;

import java.util.*;

/**
 * Problem:
 * No: 347
 * Link: https://leetcode.com/problems/top-k-frequent-elements/
 * <p>
 * Analysis:
 * First mapping the numbers to its frequencies.
 * And then use a min heap to find the top k frequent elements.
 * <p>
 * Reference:
 * http://www.programcreek.com/2014/05/leetcode-top-k-frequent-elements-java/
 */
public class TopKFrequentElements {
    public List<Integer> topKFrequent(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }

        Map<Integer, Integer> frequency = new HashMap<>();
        for (int key : nums) {
            if (frequency.containsKey(key)) {
                int count = frequency.get(key);
                frequency.put(key, count + 1);
            } else {
                frequency.put(key, 1);
            }
        }

        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>(new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o1.getValue() - o2.getValue();
            }
        });

        for (Map.Entry<Integer, Integer> entry : frequency.entrySet()) {
            minHeap.add(entry);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        List<Integer> result = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : minHeap) {
            result.add(entry.getKey());
        }
        return result;
    }
}
