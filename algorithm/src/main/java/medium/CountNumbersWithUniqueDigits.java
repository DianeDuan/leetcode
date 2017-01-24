package medium;

/**
 * Problem:
 * No: 357
 * Link: https://leetcode.com/problems/count-numbers-with-unique-digits/
 * <p>
 * Analysis:
 * When form a nonzero number, there's only 9 choices for the highest digit, because it cannot be 0,
 * and after choosing the highest digit, there remains 9 choices for every other digit.
 */
public class CountNumbersWithUniqueDigits {
    public int countNumbersWithUniqueDigits(int n) {
        if (n < 0) {
            return -1;
        }

        int maxNum = (int) (Math.pow(10, n) - 1);
        int maxDigitCount = countDigits(maxNum);
        int result = 0;
        for (int i = 1; i <= maxDigitCount; i++) {
            result += 9 * countPermutations(9, i - 1);
        }
        result += 1;//for 0
        return result;
    }

    private int countDigits(int num) {
        int result = 0;
        while (num != 0) {
            result++;
            num /= 10;
        }
        return result;
    }

    private int countPermutations(int n, int k) {
        if (k == 0) {
            return 1;
        }

        int result = n;
        for (int i = 1; i <= (k - 1); i++) {
            result *= (n - i);
        }
        return result;
    }
}
