Given an array with integers.

Find two non-overlapping subarrays A and B, which |SUM(A) - SUM(B)| is the largest.

Return the largest difference.

 Notice

The subarray should contain at least one number

Have you met this question in a real interview? Yes
Example
For [1, 2, -3, 1], return 6.

public class Solution {
    /*
     * @param nums: A list of integers
     * @return: An integer indicate the value of maximum difference between two substrings
     */
    public int maxDiffSubArrays(int[] nums) {
        // write your code here
        int n = nums.length;
        int[] leftMax = new int[n];
        int[] leftMin = new int[n];
        int[] rightMax = new int[n];
        int[] rightMin = new int[n];
        
        int preSum = 0;
        int localMin = 0;
        int globalMax = Integer.MIN_VALUE;
        for(int i = 0; i < n; i ++) {
            preSum += nums[i];
            globalMax = Math.max(globalMax, preSum - localMin);
            localMin = Math.min(localMin, preSum);
            leftMax[i] = globalMax;
        }
        
        preSum = 0;
        int localMax = 0;
        int globalMin = Integer.MAX_VALUE;
        for(int i = 0; i < n; i ++) {
            preSum += nums[i];
            globalMin = Math.min(globalMin, preSum - localMax);
            localMax = Math.max(localMax, preSum);
            leftMin[i] = globalMin;
        }
        
        preSum = 0;
        localMin = 0;
        globalMax = Integer.MIN_VALUE;
        for(int i = n - 1; i >= 0; i --) {
            preSum += nums[i];
            globalMax = Math.max(globalMax, preSum - localMin);
            localMin = Math.min(localMin, preSum);
            rightMax[i] = globalMax;
        }
        
        preSum = 0;
        localMax = 0;
        globalMin = Integer.MAX_VALUE;
        for(int i = n - 1; i >= 0; i --) {
            preSum += nums[i];
            globalMin = Math.min(globalMin, preSum - localMax);
            localMax = Math.max(localMax, preSum);
            rightMin[i] = globalMin;
        }
        
        int res = 0;
        for(int i = 0; i < n - 1; i ++) {
            int tmp = Math.max(Math.abs(leftMax[i] - rightMin[i + 1]), Math.abs(leftMin[i] - rightMax[i + 1]));
            res = Math.max(res, tmp);
        }
        
        return res;
    }
}

/*
对于local，global模板应用的综合考察。
一个最大的ABS diff可能由两种情况获得：
1. 左边最大减去右边最小
2. 左边最小减去右边最大
*/