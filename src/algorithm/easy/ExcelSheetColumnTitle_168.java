package algorithm.easy;

/**
 * Problem:
 * https://leetcode.com/problems/excel-sheet-column-title/
 * <p/>
 * Analysis:
 * The essence is converting a decimal number to a base-twenty-six number.
 * But in standard decimal system, every unit ranges from 0 to 9,
 * and in this problem, the number n's every unit ranges from 1 to 10,
 * so always need to minus 1 in the converting process.
 */
public class ExcelSheetColumnTitle_168 {
    public String convertToTitle(int n) {
        if (n < 0) {
            return "";
        }

        char[] alphabet = {'A', 'B', 'C', 'D', 'E', 'F',
                'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P',
                'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
        StringBuilder reverseTitle = new StringBuilder();
        while (n > 0) {
            n = n - 1;
            int index = n % alphabet.length;
            reverseTitle.append(alphabet[index]);
            n = n / alphabet.length;
        }
        return reverseTitle.reverse().toString();
    }
}
