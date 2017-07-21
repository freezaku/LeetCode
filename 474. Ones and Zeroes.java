public class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        
        for(String str: strs) {
            int[] count = getCount(str);
            for(int i = m; i >= count[0]; i --) {
                for(int j = n; j >= count[1]; j --) {
                   dp[i][j] = Math.max(dp[i][j], dp[i - count[0]][j - count[1]] + 1);
                }
            }
        }
        
        return dp[m][n];
    }
    
    private int[] getCount(String str) {
        int[] count = new int[2];
        for(char chr: str.toCharArray()) {
            count[chr - '0'] ++;
        }
        return count;
    }
}

/*
一个0/1背包问题的变种，只是有两个背包需要处理，
利用dp解决，dp[i][j]代表使用i个0，j个1的情况下，能够获得的最多的word的数目，
遍历strs，获取每个str 0 和 1 的数目，
然后开始填充背包，从i里面减去str的0的数目，j里面减去str的1的数目，结果 + 1，和原有的dp[i][j]进行比较。
返回dp[m][n]
*/