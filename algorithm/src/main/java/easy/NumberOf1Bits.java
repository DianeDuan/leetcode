package easy;

/**
 * Problem:
 * No: 191
 * Link: https://leetcode.com/problems/number-of-1-bits/
 * <p/>
 * Analysis:
 * <p/>
 * Solution1:
 * Use the method of Class Integer
 * <p/>
 * Solution2:
 * (1 & n) equals to the rightest bit of n.
 * A integer has 32 bits, so by using right shift operation 32 times,
 * we can get all the bits of a integer.
 */
public class NumberOf1Bits {
    public int hammingWeightSolution1(int n) {
        return Integer.bitCount(n);
    }

    public int hammingWeightSolution2(int n) {
        int sum = 0;
        for (int i = 0; i < 32; i++) {
            sum += (n & 1);
            n = n >> 1;
        }
        return sum;
    }
}
