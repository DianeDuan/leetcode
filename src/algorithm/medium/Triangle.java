package algorithm.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem:
 * No: 120
 * Link: https://leetcode.com/problems/triangle/
 * <p/>
 * Analysis:
 * Dynamic programming solution.
 */
public class Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) {
            return 0;
        }

        List<List<Integer>> dp = new ArrayList<List<Integer>>();
        List<Integer> topRow = new ArrayList<Integer>();
        topRow.add(triangle.get(0).get(0));
        dp.add(topRow);
        for (int i = 1; i < triangle.size(); i++) {
            List<Integer> upperRow = dp.get(i - 1);
            List<Integer> currentRow = new ArrayList<Integer>();
            currentRow.add(upperRow.get(0) + triangle.get(i).get(0));
            for (int j = 1; j < i; j++) {
                currentRow.add(Math.min(upperRow.get(j), upperRow.get(j - 1)) + triangle.get(i).get(j));
            }
            currentRow.add(upperRow.get(i - 1) + triangle.get(i).get(i));//the last element of every row has only one upper adjacent element
            dp.add(currentRow);
        }
        return min(dp.get(dp.size() - 1));
    }

    private int min(List<Integer> list) {
        if (list == null || list.size() == 0) {
            return 0;
        }

        int min = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            min = Math.min(min, list.get(i));
        }
        return min;
    }
}
