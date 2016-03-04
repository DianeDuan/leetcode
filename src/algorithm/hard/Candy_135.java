package algorithm.hard;

/**
 * Problem:
 * https://leetcode.com/problems/candy/
 * <p/>
 * Analysis:
 * Similar to the "Trapping Rain Water" problem.
 */
public class Candy_135 {
    public int candy(int[] ratings) {
        if (ratings == null || ratings.length == 0) {
            return 0;
        }

        int[] left = initLeftLeast(ratings);
        int[] right = initRightLeast(ratings);
        int sum = 0;
        for (int i = 0; i < ratings.length; i++) {
            sum += Math.max(left[i], right[i]);
        }
        return sum;
    }

    private int[] initLeftLeast(int[] ratings) {
        if (ratings == null || ratings.length == 0) {
            return new int[0];
        }

        int[] result = new int[ratings.length];
        result[0] = 1;
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                result[i] = result[i - 1] + 1;
            } else {
                result[i] = 1;
            }
        }
        return result;
    }

    private int[] initRightLeast(int[] ratings) {
        if (ratings == null || ratings.length == 0) {
            return new int[0];
        }

        int[] result = new int[ratings.length];
        result[ratings.length - 1] = 1;
        for (int i = ratings.length - 2; i > -1; i--) {
            if (ratings[i] > ratings[i + 1]) {
                result[i] = result[i + 1] + 1;
            } else {
                result[i] = 1;
            }
        }
        return result;
    }
}

