class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[nums.length];
        
        res[0] = 1;
        for(int i = 0; i < n - 1; i ++) {
            res[i + 1] = res[i] * nums[i];
        }
        
        int product = 1;
        for(int i = n - 1; i >= 0; i --) {
            res[i] = res[i] * product;
            product *= nums[i];
        }
        
        return res;
    }
}

/*
获得一个数组从左往右，第一个是1，第 i 个是nums的前i - 1个相乘；
[1, 1, 2, 6]
第二个数组从右往左，第一个是1，第i个是nums的后i个数相乘;
[24, 12, 4, 1]
两数组相乘即得到答案
*/