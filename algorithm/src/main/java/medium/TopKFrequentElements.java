package medium;

import java.util.*;

/**
 * Problem:
 * No: 347
 * Link: https://leetcode.com/problems/top-k-frequent-elements/
 * <p>
 * Analysis:
 */
public class TopKFrequentElements {
    // TODO: 8/2/16  
    public List<Integer> topKFrequent(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<Integer>();
        }


        Map<Integer, Integer> frequency = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            int key = nums[i];
            if (frequency.containsKey(key)) {
                int count = frequency.get(key);
                frequency.put(key, count + 1);
            } else {
                frequency.put(key, 1);
            }
        }

        Set<Integer> result = new HashSet<Integer>();
        int minFrequencyNum = nums[0];
        int minFrequency = frequency.get(nums[0]);
        result.add(nums[0]);
        for (Map.Entry<Integer, Integer> entry : frequency.entrySet()) {
            if (entry.getValue() > minFrequency) {
                result.add(minFrequency);
            } else {
                result.add(minFrequency);
                result.remove(minFrequencyNum);
                minFrequency = entry.getValue();
                minFrequencyNum = entry.getValue();
            }
        }
        return new ArrayList<Integer>(result);
    }
}
