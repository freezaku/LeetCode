class Solution {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length < 2) return 0;
        
        int n = prices.length;
        
        int[] leftMax = new int[n];
        leftMax[0] = 0;
        int localMin = prices[0];
        for(int i = 1; i < prices.length; i ++) {
            localMin = Math.min(localMin, prices[i]);
            leftMax[i] = Math.max(leftMax[i - 1], prices[i] - localMin);
        }
        
        int[] rightMax = new int[n];
        rightMax[n - 1] = 0;
        int localMax = prices[n - 1];
        for(int i = n - 2; i >= 0; i --) {
            localMax = Math.max(localMax, prices[i]);
            rightMax[i] = Math.max(rightMax[i + 1], localMax - prices[i]);
        }
        
        int res = 0;
        for(int i = 0; i < n - 1; i ++) {
            int sum = leftMax[i] + rightMax[i + 1];
            res = Math.max(res, sum);
        }
        
        res = Math.max(res, leftMax[n - 1]);
        return res;
    }
}

/*
从左到右利用leftProfit数组存储到该位置的最大profit：
1. 对每个prices[i]，判断是否小于最小值，若小于，则更新最小值；
2. 对每个prices[i]，判断其减去最小值能否得到比最大值更大的值，若大于，则更新最大值；
3. 将最大值存入leftProfit[i]作为当前位置能够得到的最大profit

从右到左利用rightProfit数组存储从该位置开始到最后的最大profit
1. 对每个prices[i]，判断是否大于最大值，若大于，则更新最大值；
2. 对每个prices[i]，判断最大值减去他能否得到比最大值更大的值，若大于，则更新最大值；
3. 将最大值存入rightProfit[i]作为当前位置能够得到的最大profit

从头到尾遍历，最大profit为leftProfit[i] + rightProfit[i + 1]的值，但这只是两次交易得到的最大值。

还需要将其与一次交易得到的最大值进行比较，即与leftProfit[n - 1]比较，得到最终的最大值。
*/