package algorithm.easy;

/**
 * Problem:
 * https://leetcode.com/problems/implement-strstr/
 * <p/>
 * Analysis:
 * <p/>
 * Solution1:
 * Compare needle with haystack's substring from the first character,
 * if not match, move one character and continue to compare,
 * until find a match position or the  substring is shorter than needle's length.
 * <p/>
 * Solution2:
 * KMP Algorithm.
 * <p/>
 * Reference:
 * https://en.wikipedia.org/wiki/Knuth%E2%80%93Morris%E2%80%93Pratt_algorithm?oldformat=true
 * http://blog.csdn.net/v_july_v/article/details/7041827
 */
public class ImplementStrStr_28 {
    public int strStr_solution1(String haystack, String needle) {
        if (haystack == null || needle == null) {
            return -1;
        }

        for (int i = 0; i < (haystack.length() - needle.length() + 1); i++) {
            if (haystack.substring(i, i + needle.length()).equals(needle)) {
                return i;
            }
        }
        return -1;
    }

    public int strStr_solution2(String haystack, String needle) {
        if (haystack == null || needle == null) {
            return -1;
        }
        if (needle.length() == 0) {
            return 0;
        }
        int[] t = getMismatchTable(needle);
        int start = 0;
        int current = 0;
        while ((start + current) < haystack.length()) {
            if (needle.charAt(current) == haystack.charAt(start + current)) {
                if (current == (needle.length() - 1)) {
                    return start;
                }
                current++;
            } else {
                start = start + current - t[current];
                if (t[current] > -1) {
                    current = t[current];
                } else {
                    current = 0;
                }
            }
        }
        return -1;
    }

    private int[] getMismatchTable(String s) {
        if (s == null) {
            return null;
        }

        int[] t = new int[s.length()];
        if (s.length() == 1) {
            t[0] = -1;
        } else if (s.length() >= 2) {
            t[0] = -1;
            t[1] = 0;
            int pos = 2;
            int candidate = 0;
            while (pos < s.length()) {
                if (s.charAt(pos - 1) == s.charAt(candidate)) {
                    t[pos] = candidate + 1;
                    candidate++;
                    pos++;
                } else if (candidate > 0) {
                    candidate = t[candidate];
                } else {
                    t[pos] = 0;
                    pos++;
                }
            }
        }
        return t;
    }
}
