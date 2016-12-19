package easy;

/**
 * Problem:
 * No: 461
 * Link: https://leetcode.com/problems/hamming-distance/
 * <p>
 * Analysis:
 * Use xor operation for x and y to get the value of the integer composed by different bits.
 * The number of bits whose value is 1 is hamming distance.
 */
public class HammingDistance {
    public int hammingDistance(int x, int y) {
        int xorVal = x ^ y;
        return Integer.bitCount(xorVal);
    }
}
