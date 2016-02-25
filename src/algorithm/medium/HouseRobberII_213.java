package algorithm.medium;

/**
 * Problem:
 * https://leetcode.com/problems/house-robber-ii/
 * <p/>
 * Analysis:
 * The first house and the last house,
 * we can rob one of them at most.
 * So choose the greater one from not robbing the first house and not robbing the last house.
 */
public class HouseRobberII_213 {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }

        //don't rob the first house
        int[] dp1 = new int[nums.length];
        dp1[1] = nums[1];
        for (int i = 2; i < nums.length; i++) {
            dp1[i] = Math.max(dp1[i - 1], dp1[i - 2] + nums[i]);
        }
        //don't rob the last house
        int[] dp2 = new int[nums.length];
        dp2[0] = nums[0];
        dp2[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < (nums.length - 1); i++) {
            dp2[i] = Math.max(dp2[i - 1], dp2[i - 2] + nums[i]);
        }
        return Math.max(arrayMax(dp1), arrayMax(dp2));
    }

    private int arrayMax(int[] array) {
        if (array == null) {
            return 0;
        }

        int max = Integer.MIN_VALUE;
        for (int i : array) {
            max = Math.max(max, i);
        }
        return max;
    }
}
