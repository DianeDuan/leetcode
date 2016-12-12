package medium;

/**
 * Problem:
 * No: 12
 * Link: https://leetcode.com/problems/integer-to-roman/
 * <p/>
 * Analysis:
 * Use all legal symbol's that are composed of the Roman number symbols that left ones are less than the rightest one
 * as the ordinary symbol such as I, V, X, and so on.
 */
public class IntegerToRoman {
    public String intToRoman(int num) {
        if (num <= 0) {
            return "";
        }
        String[] symbol = {"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};
        int[] value = {1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};
        StringBuilder roman = new StringBuilder();
        int i = value.length - 1;
        while (num != 0) {
            while (num >= value[i]) {
                roman.append(symbol[i]);
                num -= value[i];
            }
            i--;
        }
        return roman.toString();
    }
}
