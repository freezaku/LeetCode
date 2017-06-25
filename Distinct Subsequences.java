Given a string S and a string T, count the number of distinct subsequences of T in S.

A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).

Have you met this question in a real interview? Yes
Example
Given S = "rabbbit", T = "rabbit", return 3.

public class Solution {
    /**
     * @param S, T: Two string.
     * @return: Count the number of distinct subsequences
     */
    public int numDistinct(String S, String T) {
        // write your code here
        int[][] dp = new int[T.length() + 1][S.length() + 1];
        for(int i = 0; i <= S.length(); i ++) {
            dp[0][i] = 1;
        }

        for(int i = 1; i <= T.length(); i ++) {
            for(int j = 1; j <= S.length(); j ++) {
                if(T.charAt(i - 1) == S.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i][j - 1];
                } else {
                    dp[i][j] = dp[i][j - 1];
                }
            }
        }
        return dp[T.length()][S.length()];
    }
}

/*
运用dp的思路来解决问题，
dp[i][j]表示到t的i - 1位置，s的j - 1位置，能够产生的substring的数量，
首先进行初始化，
对于dp[0][j]表示在t为空的情况下，s所包含的substring数量，此时do[0][j]均为1；
而对于dp[i][0](i != 0)，表示s为空的情况下，s所包含的substring的数量，此时dp[i][0]均为0；
然后从上往下，一行一行的填充，
当t的第i - 1个和s的第j - 1个不相等的时候，
所产生的substring数量不变，仍然为s的前j - 1位包含的substring数量，即为dp[i][j - 1]；
而当他们两个相等的时候，不仅包含了dp[i][j - 1]，而且需要加上dp[i - 1][j - 1]，
这表示在不考虑这个相同的char之前s的前j-1位含有的t的前i-1位的substring数量，现在加上这个想得的插入正好等于能够新构造产生的substring的数量
*/