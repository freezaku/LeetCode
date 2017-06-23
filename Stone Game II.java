There is a stone game.At the beginning of the game the player picks n piles of stones in a circle.

The goal is to merge the stones in one pile observing the following rules:

At each step of the game,the player can merge two adjacent piles to a new pile.
The score is the number of stones in the new pile.
You are to determine the minimum of the total score.

Have you met this question in a real interview? Yes
Example
For [1, 4, 4, 1], in the best solution, the total score is 18:

1. Merge second and third piles => [2, 4, 4], score +2
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
    public int stoneGame2(int[] A) {
        // Write your code here
        if(A == null || A.length == 0)  return 0;
        int n = A.length;
        int[] sum = new int[2 * n + 1];
        int[][] dp = new int[2 * n][2 * n];
        
        for(int i = 1; i <= 2 * n; i ++) {
            sum[i] = sum[i - 1] + A[(i - 1) % n];
        }
        
        memorizeSearch(0, 2 * n - 1, sum, dp);
        
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; ++i) {
           if (dp[i][i + n - 1] < ans) {
                ans = dp[i][i + n - 1];
            } 
        }
                
        return ans;

    }
    
    private int memorizeSearch(int start, int end, int[] sum, int[][] dp) {
        if(start > end) return 0;
        if(start == end)    return 0;
        if(dp[start][end] != 0)   return dp[start][end];
        
        int min = Integer.MAX_VALUE;
        for(int i = start; i < end; i ++) {
            min = Math.min(min, memorizeSearch(start, i, sum, dp) + memorizeSearch(i + 1, end, sum, dp) + sum[end + 1] - sum[start]);
        }
        
        dp[start][end] = min;
        return dp[start][end];
    }
}

/*
这题因为有circle的存在，所以需要构造一个长度为2n+1的sum和边长为2n的dp数组,
这两个数组可以存储以每个石头为circle头的情况，
dp[i][j]表示处理从i到j个石头能够获得最大值，
sum[i]表示到i为止为止的石头和，注意他的初始化和构造方法
然后利用记忆化搜索限定范围为0到2n-1，
在memorizesearch中限定各种条件，
然后利用i从start到end-1，分成两块进行搜索，再加上start到end之间的值的和，这是将这两块合并时产生的cost，
不断获取i来track最小值即可，
但是这次在结束memorizesearch之后，需要再次进行遍历，
限定长度为n遍历dp数组，找出以哪堆石头为circle的起点可以获得最小值
*/