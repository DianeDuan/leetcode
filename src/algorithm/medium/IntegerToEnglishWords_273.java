package algorithm.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Problem:
 * https://leetcode.com/problems/integer-to-english-words/
 * <p/>
 * Analysis:
 * Divide num into several chunks every three digits,
 * and then parse chunks into words.
 */
public class IntegerToEnglishWords_273 {
    private static Map<Integer, String> numToWordMap = initNumToWordMap();

    public String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }
        List<Integer> chunks = divide(num);
        StringBuilder sb = new StringBuilder();
        String[] unitNames = {"", " Thousand", " Million", " Billion"};
        for (int i = chunks.size() - 1; i > -1; i--) {
            int number = chunks.get(i);
            if (number != 0) {
                sb.append(" ");
                sb.append(parseThreeDigits(number));
                sb.append(unitNames[i]);
            }
        }
        return sb.toString().trim();
    }

    private List<Integer> divide(int num) {
        List<Integer> chunks = new ArrayList<Integer>();
        while (num != 0) {
            int chunk = num % 1000;
            chunks.add(chunk);
            num /= 1000;
        }
        return chunks;
    }

    private String parseThreeDigits(int number) {
        StringBuilder sb = new StringBuilder();
        int first = number % 10;
        int second = (number / 10) % 10;
        int third = number / 100;
        if (third != 0) {
            sb.append(numToWordMap.get(third));
            sb.append(" Hundred");
        }
        if (second != 0) {
            if (third != 0) {
                sb.append(" ");
            }
            if (second == 1) {
                int tmp = second * 10 + first;
                sb.append(numToWordMap.get(tmp));
            } else {
                sb.append(numToWordMap.get(second * 10));
                if (first != 0) {
                    sb.append(" ");
                    sb.append(numToWordMap.get(first));
                }
            }
        } else if (first != 0) {
            if (third != 0) {
                sb.append(" ");
            }
            sb.append(numToWordMap.get(first));
        }
        return sb.toString();
    }

    private static Map<Integer, String> initNumToWordMap() {
        Map<Integer, String> result = new HashMap<Integer, String>();
        result.put(1, "One");
        result.put(2, "Two");
        result.put(3, "Three");
        result.put(4, "Four");
        result.put(5, "Five");
        result.put(6, "Six");
        result.put(7, "Seven");
        result.put(8, "Eight");
        result.put(9, "Nine");
        result.put(10, "Ten");
        result.put(11, "Eleven");
        result.put(12, "Twelve");
        result.put(13, "Thirteen");
        result.put(14, "Fourteen");
        result.put(15, "Fifteen");
        result.put(16, "Sixteen");
        result.put(17, "Seventeen");
        result.put(18, "Eighteen");
        result.put(19, "Nineteen");
        result.put(20, "Twenty");
        result.put(30, "Thirty");
        result.put(40, "Forty");
        result.put(50, "Fifty");
        result.put(60, "Sixty");
        result.put(70, "Seventy");
        result.put(80, "Eighty");
        result.put(90, "Ninety");
        return result;
    }
}
