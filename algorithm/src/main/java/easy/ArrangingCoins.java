package easy;

/**
 * Problem:
 * No: 441
 * Link: https://leetcode.com/problems/arranging-coins
 * <p>
 * Analysis:
 * According to arithmetic sequence sum formula,
 * x * (x + 1) / 2 = n
 * (x + 1/2) ^ 2 - 1/4 = 2n
 * x = -0.5 + sqrt(2 * n + 0.25)
 * Note that x need to be truncated the fractional part,
 * and (2 * n) need to use long type to avoid overflow.
 */
public class ArrangingCoins {
    public int arrangeCoins(int n) {
        return (int) (-0.5 + Math.sqrt(2L * n + 0.25));
    }
}
