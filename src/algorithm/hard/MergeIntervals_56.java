package algorithm.hard;

import algorithm.vo.Interval;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Problem:
 * https://leetcode.com/problems/merge-intervals/
 * <p/>
 * Analysis:
 * Sort intervals by their start times first.
 * And the merge the sorted intervals list from front to back.
 * <p/>
 * Reference:
 * http://www.cnblogs.com/springfor/p/3872332.html
 */
public class MergeIntervals_56 {
    public List<Interval> merge(List<Interval> intervals) {
        if (intervals == null || intervals.size() <= 1) {
            return intervals;
        }

        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });

        List<Interval> result = new ArrayList<Interval>();
        Interval previous = intervals.get(0);
        for (int i = 1; i < intervals.size(); i++) {
            Interval current = intervals.get(i);
            if (previous.end >= current.start) {
                previous = new Interval(previous.start, Math.max(previous.end, current.end));
            } else {
                result.add(new Interval(previous.start, previous.end));
                previous = current;
            }
        }
        result.add(previous);
        return result;
    }
}
