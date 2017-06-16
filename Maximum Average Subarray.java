Given an array with positive and negative numbers, find the maximum average subarray which length should be greater or equal to given length k.

 Notice

It guaranteed that the size of the array is greater or equal to k.

Have you met this question in a real interview? Yes
Example
Given nums = [1, 12, -5, -6, 50, 3], k = 3

Return 15.667 // (-6 + 50 + 3) / 3 = 15.667



public class Solution {
    /**
     * @param nums an array with positive and negative numbers
     * @param k an integer
     * @return the maximum average
     */
    public double maxAverage(int[] nums, int k) {
        // Write your code here
        double left = Integer.MAX_VALUE;
        double right = Integer.MIN_VALUE;
        for(int num: nums) {
            left = Math.min(num, left);
            right = Math.max(num, right);
        }
        while(right - left >= 1e-6) {
            double mid = left + (right - left) / 2.0;
            if(checkValid(mid, nums, k)) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return left;
    }
    private boolean checkValid(double mid, int[] nums, int k) {
        int n = nums.length;
        double[] sums = new double[n + 1];
        double min_pre = 0;
        sums[0] = 0;
        for(int i = 1; i <= n; i ++) {
            sums[i] = sums[i - 1] + nums[i - 1] - mid;
            if(i >= k && sums[i] - min_pre >= 0) {
                return true;
            }
            if(i >= k) {
                min_pre = Math.min(min_pre, sums[i - k + 1]);
            }
        }
        return false;
    }
}

/*
一个数组的子数组的最大平均数一定在数组的最大值和最小值之间，所以二分法的第一步限定average位于[min,max]之中；
接下去要做的就是不断的缩小范围，直至max-min足够小（如1e-6），那我们就得到了想要的结果。

每一轮设置mid=(min+max)/2，然后将原数组中的每一个数减去这个mid，如果能找到大于等于k个相邻数的总和大于0的情况，
那么说明最终结果一定比这个mid要更大，限定下一轮寻找范围在[mid,max]之中。反之在限定在[min,mid]之中。

那么在实际算法中我们需要解决的关键一步就是，如何判断“有（大于等于）k个相邻数的总和大于0的情况存在”。

首先，我们可以用sum数组来存储减掉mid值的原数组的各总和（sum[i]存储num[0]-mid到num[i-1]-mid的总和），
用min_pre表示在该位置之前k个位置的sums[i]的最小值，
当sum[i]存储的总和个数超过k时（即i>k），也就是说我们保证了这个子数组的长度达到k后，
可以将min_pre进行更新，始终保持min_pre为限定范围内的最小值，可以更新为min_pre=sum[i - k + 1]，

sum[i]存储的是num[0]~num[i-1]减去mid的总和，而min_pre存储的是num[0]~num[k]减掉mid的总和，
两者相减，得到nums[k+1]~nums[i-1]的和，若其 >= 0，则说明这个平均值可以达到。

需要解释清楚的就是这个min_pre，
他代表的长度不定，但是一定能够保证sum[i] - min_pre是一个长度大于等于k的子数组减去mid之后的值得和。


*/