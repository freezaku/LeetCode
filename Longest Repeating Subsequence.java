Given a string, find length of the longest repeating subsequence such that the two subsequence don’t have same string character at same position, i.e., any ith character in the two subsequences shouldn’t have the same index in the original string.

Have you met this question in a real interview? Yes
Example
str = abc, return 0, There is no repeating subsequence

str = aab, return 1, The two subsequence are a(first) and a(second). 
Note that b cannot be considered as part of subsequence as it would be at same index in both.

str = aabb, return 2

public class Solution {
    /**
     * @param str a string
     * @return the length of the longest repeating subsequence
     */
    public int longestRepeatingSubsequence(String str) {
        // Write your code here
        if(str == null || str.length() == 0)    return 0;
        int n = str.length();
        int[][] dp = new int[n + 1][n + 1];
        for(int i = 1; i <= n; i ++) {
            for(int j = 1; j <= n; j ++) {
                if(str.charAt(i - 1) == str.charAt(j - 1) && i != j) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        
        return dp[n][n];
    }
}

/*
这题是longest common subsequence的变种，
但是要求两个subsequence对应的char其index不同，
因此利用dp，比较两个str，dp[i][j]表示strA前i个和strB前jge能够构成的LRS的最长的长度，
当两str对应的char其index不同时，直接有dp[i - 1][j - 1]获得当前的dp，
而当条件不符合的情况的时候，将其中一个左移之后的dp和另一个左移之后的dp进行比较，取最大值
*/