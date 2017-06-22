Give you an integer matrix (with row size n, column size m)，find the longest increasing continuous subsequence in this matrix. (The definition of the longest increasing continuous subsequence here can start at any row or column and go up/down/right/left any direction).

Have you met this question in a real interview? Yes
Example
Given a matrix:

[
  [1 ,2 ,3 ,4 ,5],
  [16,17,24,23,6],
  [15,18,25,22,7],
  [14,19,20,21,8],
  [13,12,11,10,9]
]
return 25



public class Solution {
    /**
     * @param A an integer matrix
     * @return  an integer
     */
    public int longestIncreasingContinuousSubsequenceII(int[][] A) {
        // Write your code here
        if(A == null || A.length == 0 || A[0].length == 0)  return 0;
        int rows = A.length;
        int cols = A[0].length;
        int[][] dp = new int[rows][cols];
        int max = 0;
        
        for(int i = 0; i < rows; i ++) {
            for(int j = 0; j < cols; j ++) {
                max = Math.max(max, memorizeSearch(i, j, rows, cols, dp, A));
            }
        }
        
        return max;
    }
    
    private int memorizeSearch(int x, int y, int rows, int cols, int[][] dp, int[][] A) {
        if(dp[x][y] != 0)  return dp[x][y];
        
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        int maxLen = 1;
        for(int i = 0; i < 4; i ++) {
            int xx = x + dx[i];
            int yy = y + dy[i];
            if(xx < 0 || xx >= rows || yy < 0 || yy >= cols || A[xx][yy] <= A[x][y])   continue;
            int len = memorizeSearch(xx, yy, rows, cols, dp, A) + 1;
            maxLen = Math.max(maxLen, len);
        }
        
        dp[x][y] = maxLen;
        return maxLen;
    }
}