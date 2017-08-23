Merge two given sorted integer array A and B into a new sorted integer array.

Have you met this question in a real interview? Yes
Example
A=[1,2,3,4]

B=[2,4,5,6]

return [1,2,2,3,4,4,5,6]

public class Solution {
    /*
     * @param A: sorted integer array A
     * @param B: sorted integer array B
     * @return: A new sorted integer array
     */
    public int[] mergeSortedArray(int[] A, int[] B) {
        // write your code here
        if(A == null || A.length == 0)  return B;
        if(B == null || B.length == 0)  return A;
        
        int m = A.length;
        int n = B.length;
        int i = 0;
        int j = 0;
        int[] res = new int[m + n];
        int index = 0;
        while(i < m && j < n) {
            if(A[i] < B[j]) {
                res[index ++] = A[i ++];
            } else {
                res[index ++] = B[j ++];
            }
        }
        
        while(i < m) {
            res[index ++] = A[i ++];
        }
        while(j < n) {
            res[index ++] = B[j ++];
        }
        
        return res;
    }
}