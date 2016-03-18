package algorithm.medium;

/**
 * Problem:
 * No: 75
 * Link: https://leetcode.com/problems/sort-colors/
 * <p/>
 * Analysis:
 * <p/>
 * Solution1:
 * Traverse the array to get the counts of red, white and blue objects.
 * Traverse the array to assign elements according to the counts.
 * <p/>
 * Solution2:
 * Traverse the array, swap 0 to the head part of array and swap 2 to the tail part of array.
 * <p/>
 * Reference:
 * http://bangbingsyb.blogspot.jp/2014/11/leetcode-sort-colors.html
 */
public class SortColors {
    public void sortColors_solution1(int[] nums) {
        if (nums == null) {
            return;
        }

        int redCount = 0;
        int whiteCount = 0;
        for (int num : nums) {
            if (num == 0) {
                redCount++;
            } else if (num == 1) {
                whiteCount++;
            }
        }
        int blueCount = nums.length - redCount - whiteCount;

        int i = 0;
        while (i < redCount) {
            nums[i] = 0;
            i++;
        }
        while (i < (redCount + whiteCount)) {
            nums[i] = 1;
            i++;
        }
        while (i < nums.length) {
            nums[i] = 2;
            i++;
        }
    }

    public void sortColors_solution2(int[] nums) {
        if (nums == null) {
            return;
        }

        int redCount = 0;
        int blueCount = 0;
        int i = 0;
        while (i < (nums.length - blueCount)) {
            if (nums[i] == 0) {
                nums[i] = nums[redCount];
                nums[redCount] = 0;
                redCount++;
                i++;
            } else if (nums[i] == 2) {
                nums[i] = nums[nums.length - blueCount - 1];
                nums[nums.length - blueCount - 1] = 2;
                blueCount++;
            } else {
                i++;
            }
        }
    }
}
