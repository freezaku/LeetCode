public class Solution {
    /*
     * @param A: A string
     * @param B: A string
     * @return: the length of the longest common substring.
     */
    public int longestCommonSubstring(String A, String B) {
        if(A == null || A.length() == 0 || B == null || B.length() == 0)    return 0;

        int m = A.length();
        int n = B.length();
        int[][] dp = new int[m + 1][n + 1];
        int max = 0;

        for(int i = 1; i <= m; i ++) {
            for(int j = 1; j <= n; j ++) {
                if(A.charAt(i - 1) == B.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    max = Math.max(max, dp[i][j]);
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        
        return max;
    }
}

/*
注意这个substring是一个连续的序列，和subsequence也不同，
dp[i][j]代表使用A的前i个char和B的前j个char所可以组成的LCS，
因此dp[i][j]要么为0，要么在dp[i - 1][j - 1]的基础上 + 1，
利用max来track出现的最大值。
*/