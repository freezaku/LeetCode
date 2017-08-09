/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> res = new ArrayList<>();
        int newStart = newInterval.start;
        int newEnd = newInterval.end;
        
        int index = 0;
        while(index < intervals.size()) {
            Interval interval = intervals.get(index);
            if(interval.end < newStart) {
                res.add(interval);
                index ++;
            } else {
                newStart = Math.min(interval.start, newStart);
                break;
            }
        }
        
        if(index == intervals.size()) {
            res.add(newInterval);
            return res;
        }
        
        while(index < intervals.size()) {
            Interval interval = intervals.get(index);
            if(interval.start <= newEnd) {
                newEnd = Math.max(interval.end, newEnd);
                index ++;
            } else {
                break;
            }
        }
        
        res.add(new Interval(newStart, newEnd));
        
        while(index < intervals.size()) {
            res.add(intervals.get(index));
            index ++;
        }
        
        return res;
    }
}

/*
简单array题重做，画图注意取值范围即可。
*/