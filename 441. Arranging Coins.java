public class Solution {
    public int arrangeCoins(int n) {
        if(n == 0)  return 0;
        
        long lo = 0;
        long hi = n;
        long nn = (long)n;
        
        while(lo + 1 < hi) {
            long mid = lo + (hi - lo) / 2;
            long res = helper(mid);
            
            if(res == nn) {
                return (int)mid;
            } else if(res > nn) {
                hi = mid;
            } else {
                lo = mid;
            }
        }
        
        if(helper(hi) <= nn)  return (int)hi;
        return (int)lo;
    }
    
    private long helper(long mid) {
        return (1 + mid) * mid / 2;
    }
}

/*
注意越界问题，用long替代int进行计算
*/