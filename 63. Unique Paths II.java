public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0].length == 0) return 0;
        
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        
        if(obstacleGrid[0][0] == 1) return 0;
        
        dp[0][0] = 1;
        for(int i = 1; i < m; i ++) {
            dp[i][0] = (dp[i - 1][0] == 1 && obstacleGrid[i][0] == 0) ? 1 : 0;
        }
        for(int i = 1; i < n; i ++) {
            dp[0][i] = (dp[0][i - 1] == 1 && obstacleGrid[0][i] == 0) ? 1 : 0;
        }
        
        for(int i = 1; i < m; i ++) {
            for(int j = 1; j < n; j ++) {
                if(obstacleGrid[i][j] == 1) continue;
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        
        return dp[m - 1][n - 1];
    }
}

/*
简单dp题
*/