public class Solution {
    public int lengthOfLIS(int[] nums) {
        if(nums == null || nums.length == 0)    return 0;
        int[] tails = new int[nums.length];
        
        int len = 0;
        for(int num: nums) {
            int i = Arrays.binarySearch(tails, 0, len, num);
            if(i < 0)   i = -(i + 1);
            tails[i] = num;
            if(i == len)    len ++;
        }
        
        return len;
    }
}

/*
tails代表一个长度为i + 1的递增子序列出现的最后一个元素的最小值，
如nums = [4,5,6,3]，
len = 1，[4], [5], [6], [3]   => tails[0] = 3
len = 2，[4, 5], [5, 6]       => tails[1] = 5
len = 3，[4, 5, 6]            => tails[2] = 6
显然这个数组是递增的，

我们遍历nums数组，在长度为0刀len之间寻找比num大的数，
若找不到这样的数，将num放在tails的新位置，同时将len++，
这表明num比tails之前的所有数都要大，又因为num是晚于这些数出现的，因此将num放在他们之后可以增加最长子序列的长度，
若找到了这样的数，将num替换这个数，保持len不变，
这表明，该长度的子序列，可以以更小的数num结尾，这保证了后面的数可能找到更长的子序列

Arrays.binarySearch(tails, 0, len, num);
表明在[0,len)之间找num，
若找到了，返回num所在的index，
若没找到，返回num应该插入的位置的负值的变换，利用i = -(i + 1)可以得到正的应该插入的位置
*/

public class Solution {
    public int lengthOfLIS(int[] nums) {
        if(nums == null || nums.length == 0)    return 0;
        int[] dp = new int[nums.length];
        Arrays.fill(dp,1);
        int max = 1;
        
        for(int i = 1; i < nums.length; i ++) {
            for(int j = i - 1; j >= 0; j --) {
                if(nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    max = Math.max(max, dp[i]);
                }
            }
        }
        
        return max;
    }
}