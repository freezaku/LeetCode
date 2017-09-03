/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
    public boolean canAttendMeetings(Interval[] intervals) {
        if(intervals == null || intervals.length <= 1)  return true;
        
        Arrays.sort(intervals, new Comparator<Interval>(){
            public int compare(Interval a, Interval b) {
                if(a.start != b.start) {
                    return a.start - b.start;
                } else {
                    return a.end - b.end;
                }
            }
        });
        
        int end = intervals[0].end;
        for(int i = 1; i < intervals.length; i ++) {
            Interval interval = intervals[i];
            if(interval.start < end) {
                return false;
            }
            end = Math.max(end, interval.end);
        }
        
        return true;
    }
}

/*
利用sort排序解决就行, 自写一个comparator的方法。
track一个end变量，不断比较判断更新。
*/