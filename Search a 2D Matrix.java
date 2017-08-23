public class Solution {
    /*
     * @param matrix: matrix, a list of lists of integers
     * @param target: An integer
     * @return: a boolean, indicate whether matrix contains target
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        // write your code here
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0)   return false;
        
        int m = matrix.length;
        int n = matrix[0].length;
        
        if(target < matrix[0][0] || target > matrix[m - 1][n - 1])  return false;
        int lo = 0;
        int hi = m * n - 1;
        while(lo + 1 < hi) {
            int mid = lo + (hi - lo) / 2;
            int x = mid / n;
            int y = mid % n;
            if(matrix[x][y] == target) {
                return true;
            } else if(matrix[x][y] > target) {
                hi = mid;
            } else {
                lo = mid;
            }
        }
        
        if(matrix[lo / n][lo % n] == target || matrix[hi / n][hi % n] == target) {
            return true;
        } else {
            return false;
        }
    }
}

/*
简单binary search
*/