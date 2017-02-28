package medium;

import java.util.HashSet;
import java.util.Set;

/**
 * Problem:
 * No: 421
 * Link: https://leetcode.com/problems/maximum-xor-of-two-numbers-in-an-array/
 * <p>
 * Analysis:
 * Scan the numbers from their highest to lowest bits by using mask variable to get prefixes.
 * And as we know that if a ^ max = b, then a ^ b = max,
 * so we can update the max value by checking if a possible max value can be produced from two numbers of the nums array.
 * <p>
 * Reference:
 * http://shirleyisnotageek.blogspot.com/2016/10/maximum-xor-of-two-numbers-in-array.html
 */
public class MaximumXOROfTwoNumbersInAnArray {
    public int findMaximumXOR(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }

        int max = 0, mask = 0;
        for (int i = 31; i >= 0; i--) {
            mask |= 1 << i;
            Set<Integer> prefixes = new HashSet<>();
            for (int num : nums) {
                prefixes.add(mask & num);
            }

            int tmp = max | (1 << i);
            for (int prefix : prefixes) {
                if (prefixes.contains(prefix ^ tmp)) {
                    max = tmp;
                    break;
                }
            }
        }
        return max;
    }
}
