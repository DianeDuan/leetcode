package algorithm.easy;

/**
 * Problem:
 * No: 8
 * Link: https://leetcode.com/problems/string-to-integer-atoi/
 * <p/>
 * Analysis:
 * Need to process some special cases.
 * case1: if it starts with a few white spaces, skip these white spaces.
 * for example: input is "   12", output should be 12.
 * case2: if it starts with "+-" or "-+", return 0.
 * for example: input is "+-123", output should be 0.
 * case3: if meet a non-numeric character, omit the others behind it.
 * for example: input is "123A45", output should be 123.
 * case4: if in the process of adding numbers to sum, sum overflows, return Integer's maximum or minimum value.
 * for example: input is "-999999999999999999999999999999999", output should be -2147483648.
 * input is "9999999999999999999999999999999999", output should be 2147483647.
 */
public class StringToInteger {
    public int myAtoi(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }

        str = str.trim();
        char[] chars = str.toCharArray();
        if (chars.length >= 2 && ((chars[0] == '+' && chars[1] == '-') || (chars[0] == '-' && chars[1] == '+'))) {
            return 0;
        }

        boolean isNegative = false;
        int i = 0;
        if (chars[0] == '-') {
            isNegative = true;
            i = 1;
        } else if (chars[0] == '+') {
            i = 1;
        }

        long sum = 0;
        while (i < chars.length) {
            if (chars[i] >= '0' && chars[i] <= '9') {
                int num = chars[i] - '0';
                if (isOverflowed(sum, num, isNegative)) {
                    if (isNegative) {
                        return Integer.MIN_VALUE;
                    } else {
                        return Integer.MAX_VALUE;
                    }
                }
                sum *= 10;
                sum += num;
            } else {
                break;
            }
            i++;
        }

        if (isNegative) {
            return (int) -sum;
        } else {
            return (int) sum;
        }
    }

    private boolean isOverflowed(long sum, int num, boolean isNegative) {
        if (sum == 0) {
            return false;
        }
        if (isNegative) {
            if (num == 0) {
                return sum > Integer.MAX_VALUE / 10;
            } else {
                return sum > (Integer.MAX_VALUE - num) / 10;
            }
        } else {
            return sum > ((Integer.MAX_VALUE - num) / 10);
        }
    }
}
