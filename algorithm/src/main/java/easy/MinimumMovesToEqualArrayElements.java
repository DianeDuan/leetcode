package easy;

/**
 * Problem:
 * No: 453
 * Link: https://leetcode.com/problems/minimum-moves-to-equal-array-elements/
 * <p>
 * Analysis:
 * Find the minimal element, the minimal move count is the sum of the differences of every element and the minimal element
 */
public class MinimumMovesToEqualArrayElements {
    public int minMoves(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int min = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < min) {
                min = nums[i];
            }
        }

        int moveCount = 0;
        for (int num : nums) {
            moveCount += (num - min);
        }
        return moveCount;
    }
}
