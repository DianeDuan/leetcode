package algorithm.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * Problem:
 * https://leetcode.com/problems/majority-element/
 * <p/>
 * Analysis:
 * <p/>
 * Solution1:
 * Use a map to record the occurrence times of every numbers in the array,
 * and check which number's occurrence time matches the majority definition.
 * <p/>
 * Solution2:
 * Boyer-Moore Majority Vote Algorithm.
 * Reference:
 * https://en.wikipedia.org/wiki/Boyer%E2%80%93Moore_majority_vote_algorithm?oldformat=true
 * http://blog.csdn.net/joylnwang/article/details/7081575
 */
public class MajorityElement_169 {
    //time complexity: O(n), space complexity: O(n)
    public int majorityElement_solution1(int[] nums) {
        int threshold = nums.length / 2;
        Map<Integer, Integer> numCount = new HashMap<Integer, Integer>();
        for (int num : nums) {
            if (numCount.containsKey(num)) {
                int count = numCount.get(num);
                numCount.put(num, count + 1);
            } else {
                numCount.put(num, 1);
            }
            if (numCount.get(num) > threshold) {
                return num;
            }
        }
        return 0;//if majority element always exists, the program will never reach here.
    }

    //time complexity: O(n), space complexity: O(n)
    public int majorityElement_solution2(int[] nums) {
        int candidate = nums[0];
        int counter = 1;
        for (int i = 1; i < nums.length; i++) {
            if (counter == 0) {
                candidate = nums[i];
            }
            if (nums[i] == candidate) {
                counter++;
            } else {
                counter--;
            }
        }
        return candidate;
    }
}
