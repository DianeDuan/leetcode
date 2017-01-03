package hard;

import provided.vo.Interval;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem:
 * No: 57
 * Link: https://leetcode.com/problems/insert-interval/
 * <p/>
 * Analysis:
 * Traver the internals list.
 * Add non-overlapping interval to the result directly.
 * Merge overlapping interval and add merged interval at last.
 * <p/>
 * Reference:
 * http://www.jiuzhang.com/solutions/insert-interval/
 */
public class InsertInterval {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        if (newInterval == null || intervals == null) {
            return intervals;
        }

        List<Interval> results = new ArrayList<Interval>();
        int insertPos = 0;
        for (Interval interval : intervals) {
            if (interval.end < newInterval.start) {//current interval is before newInterval
                results.add(interval);
                insertPos++;
            } else if (interval.start > newInterval.end) {//current interval is after newInterval
                results.add(interval);
            } else {//current interval overlaps newInterval
                newInterval.start = Math.min(interval.start, newInterval.start);
                newInterval.end = Math.max(interval.end, newInterval.end);
            }
        }
        results.add(insertPos, newInterval);
        return results;
    }
}
