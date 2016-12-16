package easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem:
 * No: 401
 * Link: https://leetcode.com/problems/binary-watch/
 * <p>
 * Analysis:
 * Calculate different combinations of hour lights count and minute lights count.
 */
public class BinaryWatch {
    public List<String> readBinaryWatch(int num) {
        if (num < 0) {
            return new ArrayList<>();
        }

        int hourLightCount = 4;
        int minuteLightCount = 6;
        List<String> result = new ArrayList<>();
        for (int i = 0; i <= Math.min(hourLightCount, num); i++) {
            List<Integer> hours = calcPossibleTime(i, hourLightCount);
            List<Integer> minutes = calcPossibleTime(num - i, minuteLightCount);
            List<String> composedTimes = composeTime(hours, minutes);
            result.addAll(composedTimes);
        }
        return result;
    }

    private List<Integer> calcPossibleTime(int onCount, int lightCount) {
        if (onCount < 0 || onCount > lightCount) {
            return new ArrayList<>();
        }

        List<Integer> result = new ArrayList<>();
        if (onCount == 0) {
            result.add(0);
        } else {
            List<Integer> otherLightsValues1 = calcPossibleTime(onCount - 1, lightCount - 1);
            for (int val : otherLightsValues1) {
                result.add((1 << (lightCount - 1)) + val);
            }

            List<Integer> otherLightsValues2 = calcPossibleTime(onCount, lightCount - 1);
            for (int val : otherLightsValues2) {
                result.add(val);
            }
        }
        return result;
    }

    private List<String> composeTime(List<Integer> hours, List<Integer> minutes) {
        if (hours == null || minutes == null || hours.size() == 0 || minutes.size() == 0) {
            return new ArrayList<>();
        }

        List<String> result = new ArrayList<>();
        for (int hour : hours) {
            if (hour > 11) {// hour value's range is [0, 11]
                continue;
            }
            String hourStr = String.valueOf(hour);
            for (int minute : minutes) {
                if (minute > 59) {// minute value's range is [0, 59]
                    continue;
                }
                String minStr = (minute < 10) ? ("0" + minute) : String.valueOf(minute);
                result.add(hourStr + ":" + minStr);
            }
        }
        return result;
    }
}
