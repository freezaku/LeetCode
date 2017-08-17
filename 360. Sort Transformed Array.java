public class Solution {
    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        int n = nums.length;
        int[] res = new int[n];
        
        int lo = 0;
        int hi = n - 1;
        int index = a > 0 ? n - 1 : 0;
        
        while(lo <= hi) {
            int left = helper(nums[lo], a, b, c);
            int right = helper(nums[hi], a, b, c);
            if(a > 0) {
                if(left > right) {
                    res[index] = left;
                    lo ++;
                } else {
                    res[index] = right;
                    hi --;
                }
                index --;
            } else {
                if(left< right) {
                    res[index] = left;
                    lo ++;
                } else {
                    res[index] = right;
                    hi --;
                }
                index ++;
            }
        }
        
        return res;
    }
    
    private int helper(int num, int a, int b, int c) {
        return a * (num * num) + b * num + c;
    }
}

/*
画图找简单规律。
当a > 0的时候，在数组两端肯定存在一个数，使之为最大值；
当a < 0的时候，在数组两端肯定存在一个数，使之为最小值；
使用lo和hi代表两端的坐标位置，index代表我们建立的res array需要置值的位置，
利用two pointer的思想填充res数组
*/