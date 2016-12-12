package medium;

/**
 * Problem:
 * No: 153
 * Link: https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
 * <p/>
 * Analysis:
 * Binary search.
 */
public class FindMinimumInRotatedSortedArray {
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        return binarySearch(nums, 0, nums.length - 1);
    }

    private int binarySearch(int[] nums, int start, int end) {
        if (start > end) {
            return nums[(start + end) / 2];
        }

        int mid = (start + end) / 2;
        if (nums[mid] >= nums[end]) {
            return binarySearch(nums, mid + 1, end);
        } else {
            return binarySearch(nums, start, mid);
        }
    }
}
