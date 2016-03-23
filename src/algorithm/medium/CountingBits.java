package algorithm.medium;

/**
 * Problem:
 * No: 338
 * Link: https://leetcode.com/problems/counting-bits/
 * <p/>
 * Analysis:
 * If a number is the power of 2, like 2, 4, 8, 16 and so on,
 * its count is 1,
 * and the 1 bit counts of the numbers between the two numbers, x1 and x2, which are the powers of 2,
 * is x1 + 1, x1 + 2, x1 + 3, ..., x1 + (x2 - 1),
 * so their counts can be calculated by adding the counts of their two parts.
 */
public class CountingBits {
    public int[] countBits(int num) {
        if (num < 0) {
            return null;
        }
        if (num == 0) {
            return new int[]{0};
        }
        if (num == 1) {
            return new int[]{0, 1};
        }

        int[] result = new int[num + 1];
        result[0] = 0;
        result[1] = 1;
        result[2] = 1;
        int previous = 2;
        for (int i = 3; i <= num; i++) {
            if (i == (previous * 2)) {
                result[i] = 1;
                previous = i;
            } else {
                result[i] = 1 + result[i - previous];
            }
        }
        return result;
    }
}
