package algorithm.easy;

/**
 * Problem:
 * https://leetcode.com/problems/ugly-number/
 * <p/>
 * Analysis:
 * If there is a prime factor of n which is not 2, 3 or 5,
 * after divide n by 2, 3 and 5 until the number doesn't contain factors among 2, 3 and 5.
 * If the number isn't 1, that means n contains another prime factor which is not 2, 3 or 5.
 * <p/>
 * Reference:
 * http://fisherlei.blogspot.com/2015/10/leetcode-ugly-number-solution.html
 */
public class UglyNumber_263 {
    public boolean isUgly(int num) {
        if (num <= 0) {
            return false;
        }
        if (num == 1) {
            return true;
        }
        while ((num % 2) == 0) {
            num /= 2;
        }
        while ((num % 3) == 0) {
            num /= 3;
        }
        while ((num % 5) == 0) {
            num /= 5;
        }
        return num == 1;
    }
}
