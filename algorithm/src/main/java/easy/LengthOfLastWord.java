package easy;

/**
 * Problem:
 * No: 58
 * Link: https://leetcode.com/problems/length-of-last-word/
 * <p/>
 * Analysis:
 * <p/>
 * Solution1:
 * Use String class's split method to get the last word.
 * <p/>
 * Solution2:
 * Scan the string from back to front to get the length of the last word.
 */
public class LengthOfLastWord {
    public int lengthOfLastWordSolution1(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        String[] words = s.split(" ");
        if (words.length == 0) {
            return 0;
        } else {
            return words[words.length - 1].length();
        }
    }

    public int lengthOfLastWordSolution2(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int length = 0;
        char[] chars = s.trim().toCharArray();
        for (int i = (chars.length - 1); i > -1; i--) {
            if (chars[i] == ' ') {
                break;
            }
            length++;
        }
        return length;
    }
}
