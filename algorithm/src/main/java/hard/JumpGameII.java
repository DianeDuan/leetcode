package hard;

/**
 * Problem:
 * No: 45
 * Link: https://leetcode.com/problems/jump-game-ii/
 * <p/>
 * Analysis:
 * Use a variable, nextEnd, to record the furthest position can be reached before current position.
 * <p/>
 * Reference:
 * http://www.acmerblog.com/leetcode-solution-jump-game-ii-6229.html
 */
public class JumpGameII {
    public int jump(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int lastEnd = 0;
        int minJump = 0;
        int nextEnd = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (i > lastEnd) {
                minJump++;
                lastEnd = nextEnd;
                nextEnd = 0;
            }
            nextEnd = Math.max(nextEnd, nums[i] + i);
        }
        return minJump;
    }
}
