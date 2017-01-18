package medium;

/**
 * Problem:
 * No: 481
 * Link: https://leetcode.com/problems/magical-string/
 * <p>
 * Analysis:
 * Initialize the first magic string with "12",
 * and then generate longer magic string by it,
 * until the magic string's length reaches n.
 * Count the 1s in that magic string before the (n + 1) character.
 */
public class MagicalString {
    public int magicalString(int n) {
        String magicStr = "12";
        while (magicStr.length() < n) {
            magicStr = generateMagicString(magicStr);
        }
        return countOfOne(magicStr, n);
    }

    private String generateMagicString(String s) {
        StringBuilder sb = new StringBuilder();
        char curChar = '1';
        for (char c : s.toCharArray()) {
            if (c == '1') {
                sb.append(curChar);
            } else if (c == '2') {
                sb.append(curChar);
                sb.append(curChar);
            } else {
                throw new RuntimeException("s must be a magic string");
            }

            if (curChar == '1') {
                curChar = '2';
            } else {
                curChar = '1';
            }
        }
        return sb.toString();
    }

    private int countOfOne(String str, int end) {
        int result = 0;
        for (int i = 0; i < end; i++) {
            if (str.charAt(i) == '1') {
                result++;
            }
        }
        return result;
    }
}