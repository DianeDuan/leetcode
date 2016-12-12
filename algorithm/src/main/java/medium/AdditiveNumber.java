package medium;

/**
 * Problem:
 * No: 306
 * Link: https://leetcode.com/problems/additive-number/
 * <p/>
 * Analysis:
 * Once the first number is chosen, the subsequent numbers has only one possibility.
 * So just try every possible pairs of the first two numbers
 * to find if there is a legal sequence.
 */
public class AdditiveNumber {
    public boolean isAdditiveNumber(String num) {
        if (num == null || num.length() < 3) {
            return false;
        }

        for (int i = 1; i < num.length(); i++) {
            for (int j = i + 1; j <= num.length(); j++) {
                if (i > 1 && num.substring(0, i).startsWith("0")) {
                    break;
                }
                if (j > (i + 1) && num.substring(i, j).startsWith("0")) {
                    continue;
                }
                long num1 = Long.parseLong(num.substring(0, i));
                long num2 = Long.parseLong(num.substring(i, j));
                long sum = num1 + num2;
                int nextStart = j;
                int count = 2;
                while (nextStart < num.length() && num.charAt(nextStart) != '0' && num.indexOf(String.valueOf(sum), nextStart) == nextStart) {
                    count++;
                    nextStart = nextStart + String.valueOf(sum).length();
                    num1 = num2;
                    num2 = sum;
                    sum = num1 + num2;
                }
                if (nextStart == num.length() && count > 2) {
                    return true;
                }
            }
        }
        return false;
    }
}
