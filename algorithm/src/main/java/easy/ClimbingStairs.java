package algorithm.easy;

/**
 * Problem:
 * No: 70
 * Link: https://leetcode.com/problems/climbing-stairs/
 * <p/>
 * Analysis:
 * This problem is similar to Fibonacci sequence.
 * <p/>
 * Reference:
 * http://blog.csdn.net/kenden23/article/details/17377869
 */
public class ClimbingStairs {
    public int climbStairsSolution1(int n) {
        if (n <= 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        return climbStairsSolution1(n - 1) + climbStairsSolution1(n - 2);
    }

    public int climbStairsSolution2(int n) {
        if (n <= 0) {
            return 0;
        }
        if (n <= 2) {
            return n;
        }

        int[] countOfWays = new int[n + 1];
        countOfWays[0] = 0;
        countOfWays[1] = 1;
        countOfWays[2] = 2;
        for (int i = 3; i <= n; i++) {
            countOfWays[i] = countOfWays[i - 1] + countOfWays[i - 2];
        }
        return countOfWays[n];
    }
}
