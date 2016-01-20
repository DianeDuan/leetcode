package algorithm.medium;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Problem:
 * https://leetcode.com/problems/single-number-iii/
 * <p/>
 * Analysis:
 *
 * Solution1:
 * Use a map to record the occurrence times of every number.
 * Then traverse the whole map to find the numbers that occur only once.
 *
 * Solution2:
 * The result of xor all the numbers equals to the result of xor the two numbers that occur only once.
 * As the two numbers is different, at least one of the result's bits is not zero.
 * Find one of the nonzero bit position,
 * and divide the nums array into two parts by if the element's bit on that position is 0 or 1.
 * The two single numbers will also be divided into those two part, respectively.
 * After the partition, this problem change to finding a single number from each of the two parts,
 * and it's equal to the "No.136: Single Number" problem.
 * In the "No.136: Single Number" problem, xor all the numbers will get the single number.
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
