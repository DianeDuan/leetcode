package medium;

import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Problem:
 * No: 220
 * Link: https://leetcode.com/problems/contains-duplicate-iii/
 * <p/>
 * Analysis:
 * Use a sliding window.
 * <p/>
 * Reference:
 * http://www.programcreek.com/2014/06/leetcode-contains-duplicate-iii-java/
 */
public class ContainsDuplicateIII {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums == null || nums.length == 0 || k < 1 || t < 0) {
            return false;
        }

        SortedSet<Long> set = new TreeSet<Long>();
        for (int i = 0; i < nums.length; i++) {
            long leftBoundary = (long) nums[i] - t;
            long rightBoundary = (long) nums[i] + t + 1;
            SortedSet<Long> subSet = set.subSet(leftBoundary, rightBoundary);
            if (!subSet.isEmpty()) {
                return true;
            }
            set.add((long) nums[i]);
            if (i >= k) {
                set.remove((long) nums[i - k]);//move sliding window
            }
        }
        return false;
    }
}
