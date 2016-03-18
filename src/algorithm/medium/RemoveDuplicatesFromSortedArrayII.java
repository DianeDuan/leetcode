package algorithm.medium;

/**
 * Problem:
 * No: 80
 * Link: https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/
 * <p/>
 * Analysis:
 * Use a variable to record the duplicate times of current number.
 */
public class RemoveDuplicatesFromSortedArrayII {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int tmpEnd = 0;
        int duplicateTimes = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[tmpEnd]) {
                duplicateTimes++;
                if (duplicateTimes < 2) {
                    tmpEnd++;
                    nums[tmpEnd] = nums[i];
                }
            } else {
                duplicateTimes = 0;
                tmpEnd++;
                nums[tmpEnd] = nums[i];
            }
        }
        return tmpEnd + 1;
    }
}
