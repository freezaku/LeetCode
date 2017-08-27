/*LintCode Maximum Subarray III*/

Given an array of integers and a number k, find k non-overlapping subarrays which have the largest sum.

The number in each subarray should be contiguous.

Return the largest sum.

 Notice

The subarray should contain at least one number

Have you met this question in a real interview? Yes
Example
Given [-1,4,-2,3,-2,3], k=2, return 8

public class Solution {
    /**
     * @param nums: A list of integers
     * @param k: An integer denote to find k non-overlapping subarrays
     * @return: An integer denote the sum of max k non-overlapping subarrays
     */
    public int maxSubArray(int[] nums, int k) {
        // write your code here
        if(nums == null || nums.length == 0)    return 0;
        int n = nums.length;
        
        int[][] localMax = new int[n + 1][k + 1];
        int[][] globalMax = new int[n + 1][k + 1];
        
        for(int i = 1; i <= n; i ++) {
            for(int j = 1; j <= k && j <= i; j ++) {
                localMax[j - 1][j] = Integer.MIN_VALUE;
                localMax[i][j] = Math.max(localMax[i - 1][j], globalMax[i - 1][j - 1]) + nums[i - 1];
                if(i == j) {
                    globalMax[i][j] = localMax[i][j];
                } else {
                    globalMax[i][j] = Math.max(globalMax[i - 1][j], localMax[i][j]);
                }
            }
        }
         return globalMax[n][k];
    }
}

/*
localMax[i][j]表示前i个元素，j个subarray，且第i个元素必须取得时候的，最大值，
globalMax[i][j]表示前i个元素，j个subarray，且第i个元素可以取也可以不取的时候的，最大值，

localMax[i][j] = Math.max(localMax[i - 1][j], globalMax[i - 1][j - 1]) + nums[i - 1];
1. 前i-1个元素，且第i-1个必须取，分成j个subarray，再加上的nums[i - 1]为第i个元素，跟第i-1个元素合成，不新增加subarray
2. 前i-1个元素，第i-1个可以取可以不取，分成j-1个subarray，再加上的nums[i - 1]为第i个元素，新增加一个subarray
1和2的max变成localMax[i][j]

globalMax[i][j] = Math.max(globalMax[i - 1][j], localMax[i][j]);
1. 不取第i-1个元素，j个subarray
2. 取第i-1个元素，j个subarray
1和2的max变成globalMax[i][j]；

当i<j时候，无法分，直接令localMax[j - 1][j] = Integer.MIN_VALUE;
而当i==j的时候，直接分，令globalMax[i][j] = localMax[i][j];
*/