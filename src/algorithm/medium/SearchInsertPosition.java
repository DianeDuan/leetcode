package algorithm.medium;

/**
 * Problem:
 * No: 35
 * Link: https://leetcode.com/problems/search-insert-position/
 * <p/>
 * Analysis:
 * <p/>
 * Solution1:
 * Traverse the array.
 * <p/>
 * Solution2:
 * A variation of binary search.
 */
public class SearchInsertPosition {
    //time complexity: O(N)
    public int searchInsert_solution1(int[] nums, int target) {
        if (nums == null) {
            return 0;
        }
        for (int i = 0; i < nums.length; i++) {
            if (target <= nums[i]) {
                return i;
            }
        }
        return nums.length;
    }

    //time complexity: O(logN)
    public int searchInsert_solution2(int[] nums, int target) {
        if (nums == null) {
            return 0;
        }
        return binarySearch(nums, 0, nums.length - 1, target);
    }

    private int binarySearch(int[] nums, int start, int end, int target) {
        if (end < start) {
            return start;
        }
        int mid = (start + end) / 2;
        if (target == nums[mid] || ((mid > start) && (target > nums[mid - 1]) && (target < nums[mid]))) {
            return mid;
        } else if (target > nums[mid]) {
            return binarySearch(nums, mid + 1, end, target);
        } else {
            return binarySearch(nums, start, mid - 1, target);
        }
    }
}
