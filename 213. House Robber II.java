public class Solution {
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0)    return 0;
        int n = nums.length;
        if(n == 1)  return nums[0];
        if(n == 2)  return Math.max(nums[0], nums[1]);
        int max1 = findMax(nums, 0, n - 1);
        int max2 = findMax(nums, 1, n);
        return Math.max(max1, max2);
    }
    
    private int findMax(int[] nums, int start, int end) {
        int preRob = 0;
        int preNotRob = 0;
        int curRob = 0;
        int curNotRob = 0;
        for(int i = start; i < end; i ++) {
            curRob = preNotRob + nums[i];
            curNotRob = Math.max(preRob, preNotRob);
            preRob = curRob;
            preNotRob = curNotRob;
        }
        return Math.max(curRob, curNotRob);
    }
}

/*
这次变成环形找最大值。
分别对于两种情况求解，
第一种情况：考虑头，去除尾，0 ~ n - 1;
第二种情况：考虑尾，去除头，1 ~ n；
*/