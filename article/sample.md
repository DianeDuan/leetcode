# Problem

## Problem Link

https://leetcode.com/problems/find-the-duplicate-number/

## Problem Content

Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive), prove that at least one duplicate number must exist. 

Assume that there is only one duplicate number, find the duplicate one.

## Note

1. You must not modify the array (assume the array is read only).

2. You must use only constant, O(1) extra space.

3. Your runtime complexity should be less than O(n2).

4. There is only one duplicate number in the array, but it could be repeated more than once.

# Solutions

Proving that in an array which contains n + 1 integers and each integer is between 1 and n,
at least one duplicate number exists is easy, just use the pigeonhole principle.

The solutions below are for finding the only duplicate number in the array.

## Binary search solution

### Analysis

According to the Pigeonhole Principle, 
if all the integers are between 1 and k, and there is no duplicate,
the count of these numbers must be less than k.

In this problem, that duplicate number partition the array into three parts:
the first part is composed of the integers which are less than the duplicate number and has no duplicate,
the second part is composed of the integers which are greater than the duplicate number and has no duplicate,
and the third part is composed of the duplicate integers.

So this problem turns into a variation of the common binary search.
Choose a k (k plays the same role as the mid element in the common binary search).
Get the count of integers in the whole array which are less than or equal to k.
If the count is less than or equals to k, it indicates the duplicate is greater than k,
and if the count is greater than k, the duplicate should be less than or equals to k.
Change the top and bottom values accordingly and at last the duplicate will be found.

To count how many elements are less than or equal to a given k, 
we need to traverse the whole array.
and the time complexity of this is O(N).
Since this is a binary search, the count of loops is logN.
So this solution's time complexity is O(NlogN).
As in this solution no extra space is used, 
this solution's space complexity is O(1).

### Code

    public int findDuplicate(int[] nums) {
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

## Circle Detection solution

### Analysis

Define a new list whose name is y. Here is the rule to generate this list's nodes:

y[0] = 0, y[1] = nums[y[0]], y[2] = nums[y[1]], ..., y[t] = nums[y[t-1]].

If the nums array has duplicates, there must be a cycle in this list,
and the duplicate must be the start of the cycle.

For example, if the nums array is {1, 2, 4, 3, 1}, 
the process of generating the list is like this:

y[0] = 0, y[1] = 1, y[2] = 2, y[3] = 4, y[4] = 1, y[5] = 2, y[6] = 4, y[7] = 1, ...    

There is a cycle composed of 1, 2, 4 and the start of cycle is the duplicate number 1.

So this problem turns into finding the start of the cycle in a list problem, 
which is called cycle detection problem.
There are several algorithms of cycle detection,
I choose Floyd's cycle-finding algorithm,
which usually use a fast pointer and a slow pointer, to solve it. 

This solution will traverse the array approximately twice to find the start of the cycle,
so the time complexity is O(n).
And this solution needs only two integers for the fast pointer and the slow pointer,
so the space complexity is O(1).

### Code

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

# References

https://github.com/franklingu/leetcode-solutions/blob/master/algorithms/find-the-duplicate-number/Solution.java

https://segmentfault.com/a/1190000003817671#articleHeader15

# External Links

[Pigeonhole Principle](https://en.wikipedia.org/wiki/Pigeonhole_principle)

[Cycle Detection](https://en.wikipedia.org/wiki/Cycle_detection)