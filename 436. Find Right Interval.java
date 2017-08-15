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
    public int[] findRightInterval(Interval[] intervals) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> starts = new ArrayList<>();
        
        for(int i = 0; i < intervals.length; i ++) {
            map.put(intervals[i].start, i);
            starts.add(intervals[i].start);
        }
        
        Collections.sort(starts);
        
        int[] res = new int[intervals.length];
        for(int i = 0; i < intervals.length; i ++) {
            int end = intervals[i].end;
            int start = helper(starts, end);
            if(start < end) {
                res[i] = -1;
            } else {
                res[i] = map.get(start);
            }
        }
        
        return res;
    }
    
    // find the smallest num in starts which is bigger than end
    private int helper(List<Integer> starts, int end) {
        int lo = 0;
        int hi = starts.size() - 1;
        while(lo + 1 < hi) {
            int mid = lo + (hi - lo) / 2;
            if(starts.get(mid) == end) {
                return starts.get(mid);
            } else if(starts.get(mid) < end) {
                lo = mid;
            } else {
                hi = mid;
            }
        }
        
        if(starts.get(lo) >= end) {
            return starts.get(lo);
        } else {
            return starts.get(hi);
        }
    }
}

/*
利用starts来存储并排序所有interval的start，
利用map来存储start和index的关系，
遍历intervals的每个元素，对于每个元素的end，利用binary search在starts中寻找比该end大的最小start，
这个start在map中对应的index就是我们需要的right index。

注意binary search的写法。
*/