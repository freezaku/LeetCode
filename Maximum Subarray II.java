Given an array of integers, find two non-overlapping subarrays which have the largest sum.
The number in each subarray should be contiguous.
Return the largest sum.

 Notice

The subarray should contain at least one number

Have you met this question in a real interview? Yes
Example
For given [1, 3, -1, 2, -1, 2], the two subarrays are [1, 3] and [2, -1, 2] or [1, 3, -1, 2] and [2], they both have the largest sum 7.

public class Solution {
    /*
     * @param nums: A list of integers
     * @return: An integer denotes the sum of max two non-overlapping subarrays
     */
    public int maxTwoSubArrays(List<Integer> nums) {
        // write your code here
        if(nums == null || nums.size() <= 1)    return 0;
        
        int[] leftMax = new int[nums.size()];
        int leftSum = 0;
        int leftMinSum = 0;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < nums.size(); i ++) {
            leftSum += nums.get(i);
            max = Math.max(max, leftSum - leftMinSum);
            leftMinSum = Math.min(leftMinSum, leftSum);
            leftMax[i] = max;
        }
        
        int[] rightMax = new int[nums.size()];
        int rightSum = 0;
        int rightMinSum = 0;
        max = Integer.MIN_VALUE;
        for(int i = nums.size() - 1; i >= 0; i --) {
            rightSum += nums.get(i);
            max = Math.max(max, rightSum - rightMinSum);
            rightMinSum = Math.min(rightMinSum, rightSum);
            rightMax[i] = max;
        }
        
        int res = Integer.MIN_VALUE;
        for(int i = 0; i < nums.size() - 1; i ++) {
            System.out.println(leftMax[i] + " " + rightMax[i + 1]);
            res = Math.max(res, leftMax[i] + rightMax[i + 1]);
        }
        
        return res;
    }
}

/*
从左到右利用lefMax数组存储到该位置的最大subarray：
1. 利用preSum和minSum的方法，获得每个位置的最大值

从右到左利用rightProfit数组存储从该位置开始到最后的最大profit
1. 利用preSum和minSum的方法，获得每个位置的最大值

从头到尾遍历，最大sum为leftMax[i] + rightMax[i + 1]的值。

和 Best Time to Buy and Sell Stock III 很相似。
*/