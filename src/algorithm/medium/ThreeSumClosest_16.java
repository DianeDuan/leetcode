package algorithm.medium;

import java.util.Arrays;

/**
 * Problem:
 * https://leetcode.com/problems/3sum-closest/
 * <p/>
 * Analysis:
 * Use two pointers to find the second and the third number.
 */
public class ThreeSumClosest_16 {
    public int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length < 3) {
            return 0;
        }

        Arrays.sort(nums);
        int minDiff = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                int diff = nums[i] + nums[left] + nums[right] - target;
                if (Math.abs(diff) < Math.abs(minDiff)) {
                    minDiff = diff;
                }
                if (diff == 0) {
                    break;
                } else if (diff < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return target + minDiff;
    }
}
