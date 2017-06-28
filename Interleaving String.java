Given three strings: s1, s2, s3, determine whether s3 is formed by the interleaving of s1 and s2.

Have you met this question in a real interview? Yes
Example
For s1 = "aabcc", s2 = "dbbca"

When s3 = "aadbbcbcac", return true.
When s3 = "aadbbbaccc", return false.

public class Solution {
    /*
     * @param : A string
     * @param : A string
     * @param : A string
     * @return: Determine whether s3 is formed by interleaving of s1 and s2
     */
    public boolean isInterleave(String s1, String s2, String s3) {
        // write your code here
        if(s1 == null || s2 == null || s3 == null)  return false;
        int m = s1.length();
        int n = s2.length();
        int k = s3.length();
        if(m + n != k)  return false;
        if(m == 0)  return s2.equals(s3);
        if(n == 0)  return s1.equals(s3);
        
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for(int i = 0; i < m; i ++) {
            if(s1.charAt(i) == s3.charAt(i) && dp[i][0])    dp[i + 1][0] = true;
        }
        for(int j = 0; j < n; j ++) {
            if(s2.charAt(j) == s3.charAt(j) && dp[0][j])    dp[0][j + 1] = true;
        }
        
        for(int i = 1; i <= m; i ++) {
            for(int j = 1; j <= n; j ++) {
                char chr1 = s1.charAt(i - 1);
                char chr2 = s2.charAt(j - 1);
                char chr3 = s3.charAt(i + j - 1);
                if(chr1 == chr3 && dp[i - 1][j])    dp[i][j] = true;
                if(chr2 == chr3 && dp[i][j - 1])    dp[i][j] = true;
            }
        }
        
        return dp[m][n];
    }
};

/*
dp解决，dp[i][j]表示s1的前i - 1位，s2的前j - 1位，能否组成s3的前i + j - 1位,
这题比较难想的点在于dp的初始化，
dp[0][0]置为true，
同时dp[i][0]和dp[0][j]在一开始就可以现行处理，通过与s3的比较和前者的关系得出
*/