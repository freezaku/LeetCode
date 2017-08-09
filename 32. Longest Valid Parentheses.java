public class Solution {
    public int longestValidParentheses(String s) {
        if(s == null || s.length() == 0)    return 0;
        
        int[] dp = new int[s.length()];
        dp[0] = 0;
        int res = 0;
        for(int i = 1; i < s.length(); i ++) {
            if(s.charAt(i) == ')') {
                int len = dp[i - 1];
                int left = i - len - 1;
                if(left >= 0 && s.charAt(left) == '(') {
                    dp[i] = dp[i - 1] + 2;
                    if(left - 1 >= 0) {
                        dp[i] += dp[left - 1];
                    }
                } else {
                    dp[i] = 0;
                }
            }
            res = Math.max(res, dp[i]);
        }
        
        return res;
    }
}

/*
比起stack是更加容易理解的做法。

dp[i]表示包含当前char的longest valid parentheses，
我们只需要关注 ) 即可。
遇到 ) ，我们找到其对应位置的左边char，
若该char为 ( ，则说明第i位置的char能够和该char组成一个配对，
在dp[i - 1]的基础上 + 2，同时如果dp[left - 1]存在，表明前面的结果，也需要加上，
利用res来track最大值
*/