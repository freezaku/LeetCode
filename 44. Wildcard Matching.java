class Solution {
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        
        dp[0][0] = true;
        for(int i = 1; i <= n; i ++) {
            if(dp[0][i - 1] && p.charAt(i - 1) == '*') {
                dp[0][i] = true;
            } else {
                break;
            }
        }
        for(int i = 1; i <= m; i ++) {
            for(int j = 1; j <= n; j ++) {
                char chr1 = s.charAt(i - 1);
                char chr2 = p.charAt(j - 1);
                if(chr1 == chr2 || chr2 == '?') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if(chr2 == '*'){
                    dp[i][j] = dp[i][j - 1] || dp[i - 1][j - 1] || dp[i - 1][j];
                }
            }
        }
        
        return dp[m][n];
    }
}

/*
dp[i][j]表示s[0]-s[i - 1]和p[i]-p[j - 1]是否match。

当s[i - 1] == p[j - 1]的时候，dp[i][j]和dp[i - 1][j - 1]相同；

当p[j - 1] = ‘?’的时候，dp[i][j]和dp[i - 1][j - 1]相同;

当p[j - 1] = ‘*’的时候，有两种情况
1. 不匹配，则相当于dp[i][j - 1]；
2. 匹配一个字符，则相当于dp[i - 1][j - 1]
2. 匹配多个字符，则相当于dp[i - 1][j]

注意初始化，dp[0][0]为true；
dp[0][i]表示s什么也没有，只有p[i - 1]一直为’*’的时候，才能置为true，
一旦不是true则break；
*/