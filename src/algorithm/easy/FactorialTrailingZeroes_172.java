package algorithm.easy;

/**
 * Problem:
 * https://leetcode.com/problems/factorial-trailing-zeroes/
 * <p/>
 * Analysis:
 * The count of trailing zeroes of n! equals to the count of pairs of two and five in all the prime factors of 1, 2, ..., n.
 * 2 in the prime factors must be more than 5, so it equals to the count of factor 5.
 * Use division to calculate this count. Pay attention to:
 * 5 will contribute one five factor, 25 will contribute two five factors, 125 will contribute three five factors, and so on.
 */
public class FactorialTrailingZeroes_172 {
    public int trailingZeroes(int n) {
        if (n < 0) {
            return 0;
        }

        int countOfFive = 0;
        for (long i = 5; (n / i) >= 1; i *= 5) {
            countOfFive += (n / i);
        }
        return countOfFive;
    }
}
