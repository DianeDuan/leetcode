package algorithm.medium;

/**
 * Problem:
 * https://leetcode.com/problems/reverse-words-in-a-string/
 * <p/>
 * Analysis:
 * Reverse the letters of the whole string and skip duplicate spaces,
 * and then reverse the letters of every word.
 * For example, if the original string is "ABC DEF",
 * after the first step, the temporary result is "FED CBA",
 * and after the second step, the final result is "DEF ABC"
 */
public class ReverseWordsInAString_151 {
    public String reverseWords(String s) {
        if (s == null) {
            return "";
        }
        String str = s.trim();
        if (str.length() == 0) {
            return "";
        }

        //reverse the letters of the whole string and skip duplicate spaces
        StringBuilder sb = new StringBuilder();
        for (int i = str.length() - 1; i > 0; i--) {
            if (str.charAt(i) == ' ' && str.charAt(i - 1) == ' ') {
                continue;
            }
            sb.append(str.charAt(i));
        }
        sb.append(str.charAt(0));

        //reverse the letters of every word
        int start = 0;
        int end = 0;
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) != ' ') {
                end++;
            } else {
                reverseWord(sb, start, end);
                start = i + 1;
                end = start;
            }
        }
        reverseWord(sb, start, end);
        return sb.toString();
    }

    private void reverseWord(StringBuilder sb, int start, int end) {
        while (start < (end - 1)) {
            char tmp = sb.charAt(start);
            sb.setCharAt(start, sb.charAt(end - 1));
            sb.setCharAt(end - 1, tmp);
            start++;
            end--;
        }
    }
}
