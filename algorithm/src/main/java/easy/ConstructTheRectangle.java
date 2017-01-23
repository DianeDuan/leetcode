package easy;

/**
 * Problem:
 * No: 492
 * Link: https://leetcode.com/problems/construct-the-rectangle/
 * <p>
 * Analysis:
 * To get closest length, width pair, start from the square root of area.
 * Increase the length until get an integer width.
 */
public class ConstructTheRectangle {
    public int[] constructRectangle(int area) {
        int length = (int) Math.sqrt(area);
        int width = area / length;
        while ((width * length) != area) {
            length++;
            width = area / length;
        }

        if (length >= width) {
            return new int[]{length, width};
        } else {
            return new int[]{width, length};
        }
    }
}
