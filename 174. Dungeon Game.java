public class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        if(dungeon == null || dungeon.length == 0 || dungeon[0].length == 0)    return 0;
        int m = dungeon.length;
        int n = dungeon[0].length;
        
        int[][] dp = new int[m][n];
        dp[m - 1][n - 1] = Math.max(1 - dungeon[m - 1][n - 1], 1);
        
        for(int i = m - 2; i >= 0; i --) {
            dp[i][n - 1] = Math.max(dp[i + 1][n - 1] - dungeon[i][n - 1], 1);
        }
        for(int i = n - 2; i >= 0; i --) {
            dp[m - 1][i] = Math.max(dp[m - 1][i + 1] - dungeon[m - 1][i], 1);
        }
        
        for(int i = m - 2; i >= 0; i --) {
            for(int j = n - 2; j >= 0; j --) {
                int down = Math.max(dp[i + 1][j] - dungeon[i][j], 1);
                int right = Math.max(dp[i][j + 1] - dungeon[i][j], 1);
                dp[i][j] = Math.min(down, right);
            }
        }
        
        return dp[0][0];
    }
}

/*
构造dp数组，但是是从右下到左上，因为最后一个点总是确定的。
对于每个点，要么去下，要么去右，因此只需要考虑这两种情况。
在前一个点的基础上，减去改点的值，若是正数，表示加血，此时不需要提高血量上限；
若是复试，表示减血，此时需要增加血量上限，
每次都和1进行比较，因为1是最低的血量上限。
*/