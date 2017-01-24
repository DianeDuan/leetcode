package medium;

import java.util.Random;

/**
 * Problem:
 * No: 384
 * Link: https://leetcode.com/problems/shuffle-an-array/
 * <p>
 * Analysis:
 * Fisher-Yates shuffle algorithm, modern version.
 * <p>
 * Reference:
 * http://stackoverflow.com/questions/1519736/random-shuffling-of-an-array
 * https://en.wikipedia.org/wiki/Fisher%E2%80%93Yates_shuffle?oldformat=true
 */
public class ShuffleAnArray {
    private int[] nums;

    public ShuffleAnArray(int[] nums) {
        this.nums = nums;
    }

    /**
     * Resets the array to its original configuration and return it.
     */
    public int[] reset() {
        return nums;
    }

    /**
     * Returns a random shuffling of the array.
     */
    public int[] shuffle() {
        int length = nums.length;
        int[] result = new int[length];
        System.arraycopy(nums, 0, result, 0, length);
        for (int i = 0; i < length; i++) {
            int p = new Random().nextInt(length - i);
            int tmp = result[p];
            result[p] = result[length - i - 1];
            result[length - i - 1] = tmp;
        }
        return result;
    }
}
