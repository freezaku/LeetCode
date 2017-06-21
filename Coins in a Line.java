Question

There are n coins in a line. Two players take turns to take one or two coins from right side until there are no more coins left. The player who take the last coin wins.
Could you please decide the first play will win or lose?
Example
n = 1, return true.
n = 2, return true.
n = 3, return false.
n = 4, return true.
n = 5, return true.
Challenge
O(n) time and O(1) memory
Tags

Greedy Dynamic Programming Array Game Theory
Related Problems
Hard Coins in a Line III 30 % Medium Coins in a Line II

public class Solution {
    /**
     * @param n: an integer
     * @return: a boolean which equals to true if the first player will win
     */
    public boolean firstWillWin(int n) {
        // write your code here
        if(n == 0)  return false;
        if(n <= 2)  return true;
        boolean[] dp = new boolean[n + 1];
        dp[0] = false;
        dp[1] = true;
        dp[2] = true;
        for(int i = 3; i <= n; i ++) {
            dp[i] = !(dp[i - 1] && dp[i - 2]);
        }
        return dp[n];
    }
}

/*
dp[i]表示还剩下i个硬币的时候，当前取硬币的人的胜负情况，
因为当前这个人A只能取1或者2个硬币，
在他取了之后，另一个人B会面临剩下i - 1或者i - 2个硬币的情况，
因此，如果B的dp[i - 1] && dp[i - 2]为true的话，说明B会获胜，而A会失败，
因此dp[i] = !(dp[i - 1] && dp[i - 2]);
*/