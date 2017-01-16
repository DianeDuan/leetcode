package easy;

/**
 * Problem:
 * No: 485
 * Link: https://leetcode.com/problems/max-consecutive-ones/
 * <p>
 * Analysis:
 * Use one variable to record max length,
 * and use another variable to record current consecutive 1s length.
 */
public class MaxConsecutiveOnes {
    public int findMaxConsecutiveOnes(int[] nums) {
        if (nums == null) {
            return 0;
        }

        int max = 0;
        int current = 0;
        for (int num : nums) {
            if (num == 0) {
                max = Math.max(current, max);
                current = 0;
            } else {
                current++;
            }
        }
        max = Math.max(current, max);
        return max;
    }
}
