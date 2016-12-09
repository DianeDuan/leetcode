package algorithm.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Problem:
 * No: 39
 * Link: https://leetcode.com/problems/combination-sum/
 * <p/>
 * Analysis:
 * Recursive solution.
 * <p/>
 * Reference:
 * http://www.cnblogs.com/springfor/p/3884294.html
 */
public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0 || target <= 0) {
            return new ArrayList<List<Integer>>();
        }

        candidates = removeDuplicates(candidates);
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        combine(candidates, target, 0, new ArrayList<Integer>(), result);
        return result;
    }

    private int[] removeDuplicates(int[] array) {
        if (array == null || array.length == 0) {
            return new int[0];
        }

        List<Integer> tmp = new ArrayList<Integer>();
        for (int element : array) {
            if (!tmp.contains(element)) {
                tmp.add(element);
            }
        }

        int[] result = new int[tmp.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = tmp.get(i);
        }
        return result;
    }

    private void combine(int[] candidates, int target, int start, List<Integer> current, List<List<Integer>> result) {
        int sum = sum(current);
        if (sum == target) {
            result.add(new ArrayList<Integer>(current));
        } else if (sum < target) {
            for (int i = start; i < candidates.length; i++) {
                current.add(candidates[i]);
                combine(candidates, target, i, current, result);
                current.remove(current.size() - 1);
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
