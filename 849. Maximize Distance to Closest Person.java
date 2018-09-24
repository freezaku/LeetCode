class Solution {
    public int maxDistToClosest(int[] seats) {
        int prev = -1, cur = 0; // prev记录之前出现的1的位置
        int max = 0, n = seats.length;
        for (int i=0; i < n; i++) {
            if (seats[i] == 1) {
                if (prev == -1) { // i之前没有出现过1
                    max = Math.max(i, max); // 距离是i到0的距离
                } else { // i之前出现过1，那么maxDistance就是两个1距离的一半
                    max = Math.max((i - prev)/2, max);
                }
                
                prev = i;
            }
        }
        max = Math.max(max, n - prev - 1);
        return max;
    }
}