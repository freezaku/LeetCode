public class Solution {
    public boolean isScramble(String s1, String s2) {
        if(s1.length() != s2.length())  return false;
        int len = s1.length();
        boolean[][][] dp = new boolean[len][len][len + 1];
        
        for(int k = 1; k <= len; k ++) {
            for(int i = 0; i + k <= len; i ++) {
                for(int j = 0; j + k <= len; j ++) {
                    if(k == 1) {
                        dp[i][j][k] = (s1.charAt(i) == s2.charAt(j));
                    } else {
                        for(int q = 1; q < k && !dp[i][j][k]; q ++) {
                            dp[i][j][k] = (dp[i][j][q] && dp[i + q][j + q][k - q]) || (dp[i][j + k - q][q] && dp[i + q][j][k - q]);
                        }
                    }
                }
            }
        }
        return dp[0][0][len];
    }
}

/*
使用三维boolean数组dp[i][j][k]，i为s1的起始index，j为s2的起始index，k为子串substring的长度，
dp[i][j][k]由两种情况的组合而成，
s1 -- [i, i + q]，s2 -- [j, j + q] && s1 -- [i + q + 1, k], s2 -- [j + q + 1, k];
s1 -- [i, i + q], s2 -- [j + k - q, k] && s1 -- [i + q + 1, k], s2 -- [j, k - q];
这两种有一种为true，则表明当前的dp[i][j][k]为true
*/