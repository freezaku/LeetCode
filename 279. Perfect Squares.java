public class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for(int i = 1; i <= n; i ++) {
            for(int j = 1; j * j <= i; j ++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }
}

/*
另类的背包问题，dp问题。
对于每个dp[k]，dp[k] = Math.min(dp[k - i * i] + 1)，其中i 为 从1开始i * i <= j 的数。
因为j * j表示的那个数肯定能用一个数来表示，因此需要加1.
*/