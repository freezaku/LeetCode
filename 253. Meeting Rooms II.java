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
    public int minMeetingRooms(Interval[] intervals) {
        if(intervals == null || intervals.length == 0)  return 0;
        
        int[] starts = new int[intervals.length];
        int[] ends = new int[intervals.length];
        for(int i = 0; i < intervals.length; i ++) {
            starts[i] = intervals[i].start;
            ends[i] = intervals[i].end;
        }
        Arrays.sort(starts);
        Arrays.sort(ends);
        
        int count = 0;
        int index = 0;
        for(int i = 0; i < intervals.length; i ++) {
            if(starts[i] < ends[index]) {
                count ++;
            } else {
                index ++;
            }
        }
        
        return count;
    }
}

/*
有start和end数组，
当start[i] < end[indexEnd]的时候，要不断把rooms++，因为此时这些interval都在这个end[indexEnd]之前开始了，
直到start[i] >= end[indexEnd]的时候，说明这个start time在end之后开始，
把endIndex和start的i均 ++，相当于腾出了一个room，然后再进行判断。
*/

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
    public int minMeetingRooms(Interval[] intervals) {
        if(intervals == null || intervals.length == 0)  return 0;
        
        Arrays.sort(intervals, (a, b) -> (a.start - b.start));
        PriorityQueue<Interval> pq = new PriorityQueue<Interval>(intervals.length, (a, b) -> (a.end - b.end));
        
        int count = 0;
        for(int i = 0; i < intervals.length; i ++) {
            if(!pq.isEmpty() && intervals[i].start >= pq.peek().end) {
                pq.poll();
            }
            pq.offer(intervals[i]);
            count = Math.max(count, pq.size());
        }
        
        return count;
    }
}

/*
利用pq来解决。
intervals数组按照start排序，pq按照end排序。
遍历intervals，pq.peek必然拥有最小的end，因此当当前interval的start 大于 该peek的end的时候，
直接将该peek给poll出来，
然后将该interval加入进去，
每次track pq的size来得到最大的count
*/