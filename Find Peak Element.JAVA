class Solution {
    /**
     * @param A: An integers array.
     * @return: return any of peek positions.
     */
    public int findPeak(int[] A) {
        // write your code here
        int n = A.length;
        int lo = 0;
        int hi = n - 1;
        while(lo + 1 < hi) {
            int mid = lo + (hi - lo) / 2;
            if(mid > 0 && mid < n - 1 && A[mid] > A[mid - 1] && A[mid] > A[mid + 1]) {
                return mid;
            } else if(mid > 0 && A[mid] > A[mid - 1]) {
                lo = mid;
            } else {
                hi = mid;
            }
        }
        
        return (A[lo] > A[hi]) ? lo : hi;
    }
}
/*
简单Binary Search问题
*/