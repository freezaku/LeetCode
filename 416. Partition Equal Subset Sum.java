public class Solution {
    public boolean canPartition(int[] nums) {
        int target = 0;
        for(int num: nums) {
            target += num;
        }
        if(target % 2 != 0) {
            return false;
        } else {
            target = target / 2;
        }
        
        boolean[][] dp = new boolean[nums.length + 1][target + 1];
        dp[0][0]  = true;
        
        for(int i = 1; i <= nums.length; i ++) {
            for(int j = 1; j <= target; j ++) {
                if(j >= nums[i - 1]) {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }   
            }
        }
        
        return dp[nums.length][target];
    }
}

/*
将其化为0/1背包问题，利用nums的数，构造使之和为target即可。
*/