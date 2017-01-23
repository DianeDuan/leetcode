package medium;

/**
 * Problem:
 * No: 494
 * Link: https://leetcode.com/problems/target-sum/
 * <p>
 * Analysis:
 * Scan the array and try both adding and subtracting current number.
 * Count the combinations recursively.
 */
public class TargetSum {
    public int findTargetSumWays(int[] nums, int S) {
        return countWays(nums, 0, S);
    }

    private int countWays(int[] nums, int currentIdx, int target) {
        if (currentIdx == nums.length) {
            if (target == 0) {
                return 1;
            } else {
                return 0;
            }
        }

        int nextIdx = currentIdx + 1;
        int curNum = nums[currentIdx];
        return countWays(nums, nextIdx, target - curNum) + countWays(nums, nextIdx, target + curNum);
    }
}
