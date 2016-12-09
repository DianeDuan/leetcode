package algorithm.hard;

/**
 * Problem:
 * No: 65
 * Link: https://leetcode.com/problems/valid-number/
 * <p/>
 * Analysis:
 * Use regular expression.
 * <p/>
 * These are numbers:
 * "-1."
 * "+.8"
 * <p/>
 * These are not numbers:
 * ".."
 * "1e."
 * <p/>
 * Reference:
 * http://www.cnblogs.com/springfor/p/3893598.html
 */
public class ValidNumber {
    public boolean isNumber(String s) {
        if (s.trim().isEmpty()) {
            return false;
        }
        String regex = "[-+]?(\\d+\\.?|\\.\\d+)\\d*(e[-+]?\\d+)?";
        return s.trim().matches(regex);
    }
}
