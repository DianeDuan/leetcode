package algorithm.hard;

/**
 * Problem:
 * No: 287
 * Link: https://leetcode.com/problems/find-the-duplicate-number/
 * <p/>
 * Analysis:
 * <p/>
 * First part: prove that at least one duplicate number must exist
 * Use the pigeonhole principle.
 * <p/>
 * Second part: assume that there is only one duplicate number, find the duplicate one(which could be repeated more than once)
 *
 * Solution1: Pigeonhole principle and binary search
 * According to the Pigeonhole Principle,
 * if all the integers which less than k(k>=1 and k<=n) is not duplicate, the count of these integers should be less than k.
 * Choose a k(k>=1 and k<=n),
 * if the count of all the numbers greater than k in nums array is greater than k,
 * it means the range of the duplicate number is between 1 and k,
 * and if the count of all the numbers greater than k in nums array is less than k,
 * it means the range of the duplicate number is between k and n.
 * Use binary search to find the duplicate number can achieve time complexity O(nlogn).
 * <p/>
 * Solution2: Find the start of a cycle
 * If there is duplicate number in nums array, there will be a cycle in this array:
 * y[0] = 0, y[1] = nums[y[0]], y[2] = nums[y[1]], y[t] = nums[y[t-1]].
 * This turn this problem into a finding the start of a cycle problem.
 * Use Floyd's cycle-finding algorithm to find the start of a cycle.
 * <p/>
 * Reference:
 * Solutions of the problem:
 * https://segmentfault.com/a/1190000003817671#articleHeader15
 * Pigeonhole Principle:
 * https://en.wikipedia.org/wiki/Pigeonhole_principle?oldformat=true
 * https://zh.wikipedia.org/wiki/%E9%B4%BF%E5%B7%A2%E5%8E%9F%E7%90%86?oldformat=true
 * Cycle Detection:
 * https://en.wikipedia.org/wiki/Cycle_detection?oldformat=true
 */
public class FindTheDuplicateNumber {
    //time complexity: O(nlogn), space complexity: o(1)
    public int findDuplicate_solution1(int[] nums) {
        if (nums == null) {
            return 0;
        }

        int min = 1;
        int max = nums.length - 1;
        while (min <= max) {
            int middle = (max + min) / 2;
            int leMiddleCount = 0;
            for (int num : nums) {
                if (num <= middle) {
                    leMiddleCount++;
                }
            }
            if (leMiddleCount > middle) {
                max = middle - 1;
            } else {
                min = middle + 1;
            }
        }
        return min;
    }

    //time complexity: O(n), space complexity: o(1)
    public int findDuplicate_solution2(int[] nums) {
        if (nums == null) {
            return 0;
        }

        int fast = 0;
        int slow = 0;
        while (slow < nums.length && fast < nums.length) {
            slow = nums[slow];
            fast = nums[fast];
            if (fast < nums.length) {
                fast = nums[fast];
            } else {
                return 0;
            }
            if (nums[fast] == nums[slow]) {
                return getLoopStart(fast, nums);
            }
        }
        return 0;
    }

    private int getLoopStart(int meetPosition, int[] nums) {
        if (nums == null || nums.length < meetPosition) {
            return 0;
        }
        int startPointer = 0;
        int loopPointer = meetPosition;
        while (startPointer < nums.length && loopPointer < nums.length) {
            if (nums[startPointer] == nums[loopPointer]) {
                return nums[startPointer];
            }
            startPointer = nums[startPointer];
            loopPointer = nums[loopPointer];
        }
        return 0;
    }
}
