package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Problem:
 * No: 90
 * Link: https://leetcode.com/problems/subsets-ii/
 * <p/>
 * Analysis:
 * Skipping duplicates if it's not the start to avoid duplicate subsets.
 */
public class SubsetsII {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
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
                if (i > start && nums[i - 1] == nums[i]) {
                    continue;
                }
                current.add(nums[i]);
                result.addAll(getSubsets(nums, subsetSize, i + 1, current));
                current.remove(current.size() - 1);
            }
        }
        return result;
    }
}
