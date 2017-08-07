public class Solution {
    public int mySqrt(int x) {
        if(x == 0)  return 0;
        int lo = 1;
        int hi = x;
        while(lo + 1 < hi) {
            int mid = lo + (hi - lo) / 2;
            if(x / mid == mid) {
                return mid;
            } else if(x / mid > mid) {
                lo = mid;
            } else {
                hi = mid;
            }
        }
        
        if(x / hi == hi) {
            return hi;
        } else {
            return lo;
        }
    }
}

/*
二分法，利用 x / mid == mid的判断可以消除overflow，
同时注意while循环结束后的结果选取和判断
*/