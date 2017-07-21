public class Solution {
    public boolean PredictTheWinner(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n];
        for(int[] arr: dp) {
            Arrays.fill(arr, -1);
        }
        int sum = 0;
        
        for(int num: nums) {
            sum += num;
        }
        
        return memorizeSearch(0, n - 1, dp, nums) >= ((double)sum) / 2;
    }
    
    private int memorizeSearch(int left, int right, int[][] dp, int[] nums) {
        if(left > right)    return 0;
        if(dp[left][right] != -1)    return dp[left][right];
        if(left == right) {
            dp[left][right] = nums[left];
            return dp[left][right];
        }
        
        int pickLeft = nums[left] + Math.min(memorizeSearch(left + 2, right, dp, nums), memorizeSearch(left + 1, right - 1, dp, nums));
        int pickRight = nums[right] + Math.min(memorizeSearch(left, right - 2, dp, nums), memorizeSearch(left + 1, right - 1, dp, nums));
        
        dp[left][right] = Math.max(pickLeft, pickRight);
        return dp[left][right];
    }
}

/*
利用记忆化搜索的方法求解，
唯一需要注意的就是pickLeft和pickRight的方法中，需要获得的是Math.min(memorizeSearch(left + 2, right, dp, nums), memorizeSearch(left + 1, right - 1, dp, nums))，
因为下一个人肯定获得是最大值，留下了最小值
*/