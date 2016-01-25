package algorithm.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem:
 * https://leetcode.com/problems/majority-element-ii/
 * <p/>
 * Analysis:
 * The definition of majority element is the number appears more than ⌊ n/3 ⌋ times,
 * that means the count of the majority elements could be 0, 1 or 2.
 * To solve the problem with time complexity O(n) and space complexity O(1),
 * we can use a variation of Boyer-Moore Majority Vote Algorithm,
 * instead of one candidate and one counter for this candidate,
 * we use three candidates and their counters to find the top 2 elements in occurrence times,
 * and the check if these candidates match the majority element definition.
 * <p/>
 * Reference:
 * http://www.neozone.me/leetcode229.html
 */
public class MajorityElementII_229 {
    public List<Integer> majorityElement(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<Integer>();
        }
        //find top 2
        int candidates[] = getCandidates(nums, 2);
        //get counts of the top 2 numbers
        int counters[] = getCounters(nums, candidates);
        //get the numbers that match the majority element's definition
        return getMajorityElements(candidates, counters, Math.floorDiv(nums.length, 3));
    }

    private int[] getCandidates(int[] nums, int candidateCounts) {
        if (nums == null || candidateCounts <= 0) {
            return new int[0];
        }
        int[] candidates = new int[candidateCounts];
        int[] counters = new int[candidateCounts];
        for (int num : nums) {
            boolean isInCandidates = false;
            for (int i = 0; i < candidateCounts; i++) {
                if (num == candidates[i]) {
                    counters[i]++;
                    isInCandidates = true;
                    break;
                }
            }
            if (!isInCandidates) {
                for (int i = 0; i < candidateCounts; i++) {
                    if (counters[i] == 0) {
                        candidates[i] = num;
                        counters[i] = 1;
                        isInCandidates = true;
                        break;
                    }
                }
                if (!isInCandidates) {
                    for (int i = 0; i < candidateCounts; i++) {
                        counters[i]--;
                    }
                }
            }
        }
        return candidates;
    }

    private int[] getCounters(int[] nums, int[] candidates) {
        if (nums == null || candidates == null) {
            return new int[0];
        }
        int[] counters = new int[candidates.length];
        for (int num : nums) {
            for (int i = 0; i < candidates.length; i++) {
                if (num == candidates[i]) {
                    counters[i]++;
                    break;
                }
            }
        }
        return counters;
    }

    private List<Integer> getMajorityElements(int[] candidates, int[] counters, int threshold) {
        List<Integer> result = new ArrayList<Integer>();
        if (candidates != null && counters != null && candidates.length == counters.length) {
            for (int i = 0; i < candidates.length; i++) {
                if (counters[i] > threshold) {
                    result.add(candidates[i]);
                }
            }
        }
        return result;
    }
}
