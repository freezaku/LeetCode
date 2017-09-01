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
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> res = new ArrayList<>();
        if(intervals == null || intervals.size() == 0)  return res;
        
        Collections.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval a, Interval b) {
                if(a.start == b.start) {
                    return a.end - b.end;
                } else {
                    return a.start - b.start;
                }
            } 
        });
        
        int n = intervals.size();
        int index = 0;
        while(index < n) {
            int start = intervals.get(index).start;
            int end = intervals.get(index).end;
            index ++;
            while(index < n && intervals.get(index).start <= end) {
                end = Math.max(end, intervals.get(index).end);
                index ++;
            }
            System.out.println(start + " " + end);
            res.add(new Interval(start, end));
        }
        
        return res;
    }
}

/*
简单题。
画图弄清楚merge产生的interval的start和end的变化关系即可。
*/