package algorithm.medium;

/**
 * Problem:
 * https://leetcode.com/problems/missing-number/
 *
 * Analysis:
 * The difference between the sum of 1, 2, ..., n and the sum of elements in nums array is that missing number.
 */
public class MissingNumber_268 {
    public int missingNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        int n = nums.length;
        int totalSum = 0;
        for (int i = 1; i<= n; i++) {
            totalSum+=i;
        }

        return (totalSum - sum);
    }
}
