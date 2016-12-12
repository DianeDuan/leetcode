package easy;

/**
 * Problem:
 * No: 223
 * Link: https://leetcode.com/problems/rectangle-area/
 * <p/>
 * Analysis:
 * If there is no cross area, the result should be the sum of two rectangles' areas.
 * If there is cross area, the result should be the sum of two rectangles' areas minus cross area.
 * <p/>
 * Reference:
 * http://www.cnblogs.com/grandyang/p/4563153.html
 */
public class RectangleArea {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int area1 = (C - A) * (D - B);
        int area2 = (G - E) * (H - F);

        if (E >= C || F >= D || B >= H || A >= G) {
            return area1 + area2;
        } else {
            int crossArea = (Math.min(G, C) - Math.max(A, E)) * (Math.min(D, H) - Math.max(B, F));
            return area1 + area2 - crossArea;
        }
    }
}
