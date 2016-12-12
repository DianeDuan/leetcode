package easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem:
 * No: 202
 * Link: https://leetcode.com/problems/happy-number/
 * <p/>
 * Analysis:
 * Record every intermediate result in processing the number n,
 * once a sum is already recorded, it means there is a loop and n is not a happy number.
 */
public class HappyNumber {
    public boolean isHappy(int n) {
        if (n <= 0) {
            return false;
        }
        List<Integer> record = new ArrayList<Integer>();
        while (n != 1) {
            int sum = getDigitSquareSum(n);
            if (sum == 1) {
                break;
            } else if (record.contains(sum)) {
                return false;
            } else {
                record.add(sum);
                n = sum;
            }
        }
        return true;
    }

    private int getDigitSquareSum(int n) {
        int sum = 0;
        while (n > 0) {
            int digit = n % 10;
            sum += digit * digit;
            n /= 10;
        }
        return sum;
    }
}
