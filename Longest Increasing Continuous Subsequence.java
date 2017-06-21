Give an integer array，find the longest increasing continuous subsequence in this array.

An increasing continuous subsequence:

Can be from right to left or from left to right.
Indices of the integers in the subsequence should be continuous.
 Notice

O(n) time and O(1) extra space.

Have you met this question in a real interview? Yes
Example
For [5, 4, 2, 1, 3], the LICS is [5, 4, 2, 1], return 4.

For [5, 1, 2, 3, 4], the LICS is [1, 2, 3, 4], return 4.

public class Solution {
    /**
     * @param A an array of Integer
     * @return  an integer
     */
    public int longestIncreasingContinuousSubsequence(int[] A) {
        // Write your code here
        if(A == null || A.length == 0)  return 0;
        int[] left = new int[A.length];
        left[0] = 1;
        int res = 1;
        for(int i = 1; i < A.length; i ++) {
            left[i] = A[i] > A[i - 1] ? left[i - 1] + 1 : 1;
            res = Math.max(left[i], res);
        }
        int[] right = new int[A.length];
        right[A.length - 1] = 1;
        for(int i = A.length - 2; i >= 0; i --) {
            right[i] = A[i] > A[i + 1] ? right[i + 1] + 1 : 1;
            res = Math.max(right[i], res);
        }
        
        return res;
    }
}