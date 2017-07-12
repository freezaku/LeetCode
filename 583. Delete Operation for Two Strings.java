public class Solution {
    public int minDistance(String word1, String word2) {
        if(word1.length() == 0 || word2.length() == 0)   return Math.max(word1.length(), word2.length());
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m + 1][n + 1];
        
        for(int i = 0; i <= m; i ++) {
            dp[i][0] = i;
        }
        for(int i = 0; i <= n; i ++) {
            dp[0][i] = i;
        }
        
        for(int i = 1; i <= m; i ++) {
            for(int j = 1; j <= n; j ++) {
                if(word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j] + 1, Math.min(dp[i][j - 1] + 1, dp[i - 1][j - 1] + 2));
                }
            }
        }
        
        return dp[m][n];
    }
}

/*
和edit distance相同，就是找最长的相同的substring，
但是需要注意这个dp的公式，dp[i - 1][j - 1] + 2，因为两者都需要减去一个使得操作加了2个
*/