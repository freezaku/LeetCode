public class Solution {
    public int maxProfit(int k, int[] prices) {
        if(prices == null || prices.length == 0)    return 0;
        if(k >= prices.length / 2) {
            int profit = 0;
            for(int i = 1; i < prices.length; i ++) {
                profit += Math.max(0, prices[i] - prices[i - 1]);
            }
            return profit;
        }
        
        int[][] dp = new int[k + 1][prices.length];
        for(int i = 1; i <= k; i ++) {
            int tempMax = dp[i - 1][0] - prices[0];
            for(int j = 1; j < prices.length; j ++) {
                dp[i][j] = Math.max(dp[i][j - 1], prices[j] + tempMax);
                tempMax = Math.max(tempMax, dp[i - 1][j] - prices[j]);
            }
        }
        
        return dp[k][prices.length - 1];
    }
}

/*dp[i][j]表示使用i次交易处理前j天的股票，
因此dp[i][j]可以由两种形式得到，
一种就是在当天不进行交易，即dp[i][j - 1]，直接从前一天继承过来，
另一种就是当天进行交易，上一次买入是在jj天，因此=dp[i - 1][jj] + price[j] - price[jj]，
而这个等式可以变换成, MAX(dp[i - 1][jj] - price[jj]) + price[j]，jj是在0到j之间的一天，
所以我们在i循环里面，初始化localmax为dp[i - 1][0] - prices[0]，
之后先计算我们需要的额当前的dp[i][j]，然后对localMax进行更新*/
