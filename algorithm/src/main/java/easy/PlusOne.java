package algorithm.easy;

/**
 * Problem:
 * No: 66
 * Link: https://leetcode.com/problems/plus-one/
 * <p/>
 * Analysis:
 * Plus 1 to the rightmost element in digits array,
 * and if there is a carry, plus 1 to the second rightmost element in digits array,
 * and so on, until there is no carry or already plus 1 to the leftmost element.
 * If after plus 1 to the leftmost element, there is still a carry,
 * use a new array to represent the plus one result.
 */
public class PlusOne {
    public int[] plusOne(int[] digits) {
        if (digits == null) {
            return null;
        }

        int carry = 1;
        for (int i = digits.length - 1; i > -1; i--) {
            int sum = digits[i] + carry;
            carry = sum / 10;
            digits[i] = sum % 10;
            if (carry == 0) {
                return digits;
            }
        }
        int[] result = new int[digits.length + 1];
        result[0] = 1;
        return result;
    }
}
