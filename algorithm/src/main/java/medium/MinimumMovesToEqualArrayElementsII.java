package medium;

import java.util.Arrays;

/**
 * Problem:
 * No: 462
 * Link: https://leetcode.com/problems/minimum-moves-to-equal-array-elements-ii/
 * <p>
 * Analysis:
 * The minimal move count is when every is changed to the median
 */
public class MinimumMovesToEqualArrayElementsII {
    public int minMoves2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        Arrays.sort(nums);
        int average = nums[nums.length / 2];
        int result = 0;
        for (int num : nums) {
            result += Math.abs(average - num);
        }
        return result;
    }
}
