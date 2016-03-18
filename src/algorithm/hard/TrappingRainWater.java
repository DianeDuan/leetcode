package algorithm.hard;

/**
 * Problem:
 * No: 42
 * Link: https://leetcode.com/problems/trapping-rain-water/
 * <p/>
 * Analysis:
 * The amount of water that can be trapped in the ith bar is the area of a rectangle.
 * Each rectangle's width is 1(the width of each bar).
 * The rectangle's height is the difference between x and this bar's height,
 * and x is the height of the shorter one of the two highest bars in the left and in the right of current bar.
 */
public class TrappingRainWater {
    public int trap(int[] height) {
        if (height == null || height.length < 3) {
            return 0;
        }

        int water = 0;
        int[] leftHighestHeights = initLeftHighestHeights(height);
        int[] rightHighestHeight = initRightHighestHeights(height);
        for (int i = 1; i < height.length - 1; i++) {
            water += Math.max(0, Math.min(leftHighestHeights[i], rightHighestHeight[i]) - height[i]);
        }
        return water;
    }

    private int[] initLeftHighestHeights(int[] height) {
        if (height == null || height.length == 0) {
            return new int[0];
        }

        int[] leftHighestHeights = new int[height.length];
        for (int i = 1; i < height.length; i++) {
            leftHighestHeights[i] = Math.max(leftHighestHeights[i - 1], height[i - 1]);
        }
        return leftHighestHeights;
    }

    private int[] initRightHighestHeights(int[] height) {
        if (height == null || height.length == 0) {
            return new int[0];
        }

        int[] rightHighestHeights = new int[height.length];
        for (int i = height.length - 2; i > -1; i--) {
            rightHighestHeights[i] = Math.max(rightHighestHeights[i + 1], height[i + 1]);
        }
        return rightHighestHeights;
    }
}
