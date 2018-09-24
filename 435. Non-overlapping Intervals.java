1. sort + 遍历
time: O(NlogN)
space: O(1)
/*
计算有多少个max non overlap的interval
*/

class Solution {
    public int eraseOverlapIntervals(Interval[] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }
        // 根据end来sort，这样end小的就在前面，end大的在后面
        // 如果下一个的start和当前的end不重合的话，那说明下一个interval可以作为next non overlap区间
        int countNonOverlap = 1;
        Arrays.sort(intervals, new Comparator<Interval>(){
           public int compare(Interval i1, Interval i2) {
               return i1.end - i2.end;
           } 
        });
        int end = intervals[0].end;
        for (int i=1; i < intervals.length; i++) {
            // 找与之前的end不重合的start，如果有的话，整个intervals的non overlap interval又多了一个
            if (intervals[i].start >= end) {
                end = intervals[i].end;
                countNonOverlap++;
            }
        }
        return intervals.length - countNonOverlap;
    }
}


2. DP
time: O(N^2)
space: O(N)
/*
和同样的思想，时间复杂度和空间复杂度更高
*/

class Solution {
    public int eraseOverlapIntervals(Interval[] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }
        
        Arrays.sort(intervals, new Comparator<Interval>(){
            public int compare(Interval i1, Interval i2) {
                return i1.start - i2.start;
            }
        });
        int[] dp = new int[intervals.length]; // 如果不重合的话，ith的时候，可以最大保留多少个interval
        dp[0] = 1;
        int res = 1;
        for (int i=1; i < intervals.length; i++) {
            int max = 0;
            for (int j=i-1; j>=0; j--) {
                if (intervals[j].end <= intervals[i].start) {
                    max = Math.max(dp[j], max);
                }
            }
            dp[i] = max + 1;
            res = Math.max(res, dp[i]);
        }
        
        return intervals.length - res;
    }
}