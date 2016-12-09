package algorithm.medium;

import java.util.Arrays;

/**
 * Problem:
 * No: 215
 * Link: https://leetcode.com/problems/kth-largest-element-in-an-array/
 * <p/>
 * Analysis:
 * <p/>
 * Solution1:
 * Sort the whole array and return the kth largest by using index.
 * <p/>
 * Solution2:
 * Quick Select Algorithm
 * <p/>
 * Reference:
 * https://en.wikipedia.org/wiki/Quickselect?oldformat=true
 */
public class KthLargestElementInAnArray {
    public int findKthLargestSolution1(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    public int findKthLargestSolution2(int[] nums, int k) {
        return nums[quickSelect(nums, 0, nums.length - 1, k - 1)];
    }

    private int quickSelect(int[] nums, int start, int end, int target) {
        if (start > end) {
            return -1;
        }

        int pivot = nums[end];
        int left = start;
        for (int i = start; i <= end; i++) {
            if (nums[i] > pivot) {
                swap(nums, left, i);
                left++;
            }
        }
        swap(nums, left, end);

        if (left == target) {
            return left;
        } else if (left > target) {
            return quickSelect(nums, start, left - 1, target);
        } else {
            return quickSelect(nums, left + 1, end, target);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
