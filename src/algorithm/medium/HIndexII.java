package algorithm.medium;

/**
 * Problem:
 * No: 275
 * Link: https://leetcode.com/problems/h-index-ii/
 * <p/>
 * Analysis:
 * Use binary search to decrease time complexity to O(logN).
 */
public class HIndexII {
    public int hIndex(int[] citations) {
        if (citations == null || citations.length == 0) {
            return 0;
        }

        int start = 0;
        int end = citations.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (citations[mid] > (citations.length - 1 - mid)) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return (citations.length - start);
    }
}
