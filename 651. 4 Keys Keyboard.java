public class Solution {
    public int maxA(int N) {
        int[] dp = new int[N + 1];
        
        for(int i = 1; i <= N; i ++) {
            dp[i] = i;
            for(int j = 3; j < i; j ++) {
                dp[i] = Math.max(dp[i], dp[i - j] * (j - 1));
            }
        }
        
        return dp[N];
    }
}
/*
dp[i]表示使用ici操作能获得最多的A的数目，初始化为i；
dp[i]从dp[i - j]过来，需要经过全选，复制两个无效的操作，然后后面的复制才能使其数量加倍，
所以dp[i] = dp[i - j] * (j - 1)，如下展示了一个例子
    i = 9, j  = 6, dp[3] * 5
    dp[3] = x
    dp[4] = x
    dp[5] = x
    dp[6] = 2x
    dp[7] = 3x
    dp[8] = 4x
    dp[9] = 5x
*/