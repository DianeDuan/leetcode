package algorithm.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * Problem:
 * https://leetcode.com/problems/roman-to-integer/
 * <p/>
 * Analysis:
 * There is a law if a number is between 1 and 3999:
 * initiate a sum to 0,
 * traverse the roman number string from start to end,
 * if the character is less than or equals to the letter before it,
 * add the value this character represents to the sum,
 * if the character is greater than the letter before it,
 * add the value this character represents,
 * minus the value the previous letter represents twice,
 * in the end, the sum is this roman number's value.
 */
public class RomanToInteger_13 {
    public int romanToInt(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        Map<Character, Integer> romanSymbolValue = getRomanSymbolValue();
        char[] chars = s.toCharArray();
        int sum = romanSymbolValue.get(chars[0]);
        for (int i = 1; i < chars.length; i++) {
            int curValue = romanSymbolValue.get(chars[i]);
            int preValue = romanSymbolValue.get(chars[i - 1]);
            if (curValue > preValue) {
                sum += (curValue - 2 * preValue);
            } else {
                sum += curValue;
            }
        }
        return sum;
    }

    private Map<Character, Integer> getRomanSymbolValue() {
        Map<Character, Integer> romanSymbolValue = new HashMap<Character, Integer>();
        romanSymbolValue.put('I', 1);
        romanSymbolValue.put('V', 5);
        romanSymbolValue.put('X', 10);
        romanSymbolValue.put('L', 50);
        romanSymbolValue.put('C', 100);
        romanSymbolValue.put('D', 500);
        romanSymbolValue.put('M', 1000);
        return romanSymbolValue;
    }
}
