package algorithm.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Problem:
 * No: 40
 * Link: https://leetcode.com/problems/combination-sum-ii/
 * <p/>
 * Analysis:
 * Before generate combinations, sort the candidates array to make sure the every combination is sorted.
 * Use a visited array to record if the elements is used.
 */
public class CombinationSumII {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0 || target <= 0) {
            return new ArrayList<List<Integer>>();
        }

        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        combine(candidates, new boolean[candidates.length], target, 0, new ArrayList<Integer>(), result);
        return result;
    }

    private void combine(int[] candidates, boolean[] visited, int target, int start, List<Integer> current, List<List<Integer>> result) {
        int sum = sum(current);
        if (sum == target) {
            result.add(new ArrayList<Integer>(current));
        } else if (sum < target) {
            for (int i = start; i < candidates.length; i++) {
                if (!visited[i]) {
                    //avoid duplicate combinations
                    if ((i > 0) && (candidates[i] == candidates[i - 1]) && (!visited[i - 1])) {
                        continue;
                    }

                    current.add(candidates[i]);
                    visited[i] = true;
                    combine(candidates, visited, target, i + 1, current, result);
                    current.remove(current.size() - 1);
                    visited[i] = false;
                }
            }
        }
    }

    private int sum(List<Integer> integers) {
        if (integers == null) {
            return 0;
        }

        int sum = 0;
        for (int i : integers) {
            sum += i;
        }
        return sum;
    }
}
