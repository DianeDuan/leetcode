package algorithm.medium;

/**
 * Problem:
 * No: 233
 * Link: https://leetcode.com/problems/number-of-digit-one/
 * <p/>
 * Analysis:
 * Count the number of digit one from ones, tens, ..., until the highest position.
 * For example, if n is 100,
 * from 1 to 100,
 * the count of numbers, whose first digit is 1, is 10,
 * the count of numbers, whose second digit is 1, is 10,
 * the count of numbers, whose third digit is 1, is 1 (this number is 100),
 * the sum is 21.
 * <p/>
 * Reference:
 * http://meetqun.com/thread-10288-1-1.html
 */
public class NumberOfDigitOne {
    public int countDigitOne(int n) {
        if (n <= 0) {
            return 0;
        }

        int result = 0;
        long position = 1;//count from the first digit
        long left, right;
        while (n >= position) {
            left = n / position;
            right = n % position;
            if ((left % 10) >= 2) {//the digit on current position is greater than 1
                result += (left / 10 + 1) * position;
            } else if ((left % 10) == 1) {//the digit on current position is 1
                result += (left / 10) * position + (right + 1);
            } else {//the digit on current position is 0
                result += (left / 10) * position;
            }
            position *= 10;
        }
        return result;
    }
}
