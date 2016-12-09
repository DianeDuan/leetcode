package algorithm.easy;

/**
 * Problem:
 * No: 321
 * Link: https://leetcode.com/problems/power-of-two/
 * <p/>
 * Analysis:
 * <p/>
 * Solution1:
 * Divide n by 2 in a loop.
 * <p/>
 * Solution2:
 * Use logarithm, if n is a power of 2, the logarithm to base 2 should be an integer.
 * <p/>
 * Solution2:
 * If n is a power of 2, there should be only one bit whose value is 1.
 */
public class PowerOfTwo {
    public boolean isPowerOfTwoSolution1(int n) {
        while (n > 0) {
            if (n == 1) {
                return true;
            }
            if ((n % 2) != 0) {
                return false;
            }
            n /= 2;
        }
        return false;
    }

    public boolean isPowerOfTwoSolution2(int n) {
        double epsilon = 10e-15;
        double logarithm = (Math.log(n) / Math.log(2));
        return Math.abs(logarithm - Math.round(logarithm)) < epsilon;
    }

    public boolean isPowerOfTwoSolution3(int n) {
        if (n <= 0) {
            return false;
        }

        int counter = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & 1) == 1) {
                counter++;
            }
            n = n >> 1;
        }
        return counter == 1;
    }
}
