Minimum Adjustment Cost 

 Description
 Notes
 Testcase
 Judge
Given an integer array, adjust each integers so that the difference of every adjacent integers are not greater than a given number target.

If the array before adjustment is A, the array after adjustment is B, you should minimize the sum of |A[i]-B[i]|

 Notice

You can assume each number in the array is a positive integer and not greater than 100.

Have you met this question in a real interview? Yes
Example
Given [1,4,2,3] and target = 1, one of the solutions is [2,3,2,3], the adjustment cost is 2 and it minimal.

Return 2.

public class Solution {
    /**
     * @param A: An integer array.
     * @param target: An integer.
     */
    public int MinAdjustmentCost(ArrayList<Integer> A, int target) {
        // write your code here
        if(A == null || A.size() == 0)  return 0;
        int[][] dp = new int[A.size()][101];
        int size = A.size();
        
        for(int i = 0; i < size; i ++) {
            for(int j = 0; j < 101; j ++) {
                dp[i][j] = Integer.MAX_VALUE;
                if(i == 0) {
                    dp[i][j] = Math.abs(j - A.get(i));
                } else {
                   for(int k = 0; k < 101; k ++) {
                        if(Math.abs(j - k) > target)    continue;
                        int dif = Math.abs(j - A.get(i)) + dp[i - 1][k];
                        dp[i][j] = Math.min(dif, dp[i][j]);
                    } 
                }
                
            }
        }
        
        int res = Integer.MAX_VALUE;
        for(int i = 0; i < 101; i ++) {
            res = Math.min(res, dp[size - 1][i]);
        }
        
        return res;
    }
}

/*
dp[i][j]表示将第i个元素变成j之后的总花费，
遍历A中的每一个元素i，
每一个元素在0到100之间，
对于第一个元素，即i == 0的情况，初始化dp[i][j]为Math.abs(j - A.get(i))，
对于后面的元素，
使k从0到100进行遍历，i - 1处的位置为这个k的范围，
当满足条件Math.abs(j - k) > target，两者差距足够大的时候，
获取dif的值，并且dp[i][j]和dif进行比较，取得最小值，
最后需要遍历0到100，确定最后一个值，返回最小值
*/