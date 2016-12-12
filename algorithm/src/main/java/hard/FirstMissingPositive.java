package hard;

/**
 * Problem:
 * No: 41
 * Link: https://leetcode.com/problems/first-missing-positive/
 * <p/>
 * Analysis:
 * Swap every positive number k to the (k-1)th position.
 * <p/>
 * Reference:
 * http://www.cnblogs.com/AnnieKim/archive/2013/04/21/3034631.html
 */
public class FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 1;
        }
        int i = 0;
        while (i < nums.length) {
            if (nums[i] >= 1 && nums[i] <= nums.length && nums[i] != (i + 1) && nums[i] != nums[nums[i] - 1]) {
                int tmp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = tmp;
            } else {
                i++;
            }
        }
        for (i = 0; i < nums.length; i++) {
            if (nums[i] != (i + 1)) {
                return (i + 1);
            }
        }
        return nums.length + 1;
    }
}
