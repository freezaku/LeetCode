public class Solution {
    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        
        for(int i = 1; i < n; i ++) {
            dp[i]  = i;
        }
        
        for(int i = 2; i <= n; i ++) {
            for(int j = 1; j <= i - j; j ++) {
                dp[i] = Math.max(dp[i], dp[i - j] * dp[j]);
            }
        }
        
        return dp[n];
    }
}

/*
因为对于任意的n，都需要至少分为两个正数，而不能为其本身，
所以我们在初始化的时候，除了n，都给一个初始化的最大值为其本身，
n不能放入其中，而对于其他的数，至少有一个值就是其本身。

然后开始遍历数组，尝试每种可能性，track保留最大的dp[i]
*/