There is a stone game.At the beginning of the game the player picks n piles of stones in a line.

The goal is to merge the stones in one pile observing the following rules:

At each step of the game,the player can merge two adjacent piles to a new pile.
The score is the number of stones in the new pile.
You are to determine the minimum of the total score.

Have you met this question in a real interview? Yes
Example
For [4, 1, 1, 4], in the best solution, the total score is 18:

1. Merge second and third piles => [4, 2, 4], score +2
2. Merge the first two piles => [6, 4]，score +6
3. Merge the last two piles => [10], score +10
Other two examples:
[1, 1, 1, 1] return 8
[4, 4, 5, 9] return 43

public class Solution {
    /**
     * @param A an integer array
     * @return an integer
     */
    public int stoneGame(int[] A) {
        // Write your code here
        if(A == null || A.length == 0)  return 0;
        int n = A.length;
        int[][] dp = new int[n][n];
        int[] sum = new int[n + 1];
        
        for(int i = 0; i < n; i ++) {
            sum[i + 1] = sum[i] + A[i];
        }
        
        return memorizeSearch(0, n - 1, A, sum, dp);
    }
    
    private int memorizeSearch(int start, int end, int[] A, int[] sum, int[][] dp){
        if(start > end) return 0;
        if(start == end) return 0;
        if(start + 1 == end) return A[start] + A[end];
        if(dp[start][end] != 0) return dp[start][end];
        
        int min = Integer.MAX_VALUE;
        for(int i = start; i < end; i ++) {
            int cost = memorizeSearch(start, i, A, sum, dp) + memorizeSearch(i + 1, end, A, sum, dp) + sum[end  + 1] - sum[start];
            min = Math.min(min, cost);
        }
        dp[start][end] = min;

        return min;
    }
}

/*
dp[i][j]表示处理从i到j个石头能够获得最大值，
sum[i]表示到i为止为止的石头和，
然后利用记忆化搜索限定范围为0到n-1，
在memorizesearch中限定各种条件，
然后利用i从start到end-1，分成两块进行搜索，再加上start到end之间的值的和，这是将这两块合并时产生的cost，
不断获取i来track最小值即可
*/