package easy;

/**
 * Problem:
 * No: 198
 * Link: https://leetcode.com/problems/house-robber/
 * <p/>
 * Analysis:
 * A dynamic programming problem,
 * use a dp array to record the maximum amount of money you can rob when you reach the (i+1) house.
 */
public class HouseRobber {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        if (nums.length == 1) {
            return nums[0];
        }

        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], (nums[i] + dp[i - 2]));
        }
        return dp[nums.length - 1];
    }
}
