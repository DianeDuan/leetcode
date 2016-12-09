package algorithm.medium;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Problem:
 * No: 137
 * Link: https://leetcode.com/problems/single-number-ii/
 * <p/>
 * Analysis:
 * <p/>
 * Solution1:
 * Use a map to record the occurrence times of every number.
 * Then traverse the whole map to find which number doesn't occur three times.
 * <p/>
 * Solution2:
 * If all of the other numbers in the array occur k times,
 * and only one number occurs once,
 * we can calculate the sum of the first bits of these numbers,
 * the sum of the second bits of these numbers, and so on,
 * until the sum of the thirty-second bits of these numbers,
 * and store these sums into an array named bitSums.
 * As a bit can be only 1 or 0, There is:
 * bitSums[i] = kt + singleNumberBit, i>=0 && i<=31,
 * t is the count of numbers whose this bit is 1,
 * singleNumberBit is the bit of that single number in this bit position.
 * So we can get every bit of the single by dividing every element of bitSums by k.
 * And get the single number by change these bits into a integer.
 */
public class SingleNumberII {
    //time complexity: O(n), space complexity: O(n)
    public int singleNumberSolution1(int[] nums) {
        if (nums == null) {
            return 0;
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

        Set<Integer> keySet = numsCount.keySet();
        for (int key : keySet) {
            if (numsCount.get(key) != 3) {
                return key;
            }
        }

        return 0;
    }

    //time complexity: O(n), space complexity: O(1)
    public int singleNumberSolution2(int[] nums) {
        if (nums == null) {
            return 0;
        }

        int intBitCount = 32;
        int[] bitSums = new int[intBitCount];
        for (int num : nums) {
            for (int i = 0; i < intBitCount; i++) {
                bitSums[i] += ((num >> i) & 1);
            }
        }

        int result = 0;
        for (int i = 0; i < intBitCount; i++) {
            int tmp = (bitSums[i] % 3) << i;
            result += tmp;
        }
        return result;
    }
}
