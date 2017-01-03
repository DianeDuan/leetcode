package easy;

import java.util.Arrays;

/**
 * Problem:
 * No: 475
 * Link: https://leetcode.com/problems/heaters/
 * <p>
 * Analysis:
 * Find every house's left heater and right heater if they exist,
 * record the minimal one of the distances between the house and its left and right heater.
 * The maximal distance of these minimal distances is the heater radius.
 */
public class Heaters {
    public int findRadius(int[] houses, int[] heaters) {
        int[] minDistances = new int[houses.length];
        Arrays.sort(heaters);

        for (int i = 0; i < houses.length; i++) {
            int left = findLeftHeater(houses[i], heaters);
            int right = findRightHeater(houses[i], heaters);
            if (left >= 0) {
                minDistances[i] = houses[i] - left;
                if (right >= 0) {
                    minDistances[i] = Math.min(minDistances[i], right - houses[i]);
                }
            } else if (right >= 0) {
                minDistances[i] = right - houses[i];
            }
        }

        int radius = minDistances[0];
        for (int i = 1; i < houses.length; i++) {
            radius = Math.max(radius, minDistances[i]);
        }
        return radius;
    }

    private int findLeftHeater(int house, int[] heaters) {
        for (int i = heaters.length - 1; i >= 0; i--) {
            if (heaters[i] <= house) {
                return heaters[i];
            }
        }
        return -1;
    }

    private int findRightHeater(int house, int[] heaters) {
        for (int i = 0; i < heaters.length; i++) {
            if (heaters[i] >= house) {
                return heaters[i];
            }
        }
        return -1;
    }
}
