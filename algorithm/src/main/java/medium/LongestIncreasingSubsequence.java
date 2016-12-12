package medium;

import java.util.Arrays;

/**
 * Problem:
 * No: 300
 * Link: https://leetcode.com/problems/longest-increasing-subsequence/
 * <p/>
 * Analysis:
 * <p/>
 * Solution1:
 * Dynamic programming solution.
 * Use a currentMax array for recording,
 * currentMax[i] is the length of the longest subsequence which is ended with nums[i].
 * <p/>
 * Solution2:
 * Dynamic programming solution.
 * Use a minIndex array for recording,
 * minIndex[i] is the index of the minimal one of the elements
 * which are the last elements of the longest subsequences whose lengths are equals to i.
 * As minIndex array is definitely increasing,
 * (because if minIndex[i-1] is greater than minIndex[i],
 * the minimal one of the last elements of subsequences whose length are equals to (i-1) should be minIndex[i],
 * that means minIndex[i-1] should be equals to minIndex[i],
 * it contradicts with the definition of minIndex array)
 * we can use binary search with it.
 * <p/>
 * Reference:
 * https://en.wikipedia.org/wiki/Longest_increasing_subsequence?oldformat=true
 * https://en.wikipedia.org/wiki/Longest_common_subsequence_problem?oldformat=true
 * http://www.wutianqi.com/?p=1850
 * http://www.bubuko.com/infodetail-1179517.html
 */
public class LongestIncreasingSubsequence {
    //time complexity: O(n^2)
    public int lengthOfLISSolution1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int[] currentMax = new int[nums.length];
        currentMax[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            int tmp = 0;
            for (int j = 0; j < i; j++) {
                if ((nums[i] > nums[j]) && (tmp < currentMax[j])) {
                    tmp = currentMax[j];
                }
            }
            currentMax[i] = tmp + 1;
        }
        return max(currentMax);
    }

    //time complexity: O(N*logN)
    public int lengthOfLISSolution2(int[] nums) {
        int[] minIndex = new int[nums.length];
        int len = 0;
        for (int num : nums) {
            int i = Arrays.binarySearch(minIndex, 0, len, num);
            if (i < 0) {
                i = -(i + 1);//get the index of the first element in array which is greater than num
            }
            minIndex[i] = num;
            if (i == len) {
                len++;
            }
        }
        return len;
    }

    private int max(int[] array) {
        if (array == null || array.length == 0) {
            return Integer.MIN_VALUE;
        }

        int max = Integer.MIN_VALUE;
        for (int element : array) {
            if (element > max) {
                max = element;
            }
        }
        return max;
    }
}
