public class Solution {
    /*
     * @param nums: An array of integers
     * @return: An integer
     */
    public int maxProduct(int[] nums) {
        // write your code here
        if(nums == null)    return 0;
        
        int n = nums.length;
        int max = nums[0];
        int min = nums[0];
        int res = nums[0];
        
        for(int i = 1; i < n; i ++) {
            if(nums[i] > 0) {
                max = Math.max(max * nums[i], nums[i]);
                min = Math.min(min * nums[i], nums[i]);
            } else {
                int tmp = max;
                max = Math.max(min * nums[i], nums[i]);
                min = Math.min(tmp * nums[i], nums[i]);
            }
            res = Math.max(res, max);
        }
        
        return res;
    }
}

/*
简单DP问题，
因为max可能由max * num, min * num, num三种情况得到，
所以需要维护max和min两个变量分别记录到当前为止的max和min。

分析当num大于0小于0的时候，max和min分别可能由什么情况获得即可。
*/