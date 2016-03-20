package algorithm.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem:
 * No: 228
 * Link: https://leetcode.com/problems/summary-ranges/
 * <p/>
 * Analysis:
 * Traverse the array and record successive numbers' start values and end values.
 */
public class SummaryRanges {
    public List<String> summaryRanges(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<String>();
        }

        List<String> result = new ArrayList<String>();
        int start = nums[0], end = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == (nums[i - 1] + 1)) {
                end = nums[i];
            } else {
                result.add(generateStr(start, end));
                start = nums[i];
                end = nums[i];
            }
        }
        if (end == nums[nums.length - 1]) {
            result.add(generateStr(start, end));
        }
        return result;
    }

    private String generateStr(int start, int end) {
        String str;
        if (start != end) {
            str = start + "->" + end;
        } else {
            str = String.valueOf(start);
        }
        return str;
    }
}
