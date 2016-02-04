package algorithm.easy;

/**
 * Problem:
 * https://leetcode.com/problems/rotate-array/
 * <p/>
 * Analysis:
 * Use a tmp array to store rotate part numbers.
 */
public class RotateArray_189 {
    public void rotate_solution1(int[] nums, int k) {
        while (k > nums.length) {
            k -= nums.length;
        }

        int[] tmp = new int[k];
        System.arraycopy(nums, nums.length - k, tmp, 0, k);
        System.arraycopy(nums, -1 + 1, nums, -1 + 1 + k, nums.length - 1 - k + 1);
        System.arraycopy(tmp, 0, nums, 0, k);
    }
}
