package medium;

/**
 * Problem:
 * No: 167
 * Link: https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
 * <p>
 * Analysis:
 * Considering the array is sorted, we can just scan the array,
 * use every element as the first number and search the second number by using binary search.
 */
public class TwoSumIIInputArrayIsSorted {
    public int[] twoSum(int[] numbers, int target) {
        if (numbers == null || numbers.length < 2) {
            return null;
        }

        for (int i = 0; i < (numbers.length - 1); i++) {
            int d = target - numbers[i];
            if (d > numbers[numbers.length - 1]) {
                continue;
            }
            int idx = binarySearch(numbers, i + 1, numbers.length - 1, d);
            if (idx != -1) {
                return new int[]{i + 1, idx + 1};
            }
        }
        return null;
    }

    private int binarySearch(int[] numbers, int start, int end, int target) {
        if (start > end) {
            return -1;
        }

        int mid = (start + end) / 2;
        if (numbers[mid] == target) {
            return mid;
        } else if (numbers[mid] > target) {
            return binarySearch(numbers, start, mid - 1, target);
        } else {
            return binarySearch(numbers, mid + 1, end, target);
        }
    }
}
