package easy;

/**
 * Problem:
 * No: 14
 * Link: https://leetcode.com/problems/longest-common-prefix/
 * <p/>
 * Analysis:
 * Traverse the strs array to find the longest common prefix.
 * Initial longest common prefix is the first element of array.
 */
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        sb.append(strs[0]);
        for (int i = 1; i < strs.length; i++) {
            if (sb.length() > strs[i].length()) {
                sb.delete(strs[i].length(), sb.length());
            }
            for (int j = 0; j < sb.length(); j++) {
                if (sb.charAt(j) != strs[i].charAt(j)) {
                    sb.delete(j, sb.length());
                }
            }
        }
        return sb.toString();
    }
}
