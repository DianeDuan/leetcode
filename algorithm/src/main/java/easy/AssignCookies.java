package easy;

import java.util.Arrays;

/**
 * Problem:
 * No: 455
 * Link: https://leetcode.com/problems/assign-cookies/
 * <p>
 * Analysis:
 * Sort g array and s array in ascending order.
 * Assign cookies from the child with minimal greed factor value to the child with maximal greed factor
 * by using the cookie from minimal size to maximal size
 * until meet the first child cannot be made content,
 * the rest children cannot be made content either.
 */
public class AssignCookies {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int contentChildrenCount = 0;
        int i = 0, j = 0;
        while (i < g.length) {
            if (j >= s.length) {
                break;
            }
            if (s[j] >= g[i]) {
                contentChildrenCount++;
                j++;
                i++;
            } else {
                j++;
            }
        }
        return contentChildrenCount;
    }
}
