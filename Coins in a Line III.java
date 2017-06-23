There are n coins in a line. 
Two players take turns to take a coin from one of the ends of the line until there are no more coins left. 
The player with the larger amount of money wins.

Could you please decide the first player will win or lose?

Have you met this question in a real interview? Yes
Example
Given array A = [3,2,2], return true.

Given array A = [1,2,4], return true.

Given array A = [1,20,4], return false.

public class Solution {
    /**
     * @param values: an array of integers
     * @return: a boolean which equals to true if the first player will win
     */
    public boolean firstWillWin(int[] values) {
        // write your code here
        int n = values.length;
        int[][] dp = new int[n][n];
        int sum = 0;
        
        for(int i = 0; i < n; i ++) {
            dp[i][i] = values[i];
            sum += values[i];
        }
        
        return memorizeSearch(0, n - 1, dp, values) * 2 > sum;
    }
    
    private int memorizeSearch(int left, int right, int[][] dp, int[] values) {
        if(left > right)    return 0;
        if(dp[left][right] != 0)    return dp[left][right];
        
        int leftOne = values[left] + Math.min(memorizeSearch(left + 2, right, dp, values), memorizeSearch(left + 1, right - 1, dp, values));
        int rightOne = values[right] + Math.min(memorizeSearch(left, right - 2, dp, values), memorizeSearch(left + 1, right - 1, dp, values));
        
        dp[left][right] = Math.max(leftOne, rightOne);
        
        return dp[left][right];
    }
}

/*
这次可以选择从两边取一个硬币，
利用memorizesearch的方法解答，dp[i][j]表示在i到j的范围内，当前取硬币的人A可以获得的最大的values，
初始化dp，令dp[i][i]为values[i]，
然后进入helper函数在0到n-1范围内寻找最大值，
leftOne表示当前该人A从左边选取一个硬币，则另一个人获得了dp[i - 1][j]的最大值，则剩下了dp[i + 1][j - 1]和dp[i + 2][j]中的最小值，
rightOne表示当前该人A从右边选取一个硬币，则另一个人获得了dp[i][j - 1]的最大值，则剩下了dp[i + 1][j - 1]和dp[i][j - 2]中的最小值，
最后注意比较获得的最大值和sum的关系得到结论
*/