package algorithm.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Problem:
 * No: 47
 * Link: https://leetcode.com/problems/permutations-ii/
 * <p/>
 * Analysis:
 * Similar to the "Permutations" problem,
 * but need to avoid duplicate permutations in generation process.
 */
public class PermutationsII {
    public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<List<Integer>>();
        }

        Arrays.sort(nums);
        return recursivelyPermute(nums, new boolean[nums.length], new ArrayList<Integer>());
    }

    private List<List<Integer>> recursivelyPermute(int[] nums, boolean[] visited, List<Integer> current) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (current.size() == nums.length) {
            result.add(new ArrayList<Integer>(current));
            return result;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                if (i != 0 && nums[i - 1] == nums[i] && visited[i - 1]) {//avoid duplicate permutations
                    continue;
                }
                current.add(nums[i]);
                visited[i] = true;
                result.addAll(recursivelyPermute(nums, visited, current));
                current.remove(current.size() - 1);
                visited[i] = false;
            }
        }
        return result;
    }
}
