public class Solution {
    public int hIndex(int[] citations) {
        if(citations == null || citations.length == 0)  return 0;
        
        int n = citations.length;
        int lo = 0;
        int hi = n - 1;
        while(lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int count = n - mid;
            if(citations[mid] == count) {
                return count;
            } else if(citations[mid] > count) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        
        return n - lo;
    }
}

/*
直接二分法求解
*/