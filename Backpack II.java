Given n items with size Ai and value Vi, and a backpack with size m. What the maximum value can you put into the backpack?

 Notice

You cannot divide item into small pieces and the total size of items you choose should smaller or equal to m.

Have you met this question in a real interview? Yes
Example
Given 4 items with size [2, 3, 5, 7] and value [1, 5, 2, 4], and a backpack with size 10. The maximum value is 9.

public class Solution {
    /**
     * @param m: An integer m denotes the size of a backpack
     * @param A & V: Given n items with size A[i] and value V[i]
     * @return: The maximum value
     */
    public int backPackII(int m, int[] A, int V[]) {
        // write your code here
        int n = A.length;
        int[] dp = new int[m + 1];
        for(int i = 0; i < n; i ++) {
            for(int j = m; j > 0; j --) {
                if(j >= A[i]) {
                    dp[j] = Math.max(dp[j], dp[j - A[i]] + V[i]);
                }
            }
        }
        return dp[m];
    }
}

/*
跟I情况基本类似，就是需要将dp[j - A[i]] + A[i]变成dp[j - A[i]] + V[i]
*/