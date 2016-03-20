package algorithm.medium;

/**
 * Problem:
 * No: 55
 * Link: https://leetcode.com/problems/jump-game/
 * <p/>
 * Analysis:
 * Traverse from the penultimate element to the first element.
 * Use a variable to record the least step count you need to reach the next position.
 * At the start the variable is 1, because the goal is to reach the last element and from the penultimate it needs at least 1 step.
 * In the traversal, if current element's value is less than the variable,
 * it means this position cannot be used to reach the last position,
 * so we need to continue to check the previous element and it will need 1 more step than this position.
 */
public class JumpGame {
    public boolean canJump(int[] nums) {
        if (nums == null) {
            return false;
        }

        int step = 1;//the least step count needed to reach the next position
        for (int i = nums.length - 2; i > -1; i--) {
            if (nums[i] < step) {
                step += 1;
            } else {
                step = 1;
            }
        }

        return step == 1;
    }
}
