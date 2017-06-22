Given a 2D binary matrix filled with 0's and 1's, find the largest square which diagonal is all 1 and others is 0.

Have you met this question in a real interview? Yes
Example
For example, given the following matrix:

1 0 1 0 0
1 0 0 1 0
1 1 0 0 1
1 0 0 1 0
Return 9

public class Solution {
    /**
     * @param matrix a matrix of 0 and 1
     * @return an integer
     */
    public int maxSquare2(int[][] matrix) {
        // write your code here
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0)   return 0;
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] dp = new int[rows][cols];
        int[][] left = new int[rows][cols];
        int[][] top = new int[rows][cols];
        int max = 0;
        
        for(int i = 0; i < rows; i ++) {
            for(int j = 0; j < cols; j ++) {
                if(matrix[i][j] == 0) {
                    dp[i][j] = 0;
                    left[i][j] = 1;
                    top[i][j] = 1;
                    if(i > 0) {
                        top[i][j] = top[i - 1][j] + 1;
                    }
                    if(j > 0) {
                        left[i][j] = left[i][j - 1] + 1;
                    }
                } else {
                    left[i][j] = 0;
                    top[i][j] = 0;
                    if(i > 0 && j > 0) {
                        dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(left[i][j - 1], top[i - 1][j])) + 1;
                    } else {
                        dp[i][j] = 1;
                    }
                }
                max = Math.max(max, dp[i][j]);
            }
        }
        
        return max * max;
    }
}

/*
dp数组表示当前位置可以获得的最大符合要求的对角线长度，
left表示当前位置为止的，左边连续0的长度，
top表示当前位置为止的，上边连续0的长度；

遇到matrix为0的情况，dp为0， left和top跟据所在位置进行更新，
遇到matrix为1的情况，left和top置零，dp根据所在位置进行更新，
获取其左上方的dp和左边left和上边top的最小值加一；

记得最后需要将max*max得到面积
*/