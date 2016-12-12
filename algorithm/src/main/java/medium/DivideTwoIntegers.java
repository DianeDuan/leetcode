package medium;

/**
 * Problem:
 * No: 29
 * Link: https://leetcode.com/problems/divide-two-integers/
 * <p/>
 * Analysis:
 * Use bit operations.
 * <p/>
 * Reference:
 * http://www.acmerblog.com/leetcode-divide-two-integers-5977.html
 * http://blog.csdn.net/linhuanmars/article/details/20024907
 */
public class DivideTwoIntegers {
    public int divide(int dividend, int divisor) {
        if (divisor == 0) {
            return Integer.MIN_VALUE;
        }

        boolean isNegative = false;
        if ((dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0)) {
            isNegative = true;
        }

        long longDividend = Math.abs((long) dividend);
        long longDivisor = Math.abs((long) divisor);

        if (longDivisor > longDividend) {
            return 0;
        }

        long d = longDivisor;
        long bitCnt = 1;
        long result = 0;
        while (d < longDividend) {
            d <<= 1;
            bitCnt <<= 1;
        }
        while (d >= longDivisor) {
            while (longDividend >= d) {
                longDividend -= d;
                result += bitCnt;
            }
            d >>= 1;
            bitCnt >>= 1;
        }

        if (!isNegative && (result - 1) == Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        } else {
            return (int) (isNegative ? -result : result);
        }
    }
}
