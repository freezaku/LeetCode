Given n distinct positive integers, integer k (k <= n) and a number target.

Find k numbers where sum is target. Calculate how many solutions there are?

Have you met this question in a real interview? Yes
Example
Given [1,2,3,4], k = 2, target = 5.

There are 2 solutions: [1,4] and [2,3].

Return 2.

public class Solution {
    /**
     * @param A: an integer array.
     * @param k: a positive integer (k <= length(A))
     * @param target: a integer
     * @return an integer
     */
    public int kSum(int A[], int k, int target) {
        // write your code here
        if(A == null || A.length == 0)  return 0;
        int n = A.length;
        int[][][] dp = new int[n + 1][k + 1][target + 1];
        for (int i = 0; i < n + 1; i++) {
            dp[i][0][0] = 1;
        }

        for(int i = 1; i <= A.length; i ++) {
            for(int j = 1; j <= k && j <= i; j ++) {
                for(int t = 1; t <= target; t ++) {
                    dp[i][j][t] = 0;
                    if(t >= A[i - 1]) {
                        dp[i][j][t] = dp[i - 1][j - 1][t - A[i - 1]];
                    }
                    dp[i][j][t] += dp[i - 1][j][t];
                    
                }
            }
        }
        
        return dp[A.length][k][target];
    }
}

/*
背包类问题的扩展版本~
我们关注的维度有三个：
前 i 个元素，因为一个元素只能选一次；
选了 j 个元素，因为我们要求选 k 个数；
总和 sum，用于每次试图添加新元素时用来查询。
时间：O(len * k * target)，三重循环
空间：O(k * target)
*/