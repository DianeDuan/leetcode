package easy;

/**
 * Problem:
 * No: 400
 * Link: https://leetcode.com/problems/nth-digit/
 * <p>
 * Analysis:
 * First, calculate how many digit count does the target number should have.
 * Then, calculate the target number.
 * At last, find the target digit.
 */
public class NthDigit {
    public int findNthDigit(int n) {
        if (n < 0) {
            return -1;
        }

        int digitCount = 1;
        int totalDigitCount = 0;
        //calculate the target number's digit count
        while (true) {
            long tmp = totalDigitCount + 9 * (long) Math.pow(10, digitCount - 1) * digitCount;
            if (tmp >= n) {
                break;
            } else {
                totalDigitCount = (int) tmp;
                digitCount++;
            }
        }

        int start = (int) Math.pow(10, digitCount - 1);//calculate the smallest number which has as same digit count as target number
        totalDigitCount += 1;
        int value = start + (n - totalDigitCount) / digitCount;
        return Integer.toString(value).charAt((n - totalDigitCount) % digitCount) - '0';
    }
}
