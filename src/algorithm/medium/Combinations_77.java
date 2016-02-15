package algorithm.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem:
 * https://leetcode.com/problems/combinations/
 * <p/>
 * Analysis:
 * Recursive backtrace solution.
 * Use a parameter, which is called start here,
 * to record which number is the start position to avoid duplicate combinations.
 */
public class Combinations_77 {
    public List<List<Integer>> combine(int n, int k) {
        if (n <= 0 || k <= 0 || n < k) {
            return new ArrayList<List<Integer>>();
        }

        return generate(n, k, 1, new ArrayList<Integer>());
    }

    private List<List<Integer>> generate(int n, int count, int start, List<Integer> current) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (count == 0) {
            result.add(new ArrayList<Integer>(current));
        } else {
            for (int i = start; i <= n; i++) {
                current.add(i);
                result.addAll(generate(n, count - 1, i + 1, current));
                current.remove(current.size() - 1);
            }
        }
        return result;
    }
}
