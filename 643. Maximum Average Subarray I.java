public class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int n = nums.length;

        double[] dp = new double[n - k + 1];
        for(int i = 0; i < k; i ++) {
            dp[0] += nums[i];
        }
        double max = dp[0] / k;
        
        for(int i = 1; i < dp.length; i ++) {
            dp[i] = dp[i - 1] - nums[i - 1] + nums[i + k - 1];
            max = Math.max(dp[i] / k, max);
        }
        
        return max;
    }
}

/*
利用sliding window解决，dp数组的前一个和当前的一个，只有一个数字不同
*/