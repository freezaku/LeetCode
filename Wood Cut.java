public class Solution {
    /** 
     *@param L: Given n pieces of wood with length L[i]
     *@param k: An integer
     *return: The maximum length of the small pieces.
     */
    public int woodCut(int[] L, int k) {
        // write your code here
        if(L == null || L.length == 0)  return 0;
        
        int start = 1;
        int end = L[0];
        for(int len: L) {
            end = Math.max(end, len);
        }
        
        while(start <= end) {
            int mid = start + (end - start) / 2;
            if(count(mid, L) >= k) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        
        return end;
    }
    
    private int count(int limit, int[] L) {
        int res = 0;
        for(int len: L) {
            res += len / limit;
        }
        return res;
    }
}

/*
将优化问题转化为可行性问题，
确定这个长度的范围，从1到L中的最大值，
用二分不断获取可能值，判定该可能值是否可行，再缩小范围
*/