package easy;

/**
 * Problem:
 * No: 371
 * Link: https://leetcode.com/problems/sum-of-two-integers/
 * <p>
 * Analysis:
 * <p>
 * Solution1:
 * (a ^ b) is (a + b) bit by bit calculation's result without carry.
 * (a & b) is (a + b) bit by bit calculation's carry of every bit pair.
 * <p>
 * Solution2:
 * Solution2 is Solution1's non-recursive version.
 */
public class SumOfTwoIntegers {
    public int getSumSolution1(int a, int b) {
        if (b != 0) {
            int carry = a & b;
            int noCarry = a ^ b;
            a = getSumSolution1(noCarry, carry << 1);//moving (a & b) to left 1 bit is because when calculate the first bit of (a + b)'s result, the carry is 0
        }
        return a;
    }

    public int getSumSolution2(int a, int b) {
        while (b != 0) {
            int carry = a & b;
            a = a ^ b;
            b = carry << 1;
        }
        return a;
    }
}
