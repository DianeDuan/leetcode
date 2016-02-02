package algorithm.easy;

/**
 * Problem:
 * https://leetcode.com/problems/palindrome-number/
 * <p/>
 * Analysis:
 * <p/>
 * Solution1:
 * Reverse x to get a reversed number,
 * if this number euqals to x,
 * x is a palindrome number.
 * This solution doesn't consider the reversed number may overflow.
 * <p/>
 * Solution2:
 * Compare the rightmost and the leftmost digits,
 * then compare the second rightmost and the second leftmost digits,
 * and so on.
 * <p/>
 * Reference:
 * http://www.programcreek.com/2013/02/leetcode-palindrome-number-java/
 */
public class PalindromeNumber_9 {
    public boolean isPalindrome_solution1(int x) {
        if (x < 0) {
            return false;
        }

        int reversedX = reverseNumber(x);
        return reversedX == x;
    }

    public boolean isPalindrome_solution2(int x) {
        if (x < 0)
            return false;

        int div = 1;
        while (x / div >= 10) {
            div *= 10;
        }

        while (x != 0) {
            int left = x / div;
            int right = x % 10;

            if (left != right)
                return false;

            x = (x % div) / 10;//delete left and right digits
            div /= 100;
        }

        return true;
    }

    private int reverseNumber(int num) {
        int reversedNum = 0;
        while (num != 0) {
            int digit = num % 10;
            reversedNum *= 10;
            reversedNum += digit;
            num /= 10;
        }
        return reversedNum;
    }
}
