package easy;

/**
 * Problem:
 * No: 434
 * Link: https://leetcode.com/problems/number-of-segments-in-a-string/
 * <p>
 * Analysis:
 * Scan the string and increase the count by 1 when encounter a space or contiguous spaces,
 * and increase the count by 1 for the last segment.
 */
public class NumberOfSegmentsInAString {
    public int countSegments(String s) {
        if (s == null) {
            return 0;
        }
        s = s.trim();
        if (s.length() == 0) {
            return 0;
        }

        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                count++;
                while (s.charAt(i) == ' ' && i < s.length()) {
                    i++;
                }
            }
        }
        count++;
        return count;
    }
}
