class Solution {
    public boolean isMatch(String s, String p) {
        if(s == null || p == null)  return false;
        
        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for(int i = 2; i <= n; i ++) {
            if(p.charAt(i - 1) == '*') {
                dp[0][i] = dp[0][i - 2];
            }
        }
        
        for(int i = 1; i <= m; i ++) {
            for(int j = 1; j <= n; j ++) {
                char chrS = s.charAt(i - 1);
                char chrP = p.charAt(j - 1);
                if(chrS == chrP || chrP == '.') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if(chrP == '*'){
                    char prevChrP = p.charAt(j - 2);
                    if(prevChrP == '.' || chrS == prevChrP) {
                        dp[i][j] = dp[i][j - 1] || dp[i][j - 2] || dp[i - 1][j];
                    } else {
                        dp[i][j] = dp[i][j - 2];
                    }
                }
            }
        }
        
        return dp[m][n];
    }
}

/*
*代表能够复制一个或多个前面的元素，也能不复制，也能带着前一个元素一起消除。
例如a*，可以代表a, aa, aaa, 空，这多种意义。

因此，遇到了(i, j)，若p[j] == ‘*’的话，获取p[j - 2]，可以分为多种情况：
1. 若p[j - 2] == s[i]或者p[j - 2] == ‘.’的情况，则
（1）dp[i - 1][j]表示a*变成了aa, aaa这种情况，一个星号跟多个匹配
（2）dp[i][j - 1]表示a*变成了a这种情况，这个星号没了
（3）dp[i][j - 2]表示a*变成了空这种情况，这个星号带着之前的一起没了，这种情况并不是由这里的if条件获得的，而是把这种情况直接考虑在内
2. 若p[j - 2]为其他char，则让星号带着pre一起消失，=dp[i][j - 2]
 因为此时只有这种情况可能得到true

关于初始化问题，
就是空的s，与p的匹配，只有当p中有星号，能带着pre一起消失的时候才行
*/