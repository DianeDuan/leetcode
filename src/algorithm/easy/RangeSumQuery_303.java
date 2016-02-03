package algorithm.easy;

/**
 * Problem:
 * https://leetcode.com/problems/range-sum-query-immutable/
 * <p/>
 * Analysis:
 * Use sums array to record the sums to speed up sumRange method.
 * sums[i] = sumRange(0, i - 1), i >=1 && i <= nums.length
 */
public class RangeSumQuery_303 {
    private int[] sums;

    public RangeSumQuery_303(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        sums = new int[nums.length + 1];
        sums[0] = 0;
        for (int i = 0; i < nums.length; i++) {
            sums[i + 1] = sums[i] + nums[i];
        }
    }

    public int sumRange(int i, int j) {
        if (sums == null || i < 0 || j >= sums.length) {
            return 0;
        }
        return (sums[j + 1] - sums[i]);
    }
}
