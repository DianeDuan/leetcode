package medium;

/**
 * Problem:
 * No: 495
 * Link: https://leetcode.com/problems/teemo-attacking/
 * <p>
 * Analysis:
 * Every time the attacking happens the total poisoned time should be added one duration,
 * if its time frame and last time's do not overlap.
 * And if they overlap,
 * the overlap part shouldn't be added into the total time.
 */
public class TeemoAttacking {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        if (timeSeries == null || timeSeries.length == 0 || duration <= 0) {
            return 0;
        }

        int result = duration;
        for (int i = 1; i < timeSeries.length; i++) {
            int lastStopTime = timeSeries[i - 1] + duration;
            int curDuration = duration;
            if (lastStopTime >= timeSeries[i]) {
                curDuration = (timeSeries[i] + duration) - lastStopTime;
            }
            result += curDuration;
        }
        return result;
    }
}
