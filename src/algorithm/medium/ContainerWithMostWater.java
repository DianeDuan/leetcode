package algorithm.medium;

/**
 * Problem:
 * No: 11
 * Link: https://leetcode.com/problems/container-with-most-water/
 * <p/>
 * Analysis:
 * The max width is between the first line and the last line,
 * and the shorter height of the two lines determines the height of container's valid area.
 * So initiate maximum area by the area between the first line and the last line,
 * and then every time move the pointer of the shorter line to find bigger container,
 * because move the pointer of the longer line will only decrease the width
 * but won't increase the valid height which equals to the shorter line.
 * <p/>
 * Reference:
 * https://segmentfault.com/a/1190000003815582
 */
public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }

        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;
        while (left < right) {
            maxArea = Math.max(maxArea, (right - left) * Math.min(height[left], height[right]));
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }
}
