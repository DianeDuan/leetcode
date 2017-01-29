package medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Problem:
 * No: 17
 * Link: https://leetcode.com/problems/letter-combinations-of-a-phone-number/
 * <p/>
 * Analysis:
 * Recursive backtrace solution.
 */
public class LetterCombinationsOfAPhoneNumber {
    private static Map<Character, char[]> keyboardMapping = initKeyboardMapping();

    private static Map<Character, char[]> initKeyboardMapping() {
        Map<Character, char[]> result = new HashMap<Character, char[]>();
        result.put('2', new char[]{'a', 'b', 'c'});
        result.put('3', new char[]{'d', 'e', 'f'});
        result.put('4', new char[]{'g', 'h', 'i'});
        result.put('5', new char[]{'j', 'k', 'l'});
        result.put('6', new char[]{'m', 'n', 'o'});
        result.put('7', new char[]{'p', 'q', 'r', 's'});
        result.put('8', new char[]{'t', 'u', 'v'});
        result.put('9', new char[]{'w', 'x', 'y', 'z'});
        return result;
    }

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return new ArrayList<String>();
        }

        return combine(digits.toCharArray(), "");
    }

    private List<String> combine(char[] digits, String current) {
        List<String> result = new ArrayList<String>();
        if (current.length() == digits.length) {
            result.add(current);
        } else {
            for (char c : keyboardMapping.get(digits[current.length()])) {
                result.addAll(combine(digits, current + c));
            }
        }
        return result;
    }
}
