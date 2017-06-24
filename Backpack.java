Given n items with size Ai, an integer m denotes the size of a backpack. How full you can fill this backpack?

 Notice

You can not divide any item into small pieces.

Have you met this question in a real interview? Yes
Example
If we have 4 items with size [2, 3, 5, 7], the backpack size is 11, we can select [2, 3, 5], so that the max size we can fill this backpack is 10. If the backpack size is 12. we can select [2, 3, 7] so that we can fulfill the backpack.

You function should return the max size we can fill in the given backpack.

public class Solution {
    /**
     * @param m: An integer m denotes the size of a backpack
     * @param A: Given n items with size A[i]
     * @return: The maximum size
     */
    public int backPack(int m, int[] A) {
        // write your code here
        if(A == null || A.length == 0)  return 0;
        
        int[] dp = new int[m + 1];
        for(int i = 0; i < A.length; i ++) {
            for(int j = m; j > 0; j --) {
                if(j >= A[i]) {
                    dp[j] = Math.max(dp[j], dp[j - A[i]] + A[i]);
                }
            }
        }
        
        return dp[m];
    }
}

/*
一维数组方式，dp[i]表示用size为i的backpack可以存储的最大值，
i从0到A.length - 1，j从m到1遍历，
当j >= A[i]的时候，表示可以将item i放入size为j的背包，
此时注意更新dp[j]，比较其和dp[j - A[i]] + A[i]
*/

ublic class Solution {
    /**
     * @param m: An integer m denotes the size of a backpack
     * @param A: Given n items with size A[i]
     * @return: The maximum size
     */
    public int backPack(int m, int[] A) {
        // write your code here
        if(A == null || A.length == 0)  return 0;
        int n = A.length;
        boolean[][] dp = new boolean[n + 1][m + 1];
        
        dp[0][0] = true;
        for(int i = 1; i <= n; i ++) {
            for(int j = 0; j <= m; j ++) {
                dp[i][j] = dp[i - 1][j];
                if(j >= A[i - 1] && dp[i - 1][j - A[i - 1]]) {
                    dp[i][j] = true;
                }
            }
        }

        for(int i = m; i >= 0; i --) {
            if(dp[n][i]) {
                return i;
            }
        }
        
        return 0;
    }
}

/*
二维数组存boolean，dp[i][j]表示size为j的时候存储item的前n个，
初始化dp[0][0]为true，
然后遍历i和j，
每次初始化dp[i][j]为dp[i - 1][j]，
再比较j和A[i - 1]的关系并且确保dp[i - 1][j - A[i - 1]]为true，这样就能更新dp[i][j]为true，
最后再遍历当size即i为n的情况下，能够获得true时候，最大的j，
只要从m到0遍历j即可，返回第一个为true的i
*/