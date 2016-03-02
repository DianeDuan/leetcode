package algorithm.hard;

/**
 * Problem:
 * https://leetcode.com/problems/burst-balloons/
 * <p/>
 * Analysis:
 * Dynamic programming solution.
 * dp[i][j] is the maximum coins you can get when all the balloons between i and j are burst(not include the ith balloon and the jth balloon).
 * dp[i][j] is the maximum of (dp[i][lastBurstPos] + dp[lastBurstPos][j] + nums[i + 1] * nums[lastBurstPos] * nums[j - 1], lastBurstPos = i+1, i+2, ... j-1).
 * <p/>
 * Reference:
 * https://leetcode.com/discuss/72216/share-some-analysis-and-explanations
 * http://www.69900.com.cn/aliceyangxi1987/article/details/50268065
 */
public class BurstBalloons_312 {
    public int maxCoins(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int dummyLength = nums.length + 2;
        int[] dummyNums = new int[dummyLength];
        dummyNums[0] = 1;//nums[-1] = 1
        dummyNums[dummyLength - 1] = 1;//nums[n] = 1
        System.arraycopy(nums, 0, dummyNums, 1, nums.length);

        int[][] dp = new int[dummyLength][dummyLength];
        for (int currentLength = 2; currentLength < dummyLength; currentLength++) {
            for (int left = 0; left < dummyLength - currentLength; left++) {
                int right = left + currentLength;
                for (int lastBurstPos = left + 1; lastBurstPos < right; lastBurstPos++) {
                    //If all of the balloons between left and right is burst and the index of the last burst one is lastBurstPos,
                    //it divides the balloons into two parts, from left to lastBurstPos and from lastBurstPos to right,
                    //and the count of coins from the last balloon's burst is (dummyNums[left] * dummyNums[lastBurstPos] * dummyNums[right]),
                    //because when the last balloon is burst, its' left neighbor and right neighbor is dummyNums[left] and dummyNums[right].
                    dp[left][right] = Math.max(dp[left][right], dp[left][lastBurstPos] + dp[lastBurstPos][right] + dummyNums[left] * dummyNums[lastBurstPos] * dummyNums[right]);
                }
            }
        }
        return dp[0][dummyLength - 1];
    }
}
