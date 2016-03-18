package algorithm.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * Problem:
 * No: 190
 * Link: https://leetcode.com/problems/reverse-bits/
 * <p/>
 * Analysis:
 * <p/>
 * Solution1:
 * Get every bit from lowest bit to highest bit and add to new int.
 * <p/>
 * Solution2:
 * Use Integer class's method.
 * <p/>
 * Solution3:
 * If this function is called many times, record the result of reverse a byte to optimize it.
 * <p/>
 * Reference:
 * https://segmentfault.com/a/1190000003483740
 * https://leetcode.com/discuss/27328/java-solution-and-optimization
 */
public class ReverseBits {
    // cache
    private final Map<Byte, Integer> cache = new HashMap<Byte, Integer>();

    public int reverseBits_solution1(int n) {
        int reversedNum = 0;
        for (int i = 0; i < 32; i++) {
            reversedNum <<= 1;
            reversedNum |= (n & 1);
            n = (n >> 1);
        }
        return reversedNum;
    }

    public int reverseBits_solution2(int n) {
        return Integer.reverse(n);
    }

    public int reverseBits_solution3(int n) {
        byte[] bytes = new byte[4];
        for (int i = 0; i < 4; i++) { // convert int into 4 bytes
            bytes[i] = (byte) ((n >>> 8 * i) & 0xFF);
        }
        int result = 0;
        for (int i = 0; i < 4; i++) {
            result += reverseByte(bytes[i]); // reverse per byte
            if (i < 3) {
                result <<= 8;
            }
        }
        return result;
    }

    private int reverseByte(byte b) {
        Integer value = cache.get(b);
        if (value != null) {
            return value;
        }
        value = 0;
        for (int i = 0; i < 8; i++) {
            value += ((b >>> i) & 1);
            if (i < 7) {
                value <<= 1;
            }
        }
        cache.put(b, value);
        return value;
    }
}
