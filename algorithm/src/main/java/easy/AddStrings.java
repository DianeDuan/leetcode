package easy;

/**
 * Problem:
 * No: 415
 * Link: https://leetcode.com/problems/add-strings/
 * <p>
 * Analysis:
 * Add the two numbers' digits to get the sum.
 */
public class AddStrings {
    public String addStrings(String num1, String num2) {
        StringBuilder sum = new StringBuilder();
        int i = (num1.length() - 1);
        int j = num2.length() - 1;
        int carry = 0;
        while (i >= 0) {
            if (j < 0) {
                break;
            }
            int curDigitSum = Integer.parseInt(String.valueOf(num1.charAt(i))) + Integer.parseInt(String.valueOf(num2.charAt(j))) + carry;
            carry = curDigitSum / 10;
            sum.append(curDigitSum % 10);
            i--;
            j--;
        }
        if (i >= 0) {
            sum.append(sumOfRemainAndCarry(num1, i, carry));
        } else if (j >= 0) {
            sum.append(sumOfRemainAndCarry(num2, j, carry));
        } else if (carry != 0) {
            sum.append(carry);
        }
        return sum.reverse().toString();
    }

    private String sumOfRemainAndCarry(String num, int startIdx, int carry) {
        StringBuilder sum = new StringBuilder();
        while (startIdx >= 0) {
            int curDigitSum = Integer.parseInt(String.valueOf(num.charAt(startIdx))) + carry;
            carry = curDigitSum / 10;
            sum.append(curDigitSum % 10);
            startIdx--;
        }
        if (carry != 0) {
            sum.append(carry);
        }
        return sum.toString();
    }
}
