package easy;

/**
 * Problem:
 * No: 476
 * Link: https://leetcode.com/problems/number-complement/
 * <p>
 * Analysis:
 * Use xor operation to get complement
 */
public class NumberComplement {
    public int findComplement(int num) {
        int numBitCount = Integer.toBinaryString(num).length();
        int val = 0;
        for (int i = 0; i < numBitCount; i++) {
            val <<= 1;
            val += 1;
        }
        return val ^ num;
    }
}
