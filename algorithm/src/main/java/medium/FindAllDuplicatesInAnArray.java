package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem:
 * No: 442
 * Link: https://leetcode.com/problems/find-all-duplicates-in-an-array/
 * <p>
 * Analysis:
 * <p>
 * Solution1:
 * This solution's time complexity is O(1) and space complexity is O(n).
 * Scan the array and use an boolean array to record if an integer has appeared.
 * <p>
 * Solution2:
 * This solution's time complexity is O(1) and space complexity is O(1).
 * Unlike solution1, this solution doesn't use extra array to record elements' appearances,
 * it uses the nums array itself to do that,
 * by changing the elements whose indexes are related to the appeared elements to negative numbers.
 * <p>
 * Reference:
 * https://discuss.leetcode.com/topic/64735/java-simple-solution/4
 */
public class FindAllDuplicatesInAnArray {
    public List<Integer> findDuplicatesSolution1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }

        boolean[] used = new boolean[nums.length];
        List<Integer> result = new ArrayList<>();
        for (int num : nums) {
            if (used[num - 1]) {
                result.add(num);
            } else {
                used[num - 1] = true;
            }
        }
        return result;
    }

    public List<Integer> findDuplicatesSolution2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }

        List<Integer> result = new ArrayList<>();
        for (int num : nums) {
            int recordIdx = Math.abs(num) - 1;
            if (nums[recordIdx] < 0) {
                result.add(Math.abs(num));
            } else {
                nums[recordIdx] = -nums[recordIdx];
            }
        }
        return result;
    }
}
