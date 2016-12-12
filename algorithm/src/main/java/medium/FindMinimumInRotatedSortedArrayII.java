package medium;

/**
 * Problem:
 * No: 154
 * Link: https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/
 * <p/>
 * Analysis:
 * A Common binary search's variation which needs special process for duplicates.
 */
public class FindMinimumInRotatedSortedArrayII {
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        return binarySearch(nums, 0, nums.length - 1);
    }

    private int binarySearch(int[] nums, int start, int end) {
        int mid = (start + end) / 2;
        if (start > end) {
            return nums[mid];
        }

        if (nums[mid] > nums[end]) {
            return binarySearch(nums, mid + 1, end);
        } else if (nums[mid] < nums[end]) {
            return binarySearch(nums, start, mid);
        } else {
            int previous = findPrevious(nums, mid);
            if (previous == -1) {
                int next = findNext(nums, mid);
                if (next == nums.length) {
                    return nums[mid];
                } else if (nums[next] > nums[mid]) {
                    return nums[mid];
                } else {
                    return binarySearch(nums, mid + 1, end);
                }
            } else {
                if (nums[previous] > nums[mid]) {
                    return binarySearch(nums, mid + 1, end);
                } else {
                    return binarySearch(nums, start, previous);
                }
            }
        }
    }

    private int findPrevious(int[] nums, int pos) {
        int result = pos - 1;
        while (result >= 0) {
            if (nums[result] != nums[pos]) {
                break;
            }
            result--;
        }
        return result;
    }

    private int findNext(int[] nums, int pos) {
        int result = pos + 1;
        while (result < nums.length) {
            if (nums[result] != nums[pos]) {
                break;
            }
            result++;
        }
        return result;
    }
}
