public class Solution {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length <= 1)    return 0;
        int n = prices.length;
        int[] buy = new int[n];
        int[] sell = new int[n];
        int[] rest = new int[n];
        buy[0] = -prices[0];
        sell[0] = 0;
        rest[0] = 0;
        for(int i = 1; i < n; i ++) {
            buy[i] = Math.max(rest[i - 1] - prices[i], buy[i - 1]);
            sell[i] = Math.max(buy[i - 1] + prices[i], sell[i - 1]);
            rest[i] = sell[i - 1];
        }
        return Math.max(sell[n - 1], rest[n - 1]);
    }
}

/*
Solution1:
1. buy[]表示当前时刻选择买或者不买，买的话从rest[i - 1]处过来，同时 - price，不买的话从buy[i -1]过来
2. sell[]表示当前时刻选择卖还是不卖，卖的话从buy[i - 1]过来，同时 + price, 不卖的话从sell[i - 1]过来
3. rest[]表示cooldown，表示刚刚卖完，从sell[i - 1]过来
*/

public class Solution {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length <= 1)    return 0;
        int n = prices.length;
        int[] buy = new int[n];
        int[] sell = new int[n];
        buy[0] = -prices[0];
        sell[0] = 0;
        buy[1]  = Math.max(-prices[0], -prices[1]);
        sell[1] = Math.max(sell[0], prices[1] - prices[0]);
        for(int i = 2; i < n; i ++) {
            buy[i] = Math.max(sell[i - 2] - prices[i], buy[i - 1]);
            sell[i] = Math.max(buy[i - 1] + prices[i], sell[i - 1]);
        }
        return sell[n - 1];
    }
}

/*
Soultion2：
1. 既然rest[i]可以用sell[i - 1]直接表示，那么可以用sell[i - 1]代替rest[i]，取代所有的rest用到的地方
2. 此时注意i从2开始，将buy, sell的1，2都进行初始化
*/

public class Solution {
    public int maxProfit(int[] prices) {
        int sell = 0;
        int prev_sell = 0;
        int buy = Integer.MIN_VALUE;
        int prev_buy = 0;
        for(int price: prices) {
            prev_buy = buy;
            buy = Math.max(prev_sell - price, prev_buy);
            prev_sell = sell;
            sell = Math.max(prev_buy + price, prev_sell);
        }
        return sell;
    }
}

/*
Soultion3：
1. 既然第i天只依赖于第i - 1和 i - 2天，可以用其他方式代替
2. 注意什么时候将buy和sell赋给prev_buy和prev_sell
*/
