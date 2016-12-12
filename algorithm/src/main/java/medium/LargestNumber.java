package medium;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Problem:
 * No: 179
 * Link: https://leetcode.com/problems/largest-number/
 * <p/>
 * Analysis:
 * Sort first, and then append the sorted array to a string.
 */
public class LargestNumber {
    public String largestNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return "";
        }

        Integer[] wrappedNums = initWrappedInts(nums);
        Arrays.sort(wrappedNums, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                String num1Str = String.valueOf(o1);
                String num2Str = String.valueOf(o2);
                String catStr1 = num1Str + num2Str;
                String catStr2 = num2Str + num1Str;
                for (int i = 0; i < catStr1.length(); i++) {
                    if (catStr1.charAt(i) > catStr2.charAt(i)) {
                        return -1;
                    } else if (catStr1.charAt(i) < catStr2.charAt(i)) {
                        return 1;
                    }
                }
                return 0;
            }

            @Override
            public boolean equals(Object obj) {
                return false;
            }
        });

        if (wrappedNums[0] == 0) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        for (int i : wrappedNums) {
            sb.append(i);
        }
        return sb.toString();
    }

    private Integer[] initWrappedInts(int[] nums) {
        if (nums == null) {
            return null;
        }

        int length = nums.length;
        Integer[] result = new Integer[length];
        for (int i = 0; i < length; i++) {
            result[i] = nums[i];
        }
        return result;
    }
}
