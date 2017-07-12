public class Solution {
    public int findMinDifference(List<String> timePoints) {
        int[] times = new int[timePoints.size()];
        for(int i = 0; i < timePoints.size(); i ++) {
            String str = timePoints.get(i);
            int h = Integer.valueOf(str.substring(0, 2)) * 60;
            int m = Integer.valueOf(str.substring(3, 5));
            times[i] = h + m;
        }
        int min = Integer.MAX_VALUE;
        Arrays.sort(times);
        for(int i = 1; i < times.length; i ++) {
            min = Math.min(min, times[i] - times[i - 1]);
        }
        int corner = times[0] + (24 * 60 - times[times.length - 1]);
        return Math.min(min, corner);
    }
}

/*
简单题，转化后排序即可，
注意一个corner case，就是跨天的情况
*/