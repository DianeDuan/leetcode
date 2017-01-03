package easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Problem:
 * No: 414
 * Link: https://leetcode.com/problems/third-maximum-number/
 * <p>
 * Analysis:
 * Use three variables to record the maximal three numbers.
 */
public class ThirdMaximumNumber {
    public int thirdMax(int[] nums) {
        if (nums == null) {
            return -1;
        }
        List<Integer> nonRepeatNums = getUniqueNums(nums);
        if (nonRepeatNums.size() == 0) {
            return -1;
        }
        if (nonRepeatNums.size() < 3) {
            return max(nonRepeatNums, 0, nonRepeatNums.size());
        }

        int[] max = new int[]{nonRepeatNums.get(0), nonRepeatNums.get(1), nonRepeatNums.get(2)};
        Arrays.sort(max);
        int tmp = max[0];
        max[0] = max[2];
        max[2] = tmp;

        for (int i = 3; i < nonRepeatNums.size(); i++) {
            if (nonRepeatNums.get(i) >= max[0]) {
                max[2] = max[1];
                max[1] = max[0];
                max[0] = nonRepeatNums.get(i);
            } else if (nonRepeatNums.get(i) >= max[1]) {
                max[2] = max[1];
                max[1] = nonRepeatNums.get(i);
            } else if (nonRepeatNums.get(i) >= max[2]) {
                max[2] = nonRepeatNums.get(i);
            }
        }

        return max[2];
    }

    private List<Integer> getUniqueNums(int[] nums) {
        List<Integer> result = new ArrayList<>();
        for (int num : nums) {
            if (!result.contains(num)) {
                result.add(num);
            }
        }
        return result;
    }

    private int max(List<Integer> nums, int start, int end) {
        int max = nums.get(start);
        for (int i = start + 1; i < end; i++) {
            max = Math.max(max, nums.get(i));
        }
        return max;
    }
}
