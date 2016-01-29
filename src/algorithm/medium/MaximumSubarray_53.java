package algorithm.medium;

/**
 * Problem:
 * https://leetcode.com/problems/maximum-subarray/
 * <p/>
 * Analysis:
 * <p/>
 * Solution1:
 * Traverse the nums array, and keep updating the max with current max.
 * <p/>
 * Solution2:
 * Divide and conquer:
 * the max subarray could be in the left part,
 * could be in the right part,
 * could be across the point divided the array into the left part the the right part.
 * <p/>
 * Reference:
 * http://joycelearning.blogspot.com/2013/10/leetcode-maximum-subarray.html
 */
public class MaximumSubarray_53 {
    //time complexity: O(N)
    public int maxSubArray_solution1(int[] nums) {
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            sum += num;
            max = Math.max(max, sum);
            if (sum < 0) {
                sum = 0;
            }
        }
        return max;
    }

    //time complexity: O(logN)
    public int maxSubArray_solution2(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        return getSubarrayMax(nums, 0, nums.length - 1);
    }

    private int getSubarrayMax(int[] nums, int left, int right) {
        if (left > right) {
            return Integer.MIN_VALUE;
        }
        int mid = (left + right) / 2;
        int leftMax = getSubarrayMax(nums, left, mid - 1);
        int rightMax = getSubarrayMax(nums, mid + 1, right);
        int acrossMax = getAcrossMidMax(left, right, nums);
        return max(leftMax, rightMax, acrossMax);
    }

    private int getAcrossMidMax(int left, int right, int[] nums) {
        int mid = (left + right) / 2;

        int current = 0;
        int leftMax = 0;
        for (int i = (mid - 1); i >= left; i--) {
            current += nums[i];
            leftMax = Math.max(current, leftMax);
        }

        current = 0;
        int rightMax = 0;
        for (int i = (mid + 1); i <= right; i++) {
            current += nums[i];
            rightMax = Math.max(current, rightMax);
        }

        return leftMax + nums[mid] + rightMax;
    }

    private int max(int a, int b, int c) {
        int tmp = Math.max(a, b);
        return Math.max(c, tmp);
    }
}
