package medium;

/**
 * Problem:
 * No: 81
 * Link: https://leetcode.com/problems/search-in-rotated-sorted-array-ii/
 * <p/>
 * Analysis:
 * Need to process the duplicates.
 * <p/>
 * Reference:
 * http://bangbingsyb.blogspot.jp/2014/11/leetcode-search-in-rotated-sorted-array.html
 */
public class SearchInRotatedSortedArrayII {
    public boolean search(int[] nums, int target) {
        if (nums == null) {
            return false;
        }

        int start = 0, end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return true;
            }

            if (nums[mid] < nums[end]) {// right half sorted
                if (target > nums[mid] && target <= nums[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            } else if (nums[mid] > nums[end]) {// left half sorted
                if (target >= nums[start] && target < nums[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                end--;
            }
        }
        return false;
    }
}
