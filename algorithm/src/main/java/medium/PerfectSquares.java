package medium;

/**
 * Problem:
 * No: 279
 * Link: https://leetcode.com/problems/perfect-squares/
 * <p/>
 * Analysis:
 * <p/>
 * Solution1:
 * Dynamic programming solution.
 * <p/>
 * Solution2:
 * Lagrange's four-square theorem solution.
 * <p/>
 * Reference:
 * https://leetcode.com/discuss/58056/summary-of-different-solutions-bfs-static-and-mathematics
 */
public class PerfectSquares {
    public int numSquaresSolution1(int n) {
        if (n < 0) {
            return 0;
        }

        int[] minCounts = initMaxValueArray(n + 1);
        minCounts[0] = 0;
        for (int i = 1; i < (n + 1); i++) {
            for (int j = (int) Math.sqrt(i); j > 0; j--) {
                minCounts[i] = Math.min(minCounts[i - j * j] + 1, minCounts[i]);
            }
        }
        return minCounts[n];
    }

    public int numSquaresSolution2(int n) {
        // If n is a perfect square, return 1.
        if (isSquare(n)) {
            return 1;
        }

        // The result is 4 if and only if n can be written in the
        // form of 4^k*(8*m + 7). Please refer to
        // Legendre's three-square theorem.
        while ((n & 3) == 0) {// n%4 == 0
            n >>= 2;
        }
        if ((n & 7) == 7) { // n%8 == 7
            return 4;
        }

        // Check whether 2 is the result.
        for (int i = 1; i <= (int) (Math.sqrt(n)); i++) {
            if (isSquare(n - i * i)) {
                return 2;
            }
        }

        return 3;
    }

    private int[] initMaxValueArray(int n) {
        if (n <= 0) {
            return new int[0];
        }

        int[] array = new int[n];
        for (int i = 0; i < array.length; i++) {
            array[i] = Integer.MAX_VALUE;
        }
        return array;
    }

    private boolean isSquare(int n) {
        if (n < 0) {
            return false;
        }

        int sqrtNum = (int) Math.sqrt(n);
        return sqrtNum * sqrtNum == n;
    }
}
