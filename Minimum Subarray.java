public class Solution {
    /*
     * @param nums: a list of integers
     * @return: A integer indicate the sum of minimum subarray
     */
    public int minSubArray(List<Integer> nums) {
        // write your code here
        if(nums == null || nums.size() == 0)    return 0;
        
        int[] dp = new int[nums.size()];
        dp[0] = nums.get(0);
        int min = nums.get(0);
        for(int i = 1; i < nums.size(); i ++) {
            dp[i] = Math.min(nums.get(i), dp[i - 1] + nums.get(i));
            min = Math.min(min, dp[i]);
        }
        
        return min;
    }
}

/*
跟maxsubarray的思路一样，简单题
*/