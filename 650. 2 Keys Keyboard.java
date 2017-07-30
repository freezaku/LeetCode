public class Solution {
    public int minSteps(int n) {
        int[] dp = new int[n+1];

        for (int i = 2; i <= n; i++) {
            dp[i] = i;
            for (int j = i-1; j > 1; j--) {
                if (i % j == 0) {
                    dp[i] = dp[j] + (i/j);
                    break;
                }
                
            }
        }
        return dp[n];
    }
}

/*
dp[i]代表到达i需要的操作数目，
初始化为i，表示都是从1获得的，
然后遍历j从i-1到2，若i % j == 0，则表示i可以由j复制粘贴 i / j次获得，
直接break，因为j继续减小i/j或增大。
*/