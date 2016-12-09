package algorithm.easy;

/**
 * Problem:
 * No: 6
 * Link: https://leetcode.com/problems/zigzag-conversion/
 * <p/>
 * Analysis:
 * Simulate the process of generating numRows strings.
 */
public class ZigZagConversion {
    public String convert(String s, int numRows) {
        if (s == null || s.length() == 0) {
            return "";
        }
        if (numRows == 1) {
            return s;
        }

        StringBuilder[] builders = new StringBuilder[numRows];
        for (int i = 0; i < builders.length; i++) {
            builders[i] = new StringBuilder();
        }

        int i = 0;
        boolean isDownward = true;
        for (char ch : s.toCharArray()) {
            builders[i].append(ch);

            if (i == (numRows - 1)) {
                isDownward = false;
            } else if (i == 0) {
                isDownward = true;
            }
            if (isDownward) {
                i++;
            } else {
                i--;
            }
        }
        return parseToStr(builders);
    }

    private String parseToStr(StringBuilder[] builders) {
        if (builders == null) {
            return "";
        }

        StringBuilder result = new StringBuilder();
        for (StringBuilder builder : builders) {
            result.append(builder.toString());
        }
        return result.toString();
    }
}
