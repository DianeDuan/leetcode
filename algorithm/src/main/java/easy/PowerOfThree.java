package algorithm.easy;

/**
 * Problem:
 * No: 326
 * Link: https://leetcode.com/problems/power-of-three/
 * <p/>
 * Analysis:
 * <p/>
 * Solution1:
 * Divide n by 3 in a loop.
 * <p/>
 * Solution2:
 * Use logarithm, if n is power of 3, the logarithm to base 3 should be an integer.
 */
public class PowerOfThree {
    public boolean isPowerOfThreeSolution1(int n) {
        while (n > 0) {
            if (n == 1) {
                return true;
            }
            if ((n % 3) != 0) {
                return false;
            }
            n /= 3;
        }
        return false;
    }

    public boolean isPowerOfThreeSolution2(int n) {
        double epsilon = 10e-15;
        double logarithm = (Math.log(n) / Math.log(3));
        return Math.abs(logarithm - Math.round(logarithm)) < epsilon;
    }
}
