public class Solution {
    /*
     * @param triangle: a list of lists of integers
     * @return: An integer, minimum path sum
     */
    public int minimumTotal(int[][] triangle) {
        // write your code here
        if(triangle == null || triangle.length == 0 || triangle[0].length == 0) return 0;
        
        int height = triangle.length;
        int[] dp = new int[height];
        
        for(int i = 0; i < height; i ++) {
            dp[i] = triangle[height - 1][i];
        }
        
        for(int i = height - 2; i >= 0; i --) {
            for(int j = 0; j <= i; j ++) {
                dp[j] = Math.min(dp[j], dp[j + 1]) + triangle[i][j];
            }
        }
        
        return dp[0];
    }
}

/*
dp简单题，dp[i]代表i位置的最小和。
bottom-up求解，将dp数组初始化为最后一行的元素，
然后不断向上融合。
*/