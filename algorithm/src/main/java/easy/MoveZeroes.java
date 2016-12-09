package algorithm.easy;

/**
 * Problem:
 * No: 283
 * Link: https://leetcode.com/problems/move-zeroes/
 * <p/>
 * Analysis:
 * The solution to this problem seems kind of like bubble sort.
 * In the bubble sort of getting a descending array,
 * swap two elements when the one with bigger index is less,
 * and in this problem,
 * swap two elements when the one with smaller index is zero and the one with bigger index is not zero.
 */
public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        if (nums == null) {
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                for (int j = (i + 1); j < nums.length; j++) {
                    if (nums[j] != 0) {
                        swap(nums, i, j);
                        break;
                    }
                }
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        if (nums != null && i < nums.length && j < nums.length) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
    }
}
