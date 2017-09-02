class Solution {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length <= 1)    return 0;
        
        int min = prices[0];
        int max = 0;
        for(int i = 1; i < prices.length; i ++) {
            if(prices[i] < min) {
                min = prices[i];
            } else {
                max = Math.max(max, prices[i] - min);
            }
        }
        
        return max;
    }
}

/*
简单DP问题，维护两个变量min和max；
min代表i之前所有元素的最小值，可以不断更新，当不进行更新的时候，更新max
*/