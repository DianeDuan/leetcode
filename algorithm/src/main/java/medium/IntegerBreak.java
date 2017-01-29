package medium;

/**
 * Problem:
 * No: 343
 * Link: https://leetcode.com/problems/integer-break/
 * <p>
 * Analysis:
 * To get the maximum product, we need to get as many 3 as we can.
 * <p>
 * Reference:
 * http://blog.csdn.net/liyuanbhu/article/details/51198124
 */
public class IntegerBreak {
    public int integerBreak(int n) {
        if (n == 2) {
            return 1;
        }
        if (n == 3) {
            return 2;
        }

        int remainder = n % 3;
        if (remainder == 0) {
            return (int) Math.pow(3, n / 3);
        } else if (remainder == 1) {
            return (int) (2 * 2 * Math.pow(3, n / 3 - 1));
        } else {
            return (int) (2 * Math.pow(3, n / 3));
        }
    }
}
