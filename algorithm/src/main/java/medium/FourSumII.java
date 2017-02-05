package medium;

import java.util.HashMap;
import java.util.Map;

/**
 * Problem:
 * No: 454
 * Link: https://leetcode.com/problems/4sum-ii/
 * <p>
 * Analysis:
 * Traverse the four arrays can solve this problem with time complexity O(n^4).
 * Get the sums of all the pairs of A's elements and B's elements
 * to check if the pairs of C's elements and D's elements is one of their opposite numbers.
 * This solution's time complexity is O(n^2).
 */
public class FourSumII {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        if (A == null || A.length == 0 || B == null || B.length == 0
                || C == null || C.length == 0 || D == null || D.length == 0) {
            return 0;
        }

        int result = 0;
        Map<Integer, Integer> targets = new HashMap<>();
        for (int num1 : A) {
            for (int num2 : B) {
                int target = -num1 - num2;
                targets.put(target, targets.getOrDefault(target, 0) + 1);
            }
        }

        for (int num3 : C) {
            for (int num4 : D) {
                result += targets.getOrDefault((num3 + num4), 0);
            }
        }
        return result;
    }
}
