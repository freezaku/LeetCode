class Solution {
    public boolean increasingTriplet(int[] nums) {
        if(nums == null || nums.length < 3) return false;
        
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        int index = 0;
        
        for(int i = 1; i < n; i ++) {
            int pos = Arrays.binarySearch(dp, 0, index + 1, nums[i]);
            if(pos < 0) {
                pos = -(pos + 1);
            }
            if(pos > index) {
                dp[pos] = nums[i];
                index = pos;
                if(index + 1 >= 3)   return true;
            }
            
            dp[pos] = Math.min(dp[pos], nums[i]);
        }
        
        return false;
    }
}

/*
利用单调栈思想，可以方便解决k个increasing subsequence的情况。
利用binarySearch(Object[], int fromIndex, int toIndex, Object key)函数，
获得当前的num应该插入dp数组的位置，若放在最后，则说明其比dp内所有的数都大，此时应该判断pd内放入的是否已经多余3个，

否则，根据原本dp[pos]和num的大小关系，将他们中小的那个放入num。
*/

class Solution {
    public boolean increasingTriplet(int[] nums) {
        if(nums == null || nums.length < 3) return false;
        
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;
        
        for(int num: nums) {
           if(num <= min1) {
               min1 = num;
           } else if(num <= min2) {
               min2 = num;
           } else {
               return true;
           }
        }
        
        return false;
    }
}

/*
当k较小的时候，直接使用min1和min2两个变量解决。
设置num1和num2分别表示当前最小值和第二小的值，且num1的index小于num2的index。
若当前num比num1小，则更新num1，因为返回true需要比num2还大，因此不会错过输出；
当前num比num2小，则更新num2，以为此时有了更小的num2，因此可选num的范围更大，不会错过输出。

*/