public class Solution {
    /** 
     *@param A: A list of integers
     *@param elem: An integer
     *@return: The new length after remove
     */
    public int removeElement(int[] A, int elem) {
        // write your code here
        if(A == null || A.length == 0)    return 0;
        
        int index = 0;
        for(int i = 0; i < A.length; i ++) {
            if(A[i] != elem) {
                A[index ++] = A[i];
            }
        }
        
        return index;
    }
}
/*
简单题
*/