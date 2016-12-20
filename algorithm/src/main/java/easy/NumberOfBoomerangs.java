package easy;

/**
 * Problem:
 * No: 447
 * Link: https://leetcode.com/problems/number-of-boomerangs/
 * <p>
 * Analysis:
 * Use every point as the i point, calculate the distances between it and every other point
 * to find how many pairs of other points are in the same distance to it.
 * The total count of pairs multiply 2 is the number of boomerangs,
 * since the two points of a pair can exchange their positions.
 */
public class NumberOfBoomerangs {
    public int numberOfBoomerangs(int[][] points) {
        if (points == null || points.length == 0) {
            return 0;
        }

        int result = 0;
        for (int i = 0; i < points.length; i++) {
            int[] distanceSquares = calcDistanceSquares(points, i);
            int sameDistancePairCount = countSameDistancePair(distanceSquares, i);
            result += sameDistancePairCount;
        }
        return result * 2;
    }

    private int[] calcDistanceSquares(int[][] points, int iPointIdx) {
        int[] distanceSquares = new int[points.length];
        for (int i = 0; i < points.length; i++) {
            if (i == iPointIdx) {
                distanceSquares[i] = 0;
            } else {
                int x = Math.abs(points[i][0] - points[iPointIdx][0]);
                int y = Math.abs(points[i][1] - points[iPointIdx][1]);
                int distanceSquare = x * x + y * y;
                distanceSquares[i] = distanceSquare;
            }
        }
        return distanceSquares;
    }

    private int countSameDistancePair(int[] distanceSquares, int iPointIdx) {
        int count = 0;
        for (int i = 0; i < distanceSquares.length - 1; i++) {
            if (i == iPointIdx) {
                continue;
            }
            for (int j = i + 1; j < distanceSquares.length; j++) {
                if (distanceSquares[i] == distanceSquares[j]) {
                    count++;
                }
            }
        }
        return count;
    }
}
