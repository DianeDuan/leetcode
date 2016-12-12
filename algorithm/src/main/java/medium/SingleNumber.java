package medium;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Problem:
 * No: 136
 * Link: https://leetcode.com/problems/single-number/
 * <p/>
 * Analysis:
 * <p/>
 * Solution1:
 * Use a map to record the occurrence times of every number.
 * As except target number, other numbers repeat twice in the array,
 * use boolean type, instead of integer type, to record if a number is target number is enough.
 * <p/>
 * Solution2:
 * There are several equations of xor operation:
 * a xor a = 0
 * 0 xor 0 = 0
 * 0 xor a = a
 * As except target number, other numbers repeat twice in the array,
 * There's another equation:
 * nums[0] xor nums[1] xor ... xor nums[nums.length-1] = 0 xor 0 xor ... xor singleNumber = singleNumber
 */
public class SingleNumber {
    //time complexity: O(n), space complexity: O(n)
    public int singleNumberSolution1(int[] nums) {
        if (nums == null) {
            return 0;
        }

        Map<Integer, Boolean> tmp = new HashMap<Integer, Boolean>();
        for (int num : nums) {
            if (tmp.containsKey(num)) {
                tmp.put(num, true);
            } else {
                tmp.put(num, false);
            }
        }

        Set<Integer> keySet = tmp.keySet();
        for (int current : keySet) {
            if (!tmp.get(current)) {
                return current;
            }
        }
        return 0;
    }

    //time complexity: O(n), space complexity: O(1)
    public int singleNumberSolution2(int[] nums) {
        if (nums == null) {
            return 0;
        }
        int singleNumber = 0;
        for (int num : nums) {
            singleNumber ^= num;
        }
        return singleNumber;
    }
}