package algorithm.easy;

/**
 * Problem:
 * https://leetcode.com/problems/reverse-integer/
 * <p/>
 * Analysis:
 * Get every digit and add to reversedNum.
 * Need to process overflow situation.
 * If overflow, return 0.
 */
public class ReverseInteger_7 {
    public int reverse(int x) {
        int reversedNum = 0;
        while (x != 0) {
            if (Math.abs(reversedNum) > (Integer.MAX_VALUE / 10)) {//overflow
                return 0;
            }
            reversedNum *= 10;
            reversedNum += (x % 10);
            x /= 10;
        }
        return reversedNum;
    }
}
