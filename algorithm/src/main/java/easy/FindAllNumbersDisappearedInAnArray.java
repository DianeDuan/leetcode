package easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem:
 * No: 448
 * Link: https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/
 * <p>
 * Analysis:
 * Scan the array and mark the number appeared in the original array
 * by changing the number in the corresponding position to a negative value.
 * Then scan the number array again to find the disappeared numbers
 * which are not marked.
 */
public class FindAllNumbersDisappearedInAnArray {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int markIdx = Math.abs(nums[i]) - 1;
            if (nums[markIdx] > 0) {
                nums[markIdx] = -nums[markIdx];
            }
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                result.add(i + 1);
            }
        }
        return result;
    }
}
