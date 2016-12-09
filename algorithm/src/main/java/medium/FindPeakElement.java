package algorithm.medium;

/**
 * Problem:
 * No: 162
 * Link: https://leetcode.com/problems/find-peak-element/
 * <p/>
 * Analysis:
 * Binary search to find the peak element.
 */
public class FindPeakElement {
    public int findPeakElement(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int start = 0;
        int end = nums.length - 1;
        int mid = 0;
        while (start <= end) {
            mid = start + (end - start) / 2;
            if ((mid == 0 || nums[mid] >= nums[mid - 1]) &&
                    (mid == nums.length - 1 || nums[mid] >= nums[mid + 1])) {
                return mid;
            } else if (mid > 0 && nums[mid - 1] > nums[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return mid;
    }
}
