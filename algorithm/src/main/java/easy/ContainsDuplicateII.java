package easy;

import java.util.HashMap;
import java.util.Map;

/**
 * Problem:
 * No: 219
 * Link: https://leetcode.com/problems/contains-duplicate-ii/
 * <p/>
 * Analysis:
 * Traverse the array and use a map to record the number and its' index.
 * Before put the number and its index into the map,
 * check if current number is already in the map,
 * if not, put the number and its index into the map and continue,
 * if so, check if the distance between this pair of duplicate numbers is no greater than k,
 * if this condition is satisfied,
 * that means the array contains nearby duplicates,
 * if this condition isn't satisfied,
 * update this duplicate number's position by the index of current number into the map,
 * so that we can always get the shortest distance of duplicates,
 * and continue to traverse the array.
 */
public class ContainsDuplicateII {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums == null || k <= 0) {
            return false;
        }

        Map<Integer, Integer> numNewestPosition = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (!numNewestPosition.containsKey(nums[i])) {
                numNewestPosition.put(nums[i], i);
            } else {
                int distance = i - numNewestPosition.get(nums[i]);
                if (distance <= k) {
                    return true;
                } else {
                    numNewestPosition.put(nums[i], i);
                }
            }
        }

        return false;
    }
}
