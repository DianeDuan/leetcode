package algorithm.easy;

/**
 * Problem:
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array/
 * <p/>
 * Analysis:
 * Use two pointers.
 * One is for the end of current array which doesn't have duplicates,
 * and the front part of nums array's space is used by current array.
 * The other is for traverse the nums array to find non-duplicate elements.
 */
public class RemoveDuplicatesFromSortedArray_26 {
    public int removeDuplicates(int[] nums) {
        if (nums == null) {
            return -1;
        }
        int end = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[end]) {
                nums[end + 1] = nums[i];
                end++;
            }
        }
        return (end + 1);
    }
}
