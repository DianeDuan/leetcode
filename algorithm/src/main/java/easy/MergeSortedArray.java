package easy;

/**
 * Problem:
 * No: 88
 * Link: https://leetcode.com/problems/merge-sorted-array/
 * <p/>
 * Analysis:
 * Put elements for merged array from back to front.
 */
public class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int current1 = m - 1;
        int current2 = n - 1;
        int current = m + n - 1;
        while (current1 > -1 && current2 > -1) {
            if (nums2[current2] > nums1[current1]) {
                nums1[current] = nums2[current2];
                current2--;
            } else {
                nums1[current] = nums1[current1];
                current1--;
            }
            current--;
        }
        if (current2 > -1) {
            System.arraycopy(nums2, 0, nums1, 0, current2 + 1);
        }
    }
}
