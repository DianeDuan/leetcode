package algorithm.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem:
 * https://leetcode.com/problems/combination-sum-iii/
 * <p/>
 * Analysis:
 * Recursive backtrace solution.
 */
public class CombinationSumIII_216 {
    public List<List<Integer>> combinationSum3(int k, int n) {
        if (k <= 0 || n <= 0 || k > n) {
            return new ArrayList<List<Integer>>();
        }

        return combine(k, n, 1, new ArrayList<Integer>());
    }

    private List<List<Integer>> combine(int k, int target, int start, List<Integer> current) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        int sum = sum(current);
        if ((k == 0) && (sum == target)) {
            result.add(new ArrayList<Integer>(current));
        } else if ((k > 0) && (sum < target)) {
            for (int i = start; i < 10; i++) {
                current.add(i);
                result.addAll(combine(k - 1, target, i + 1, current));
                current.remove(current.size() - 1);
            }
        }
        return result;
    }

    private int sum(List<Integer> list) {
        if (list == null || list.size() == 0) {
            return 0;
        }

        int sum = 0;
        for (int i : list) {
            sum += i;
        }
        return sum;
    }
}
