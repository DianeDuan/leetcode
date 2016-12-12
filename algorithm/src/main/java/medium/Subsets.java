package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Problem:
 * No: 78
 * Link: https://leetcode.com/problems/subsets/
 * <p/>
 * Analysis:
 * Get combinations of sizes which are from 0 to array's length.
 * Sort the array before get combinations to make sure that elements in a subset are in non-descending order.
 */
public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<List<Integer>>();
        }

        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for (int i = 0; i <= nums.length; i++) {
            result.addAll(getSubsets(nums, i, 0, new ArrayList<Integer>()));
        }
        return result;
    }

    private List<List<Integer>> getSubsets(int[] nums, int subsetSize, int start, List<Integer> current) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (current.size() == subsetSize) {
            result.add(new ArrayList<Integer>(current));
        } else {
            for (int i = start; i < nums.length; i++) {
                current.add(nums[i]);
                result.addAll(getSubsets(nums, subsetSize, i + 1, current));
                current.remove(current.size() - 1);
            }
        }
        return result;
    }
}
