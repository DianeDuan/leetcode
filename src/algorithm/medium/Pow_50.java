package algorithm.medium;

/**
 * Problem:
 * https://leetcode.com/problems/powx-n/
 * <p/>
 * Analysis:
 * Recursive solution.
 * <p/>
 * Reference:
 * http://www.cnblogs.com/springfor/p/3870929.html
 * https://gist.github.com/luoxiaoxun/5882749
 */
public class Pow_50 {
    public double myPow(double x, int n) {
        if (n == 0) {
            return 1.0;
        }
        double half = myPow(x, n / 2);
        if (n % 2 == 0) {
            return half * half;
        } else if (n > 0) {
            return half * half * x;
        } else {
            return half * half / x;
        }
    }
}
