On one line there are n houses. Give you an array of integer means the the position of each house. 
Now you need to pick k position to build k post office, so that the sum distance of each house to the nearest post office is the smallest. 
Return the least possible sum of all distances between each village and its nearest post office.

Have you met this question in a real interview? Yes
Example
Given array a = [1,2,3,4,5], k = 2.
return 3.

public class Solution {
    /**
     * @param A an integer array
     * @param k an integer
     * @return an integer
     */
    public int postOffice(int[] A, int k) {
        // Write your code here
        if(A == null || A.length == 0 || A.length <= k)  return 0;
        int len = A.length;
        Arrays.sort(A);
        /*
        dp[i][l]表示前i个house中，放置l个office的最短总距离和
        */
        int[][] dp = new int[len + 1][len + 1];
        /*
        dis[i][j]表示第i个house和第j个house中，放置一个office的时候，
        各个house到达该office的最短距离和
        */
        int[][] dis = init(A);
        
        /*
        dp[i][l]的初始化，dp[i][1]和dis[1][i]表示的意义相同
        */
        for(int i = 0; i <= len; i ++) {
            dp[i][1] = dis[1][i];
        }
        
        //遍历l从2到k
        for(int l = 2; l <= k; l ++) {
            //遍历i从l到len，dp[i][l]就是我们每次需要求得值
            for(int i = l; i <= len; i ++) {
                dp[i][l] = Integer.MAX_VALUE;
                for(int j = 0; j < i; j ++) {
                    //不断从dp[i][l]中剔除house，看剔除的后i - j个house如果用一个office处理，
                    //而前j个用l - 1处理的话，不断更新dp[i][l]
                    dp[i][l] = Math.min(dp[i][l], dp[j][l - 1] + dis[j + 1][i]);
                }
            }
        }
        
        return dp[len][k];
    }
    
    private int[][] init(int[] A) {

        int len = A.length;
        int[][] dist = new int[len + 1][len + 1];
        /*
        寻找第i个和第j个house之间的中点，作为放置office的地方，计算dist[i][j]
        */
        for (int i = 1; i <= len; i++) {
            for (int j = i + 1; j <= len; j++) {
                int mid = (i + j) / 2;
                for (int k = i; k <= j; k++) {
                    dist[i][j] += Math.abs(A[k - 1] - A[mid - 1]);
                }
            }
        }

        return dist;
    }
}s