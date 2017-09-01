class Solution {
    public int numDecodings(String s) {
        if(s == null || s.length() == 0)    return 0;
        if(s.charAt(0) == '0')  return 0;
        
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2; i <= n; i ++) {
            int oneDigit = Integer.valueOf(s.substring(i - 1, i));
            int twoDigit = Integer.valueOf(s.substring(i - 2, i));
            if(oneDigit >= 1 && oneDigit <= 9) {
                dp[i] += dp[i - 1];
            }
            if(twoDigit >= 10 && twoDigit <= 26) {
                dp[i] += dp[i - 2];
            }
        }
        
        return dp[n];
    }
}

/*
从左往右利用dp来完成，
首先将dp[0]和dp[1]初始化为1，
然后从2开始进行计算，
分别substring出一位和两位的数字，
当两者在符合要求的情况下，将其加到当前的dp[i]上面
*/