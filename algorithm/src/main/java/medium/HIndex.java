package algorithm.medium;

import java.util.Arrays;

/**
 * Problem:
 * No: 274
 * Link: https://leetcode.com/problems/h-index/
 * <p/>
 * Analysis:
 * Sort the array.
 * Then traverse the array,
 * compare the citation[i-1] with citation[i] to judge if "the other N − h papers have no more than h citations each",
 * compare the citation[i] with (citations.length - i) to judge if "h of his/her N papers have at least h citations each".
 */
public class HIndex {
    public int hIndex(int[] citations) {
        if (citations == null || citations.length == 0) {
            return 0;
        }

        Arrays.sort(citations);
        int h = 0;
        for (int i = 0; i < citations.length; i++) {
            int currentH = citations.length - i;
            if (((i == 0) || (citations[i - 1] <= currentH)) && (citations[i] >= currentH)) {
                h = currentH;
            }
        }
        return h;
    }
}
