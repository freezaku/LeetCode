public class Solution {
    /**
     * @param values: an array of integers
     * @return: a boolean which equals to true if the first player will win
     */
    public boolean firstWillWin(int[] values) {
        // write your code here
        int n = values.length;
        if(n <= 2)  return true;
        int[] sums = new int[n + 1];
        for(int i = 1; i <= n; i ++) {
            sums[i] = sums[i - 1] + values[n - i];
        }
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = sums[1];
        dp[2] = sums[2];
        for(int i = 3; i <= n; i ++) {
            dp[i] = Math.max(sums[i] - dp[i - 1], sums[i] - dp[i - 2]);
        }
        return dp[n] * 2 > sums[n];
    }
}

/*
dp[i]表示还剩下i个硬币的时候，当前取硬币的人A可以获得的最大value，
sums[i]表示还剩下的i的硬币的总价值，注意其初始化和计算方式，
dp[i]由两者决定，
sums[i] - dp[i - 1]表示另一个人B取走一个硬币留下i - 1个硬币的时候，A可以获得的价值，
sums[i] - dp[i - 2]表示另一个人B取走两个硬币留下i - 2个硬币的时候，B可以获得的价值，
取两者中的max表示A接下来能够获得的最大value
*/

public class Solution {
    /**
     * @param values: an array of integers
     * @return: a boolean which equals to true if the first player will win
     */
    public boolean firstWillWin(int[] values) {
        // write your code here
        int n = values.length;
        if(n <= 2)  return true;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, - 1);
        dp[0] = 0;
        dp[1] = values[n - 1];
        dp[2] = values[n - 1] + values[n - 2];
        int sum = 0;
        for(int value: values) {
            sum += value;
        }
        return memorizeSearch(n, dp, values) * 2 > sum;
    }
    
    private int memorizeSearch(int coins, int[] dp, int[] values) {
        if(coins < 0)   return 0;
        if(dp[coins] != -1) return dp[coins];
        
        int n = values.length;
        
        int onePick = values[n - coins] + Math.min(memorizeSearch(coins - 2, dp, values), memorizeSearch(coins - 3, dp, values));
        
        int twoPick = values[n - coins] + values[n - coins + 1] + Math.min(memorizeSearch(coins - 3, dp, values), memorizeSearch(coins - 4, dp, values));
        
        dp[coins] = Math.max(onePick, twoPick);
        return dp[coins];
    }
}

/*
当存在“价值”之后，这题就是比较典型的博弈问题了，
在 AI 里最常用的是 MiniMax算法，
如图所示，对于当前玩家来讲，会在当前的选择中选择 Max Profit; 
而下一层对手的回合对手会选择留下 Min Profit 的走

当前还有 n 个硬币时 F(n)，每一步都可以选择拿 1 或 2 个硬币；
自己拿 1 个，对手子问题F(n - 1)：
对手拿 1 个 - 自己下一步为F(n - 2)；
对手拿 2 个 - 自己下一步为F(n - 3);

自己拿 2 个，对手子问题F(n - 2)：
对手拿 1 个 - 自己下一步为F(n - 3)；
对手拿 2 个 - 自己下一步为F(n - 4);

其中因为隔了一步对手的回合，对手也一定会倾向于最有利于自己的选择，
因此留下了最小值，自己的下一个 subproblem 值一定为两种可能中最小的一个。
而对于本回合，自己要取拿 1 或 2个硬币中受益最大的选择。
*/