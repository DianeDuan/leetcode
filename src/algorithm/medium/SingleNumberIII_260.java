package algorithm.medium;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Problem:
 * https://leetcode.com/problems/single-number-iii/
 * <p/>
 * Analysis:
 */
public class SingleNumberIII_260 {
    //time complexity: O(n), space complexity: O(n)
    public int[] singleNumber_solution1(int[] nums) {
        if (nums == null || nums.length < 2) {
            return new int[0];
        }

        Map<Integer, Integer> numsCount = new HashMap<Integer, Integer>();
        for (int num : nums) {
            if (numsCount.containsKey(num)) {
                int count = numsCount.get(num);
                numsCount.put(num, count + 1);
            } else {
                numsCount.put(num, 1);
            }
        }

        int[] result = new int[2];
        int i = 0;
        Set<Integer> keySet = numsCount.keySet();
        for (int key : keySet) {
            if (numsCount.get(key) == 1) {
                result[i] = key;
                i++;
            }
            if (i >= result.length) {
                break;
            }
        }
        return result;
    }

    //time complexity: O(n), space complexity: O(1)
    public int[] singleNumber_solution2(int[] nums) {
        if (nums == null || nums.length < 2) {
            return new int[0];
        }

        int xorResult = xorAllNumbers(nums);
        int nonZeroBitPosition = Integer.numberOfTrailingZeros(xorResult);
        int[] result = new int[2];
        result[0] = 0;
        result[1] = 0;
        for (int num : nums) {
            if (getBitByPosition(num, nonZeroBitPosition) == 0) {
                result[0] ^= num;
            } else {
                result[1] ^= num;
            }
        }

        return result;
    }

    private int xorAllNumbers(int[] nums) {
        int result = 0;
        if (nums != null) {
            for (int num : nums) {
                result ^= num;
            }
        }
        return result;
    }

    private int getBitByPosition(int num, int position) {
        int tmp = (num >> position);
        return (tmp & 1);
    }
}
