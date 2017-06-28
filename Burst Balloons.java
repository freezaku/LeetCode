Given n balloons, indexed from 0 to n-1. Each balloon is painted with a number on it represented by array nums. You are asked to burst all the balloons. If the you burst balloon i you will get nums[left] * nums[i] * nums[right] coins. Here left and right are adjacent indices of i. After the burst, the left and right then becomes adjacent.

Find the maximum coins you can collect by bursting the balloons wisely.
- You may imagine nums[-1] = nums[n] = 1. They are not real therefore you can not burst them.
- 0 ≤ n ≤ 500, 0 ≤ nums[i] ≤ 100

Have you met this question in a real interview? Yes
Example
Given [4, 1, 5, 10]
Return 270

nums = [4, 1, 5, 10] burst 1, get coins 4 * 1 * 5 = 20
nums = [4, 5, 10]    burst 5, get coins 4 * 5 * 10 = 200 
nums = [4, 10]       burst 4, get coins 1 * 4 * 10 = 40
nums = [10]          burst 10, get coins 1 * 10 * 1 = 10

Total coins 20 + 200 + 40 + 10 = 270

public class Solution {
    public int maxCoins(int[] nums) {
        if(nums == null || nums.length == 0)    return 0;
        int n = nums.length;
        int[] arr = new int[n + 2];
        arr[0] = 1;
        arr[n + 1] = 1;
        for(int i = 0; i < n; i ++) {
            arr[i + 1] = nums[i];
        }
        int[][] dp = new int[n + 2][n + 2];
        return helper(1, n, arr, dp);
    }
    private int helper(int start, int end, int[] arr, int[][] dp) {
        if(dp[start][end] != 0) return dp[start][end];
        int max = 0;
        for(int i = start; i <= end; i ++) {
            int cur = arr[start - 1] * arr[i] * arr[end + 1];
            int left = helper(start, i - 1, arr, dp);
            int right = helper(i + 1, end, arr, dp);
            max = Math.max(max, cur + left + right);
        }
        dp[start][end] = max;
        return max;
    }
}

/*
运用dp的思路来解答，
但是不是从前一个状态推断下一个状态，
而是由下一个状态回归的前一个状态，
因为我们可以看出前一个状态不能影响下一个状态，
而我们可以得知最后一个状态，arr[start - 1] * arr[i] * arr[end + 1]，
前一个状态导致最后我这三个气球相连，
而前一个状态为dp[start][i - 1]和dp[i + 1][end]，
dp[i][j]表示从i到j能够获得的最大的coins数目，
dp[start][end]由当前状态的cur和前一个状态的left和right相加组成。
*/