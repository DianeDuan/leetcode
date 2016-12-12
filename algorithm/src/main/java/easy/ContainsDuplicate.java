package easy;

import java.util.HashSet;
import java.util.Set;

/**
 * Problem:
 * No: 217
 * Link: https://leetcode.com/problems/contains-duplicate/
 * <p/>
 * Analysis:
 * Traverse the array and use a set to record the numbers.
 * Before add the number into the set,
 * check if current number is already in the set,
 * if so, that means the array contains duplicates,
 * if not, add the number into the set to record its occurrence and continue.
 */
public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        if (nums == null) {
            return false;
        }

        Set<Integer> record = new HashSet<Integer>();
        for (int num : nums) {
            if (!record.contains(num)) {
                record.add(num);
            } else {
                return true;
            }
        }

        return false;
    }
}
/*
Set<Integer> hm=new HashSet<Integer>();
    if (nums.length==0)
    {
        return false;
    }
    int size=nums.length;
    for (int i = 0; i < size; i++)
    {
        if (!hm.contains(nums[i]))
        {
            hm.add(nums[i]);
        }
        else
        {
            return true;
        }
    }
    return false;

 */
