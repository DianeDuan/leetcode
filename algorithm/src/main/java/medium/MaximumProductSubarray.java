package medium;

/**
 * Problem:
 * No: 152
 * Link: https://leetcode.com/problems/maximum-product-subarray/
 * <p/>
 * Analysis:
 * In the maximum sum subarray problem,
 * when meet a negative element in the traversal,
 * just set current sum 0,
 * because a negative can only make the subarray sum smaller.
 * But in this problem,
 * when meet a negative element in the traversal,
 * as two negative numbers's product is a positive number,
 * it could be part of the maximum product subarray,
 * so we can't just skip it.
 * So in this problem,
 * two variables are used to record the local maximum and the local minimum respectively.
 * <p/>
 * Reference:
 * http://blog.csdn.net/linhuanmars/article/details/39537283
 */
public class MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int localMax = nums[0];
        int localMin = nums[0];
        int global = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int tmp = localMax;
            localMax = Math.max(Math.max(nums[i], localMax * nums[i]), localMin * nums[i]);
            localMin = Math.min(Math.min(nums[i], tmp * nums[i]), localMin * nums[i]);
            global = Math.max(global, localMax);
        }
        return global;
    }
}
