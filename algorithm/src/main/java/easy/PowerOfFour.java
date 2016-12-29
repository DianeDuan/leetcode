package easy;

/**
 * Problem:
 * No: 342
 * Link: https://leetcode.com/problems/power-of-four/
 * <p>
 * Analysis:
 * If a number is the power of four, it has only one bit whose value is 1, and that bit is the highest bit,
 * and its trailing 0 count is even.
 */
public class PowerOfFour {
    public boolean isPowerOfFour(int num) {
        if (num <= 0) {
            return false;
        }

        String bitStr = Integer.toBinaryString(num);
        for (int i = 1; i < bitStr.length(); i++) {
            if (bitStr.charAt(i) == '1') {
                return false;
            }
        }
        return (bitStr.length() - 1) % 2 == 0;
    }
}
