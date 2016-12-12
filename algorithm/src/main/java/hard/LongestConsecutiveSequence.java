package hard;

import java.util.HashSet;
import java.util.Set;

/**
 * Problem:
 * No: 128
 * Link: https://leetcode.com/problems/longest-consecutive-sequence/
 * <p/>
 * Analysis:
 * Use a set to avoid duplicates.
 * Traverse the nums array and find each element's consecutive sequence numbers,
 * which are less and greater than it,
 * and remove these numbers from set after they're found
 * to assure each element in the array only is accessed twice at most.
 * <p/>
 * Reference:
 * http://www.cnblogs.com/springfor/p/3869981.html
 */
public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        if (nums == null) {
            return 0;
        }

        Set<Integer> set = new HashSet<Integer>();
        for (int num : nums) {
            set.add(num);
        }

        int max = 0;
        for (int num : nums) {
            if (!set.contains(num)) {
                continue;
            }
            int j = 0;
            while (set.contains(num - j)) {
                set.remove(num - j);
                j++;
            }
            int count = j;
            j = 1;
            while (set.contains(num + j)) {
                set.remove(num + j);
                j++;
            }
            count += (j - 1);
            max = Math.max(max, count);
        }
        return max;
    }
}
