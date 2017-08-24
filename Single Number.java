Given 2*n + 1 numbers, every numbers occurs twice except one, find it.

Have you met this question in a real interview? Yes
Example
Given [1,2,2,1,3,4,3], return 4

public class Solution {
    /*
     * @param A: An integer array
     * @return: An integer
     */
    public int singleNumber(int[] A) {
        // write your code here
        if(A == null || A.length == 0)  return 0;
        
        int res = A[0];
        for(int i = 1; i < A.length; i ++) {
            res ^= A[i];
        }
        return res;
    }
}

/*
简单题
*/