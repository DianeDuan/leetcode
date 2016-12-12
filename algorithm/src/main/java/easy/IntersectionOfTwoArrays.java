package easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Problem:
 * No: 349
 * Link: https://leetcode.com/problems/intersection-of-two-arrays/
 * <p>
 * Analysis:
 * Sort two arrays and then compare two sorted array to get their intersection.
 */
public class IntersectionOfTwoArrays {
    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) {
            return null;
        }

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        Set<Integer> intersection = new HashSet<Integer>();
        int i = 0, j = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                intersection.add(nums1[i]);
                i++;
                j++;
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }
        }

        int[] result = new int[intersection.size()];
        i = 0;
        for (Integer item : intersection) {
            result[i] = item;
            i++;
        }
        return result;
    }
}
