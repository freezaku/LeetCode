class Solution {
    public int findTargetSumWays(int[] nums, int S) {
        int sum = 0;
        for(int num: nums) {
            sum += num;
        }
        
        return (sum < S || (sum + S) % 2 != 0) ? 0 : helper(nums, (sum + S) / 2);
    }
    
    private int helper(int[] nums, int target) {
        int n = nums.length;
        int[][] dp = new int[target + 1][n + 1];
        dp[0][0] = 1;
        
        for(int i = 0; i <= target; i ++) {
            for(int j = 1; j <= n; j ++) {
                dp[i][j] = dp[i][j - 1];
                if(nums[j - 1] <= i) {
                    dp[i][j] += dp[i - nums[j - 1]][j - 1];
                }
            }
        }
        
        return dp[target][n];
    }
}

/*
题目要求把nums分成两部分，一部分为正，和为P，一部分为负，和为N，P - N = S，
因此可以化为 P - N + P + N = S + P + N => 2P = S + SUM => P = (S + SUM) / 2，
其中SUM为nums数组各元素的和，
所以此题变为在nums数组内寻找到一个和为P的subset，前提条件是SUM > S，且 (S + SUM) 为偶数，
这就变成了一个背包问题，用nums去填充一个容量为S + SUM的背包有多少种方式
*/