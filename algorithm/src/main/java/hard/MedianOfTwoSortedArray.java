package algorithm.hard;

/**
 * Problem:
 * No: 4
 * Link: https://leetcode.com/problems/median-of-two-sorted-arrays/
 * <p/>
 * Analysis:
 * Use two variables, midIdx1 and midIdx2, to record the middle elements' indexes.
 * If the total count of elements in nums1 array and nums2 array is even,
 * the median is the average of two middle numbers.
 * If the total count is odd,
 * the median is the middle numbers,
 * and in this case, use the same value for those two variables.
 * When traverse both arrays simultaneously,
 * always choose the smaller one as current element to reach the middle elements of the two arrays.
 */
public class MedianOfTwoSortedArray {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null || (nums1.length == 0 && nums2.length == 0)) {
            return 0.0;
        }

        int total = nums1.length + nums2.length;
        int midIdx1, midIdx2;
        if (total % 2 == 0) {//median is the average of two middle numbers
            midIdx1 = total / 2;
            midIdx2 = midIdx1 + 1;
        } else {//median is the middle numbers
            midIdx1 = total / 2 + 1;
            midIdx2 = midIdx1;
        }

        int p1 = 0, p2 = 0, median = 0, count = 0;
        while (p1 < nums1.length || p2 < nums2.length) {
            count++;
            int current;
            if (p1 < nums1.length && p2 < nums2.length) {
                if (nums1[p1] < nums2[p2]) {
                    current = nums1[p1];
                    p1++;
                } else {
                    current = nums2[p2];
                    p2++;
                }
            } else if (p1 < nums1.length) {
                current = nums1[p1];
                p1++;
            } else {
                current = nums2[p2];
                p2++;
            }

            if (count == midIdx1) {
                median += current;
            }
            if (count == midIdx2) {
                median += current;
                break;
            }
        }
        return median / 2.0;
    }
}
