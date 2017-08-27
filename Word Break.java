public class Solution {
    /*
     * @param s: A string
     * @param dict: A dictionary of words dict
     * @return: A boolean
     */
    public boolean wordBreak(String s, Set<String> dict) {
        // write your code here
        int maxLen = 0;
        for(String str: dict) {
            maxLen = Math.max(maxLen, str.length());
        }
        
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        
        for(int i = 1; i <= s.length(); i ++) {
            for(int len = 1; len <= maxLen && len <= i; len ++) {
                if(!dp[i - len])    continue;

                String str = s.substring(i - len, i);
                if(dict.contains(str)) {
                    dp[i] = true;
                    break;
                }
                
            }
        }
        
        return dp[s.length()];
    }
}

/*
先遍历dict找到maxLen，这样能减少第二层循环的次数和范围。
其他的就是简单dp问题解决思路。
*/