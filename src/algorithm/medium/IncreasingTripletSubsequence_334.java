package algorithm.medium;

/**
 * Problem:
 * https://leetcode.com/problems/increasing-triplet-subsequence/
 * <p/>
 * Analysis:
 * Use two auxiliary arrays, leftMin and rightMax.
 * leftMin[i] = minimal value in nums array's elements with index 0, 1, ..., i-1
 * rightMax[i] = maximal value in nums array's elements with index i+1, i+2, ..., n-1
 * Traverse the nums array,
 * judge if current element is the middle element of the increasing triplet,
 * the subsequence can exist.
 * <p/>
 * Reference:
 * http://algorithms.tutorialhorizon.com/find-increasing-triplet-sub-sequence/
 */
public class IncreasingTripletSubsequence_334 {
    public boolean increasingTriplet(int[] nums) {
        if (nums == null || nums.length < 2) {
            return false;
        }

        int[] leftMin = new int[nums.length];
        leftMin[0] = Integer.MAX_VALUE;
        int[] rightMax = new int[nums.length];
        rightMax[nums.length - 1] = Integer.MIN_VALUE;

        for (int i = 1; i < nums.length; i++) {
            leftMin[i] = Math.min(leftMin[i - 1], nums[i - 1]);
        }

        for (int i = nums.length - 2; i > -1; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], nums[i + 1]);
        }

        for (int i = 0; i < nums.length; i++) {
            if ((leftMin[i] < nums[i]) && (nums[i] < rightMax[i])) {
                return true;
            }
        }
        return false;
    }
}
