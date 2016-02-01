package algorithm.easy;

/**
 * Problem:
 * https://leetcode.com/problems/remove-element/
 * <p/>
 * Analysis:
 * Traverse the nums array,
 * when meet an element equals to val,
 * copy the value of last element to this position to replace this element.
 */
public class RemoveElement_27 {
    public int removeElement(int[] nums, int val) {
        if (nums == null) {
            return 0;
        }

        int newLength = nums.length;
        int i = 0;
        while (i < newLength) {
            if (nums[i] == val) {
                nums[i] = nums[newLength - 1];
                newLength--;
            } else {
                i++;
            }
        }
        return newLength;
    }
}
