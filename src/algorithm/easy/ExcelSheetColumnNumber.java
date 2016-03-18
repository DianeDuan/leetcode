package algorithm.easy;

import java.util.LinkedList;

/**
 * Problem:
 * No: 171
 * Link: https://leetcode.com/problems/excel-sheet-column-number/
 * <p/>
 * Analysis:
 * The essence is converting a base-twenty-six number to a decimal number.
 * But in standard decimal system, every unit ranges from 0 to 9,
 * and in this problem, the decimal number's every unit ranges from 1 to 10,
 * so always need to plus 1 in the converting process.
 */
public class ExcelSheetColumnNumber {
    public int titleToNumber(String s) {
        if (s == null || s.equals("")) {
            return 0;
        }
        int number = 0;
        LinkedList<Character> alphabet = initAlphabet();
        char[] titleChars = s.toCharArray();
        for (int i = 0; i < titleChars.length; i++) {
            int tmp = alphabet.indexOf(titleChars[i]);
            if (tmp == -1) {//contains illegal charaters in title
                return 0;
            }
            int exponent = titleChars.length - i - 1;
            number += ((tmp + 1) * Math.pow(alphabet.size(), exponent));
        }
        return number;
    }

    private LinkedList<Character> initAlphabet() {
        LinkedList<Character> alphabet = new LinkedList<Character>();
        char[] array = {'A', 'B', 'C', 'D', 'E', 'F',
                'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P',
                'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
        for (char ch : array) {
            alphabet.add(ch);
        }
        return alphabet;
    }
}
