package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem:
 * No: 46
 * Link: https://leetcode.com/problems/permutations/
 * <p/>
 * Analysis:
 * Use a visited array to record if the number is used in current permutation.
 * <p/>
 * Reference:
 * http://www.cnblogs.com/springfor/p/3888044.html
 */
public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<List<Integer>>();
        }

        return recursivelyPermute(nums, new boolean[nums.length], new ArrayList<Integer>());
    }

    private List<List<Integer>> recursivelyPermute(int[] nums, boolean[] visited, List<Integer> current) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (current.size() == nums.length) {
            result.add(new ArrayList<Integer>(current));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (!visited[i]) {
                    current.add(nums[i]);
                    visited[i] = true;
                    result.addAll(recursivelyPermute(nums, visited, current));
                    current.remove(current.size() - 1);
                    visited[i] = false;
                }
            }
        }
        return result;
    }
}
