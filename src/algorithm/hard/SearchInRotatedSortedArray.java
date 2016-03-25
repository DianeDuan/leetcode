package algorithm.hard;

/**
 * Problem:
 * No: 33
 * Link: https://leetcode.com/problems/search-in-rotated-sorted-array/
 * <p/>
 * Analysis:
 * A variation of common binary search.
 * <p/>
 * Reference:
 * http://bangbingsyb.blogspot.jp/2014/11/leetcode-search-in-rotated-sorted-array.html
 */
public class SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        if (nums == null) {
            return -1;
        }

        return binarySearch(nums, target, 0, nums.length - 1);
    }

    private int binarySearch(int[] nums, int target, int start, int end) {
        if (start > end) {
            return -1;
        }

        int mid = (start + end) / 2;
        if (nums[mid] == target) {
            return mid;
        }

        if (nums[mid] < nums[end]) {//right half is sorted
            if (nums[mid] < target && target <= nums[end]) {
                return binarySearch(nums, target, mid + 1, end);
            } else {
                return binarySearch(nums, target, start, mid - 1);
            }
        } else {//left half is sorted
            if (nums[mid] > target && target >= nums[start]) {
                return binarySearch(nums, target, start, mid - 1);
            } else {
                return binarySearch(nums, target, mid + 1, end);
            }
        }
    }
}
