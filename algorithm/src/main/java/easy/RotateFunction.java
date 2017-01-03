package easy;

/**
 * Problem:
 * No: 396
 * Link: https://leetcode.com/problems/rotate-function/
 * <p>
 * Analysis:
 * Calculate F(0), F(1), ..., F(n-1) and find the max
 */
public class RotateFunction {
    public int maxRotateFunction(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }

        Integer max = Integer.MIN_VALUE;
        for (int start = 0; start < A.length; start++) {
            int current = 0;
            int m = 1;
            for (int i = start + 1; i < A.length; i++, m++) {
                current += m * A[i];
            }
            for (int i = 0; i < start; i++, m++) {
                current += m * A[i];
            }
            max = Math.max(max, current);
        }
        return max;
    }
}
