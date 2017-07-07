public class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int left = -1;
        int right = -1;
        int max = nums[0];
        int min = nums[nums.length - 1];
        for(int i = 1; i < nums.length; i ++) {
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[nums.length - i - 1]);
            if(max > nums[i])   right = i;
            if(min < nums[nums.length - i - 1]) left = nums.length - i - 1;
        }
        
        if(left  < 0)   return 0;
        return right - left + 1;
    }
}

/*
非O(N)的做法很容易想到，直接sort之后，与原数组进行比较即可，
对于O(N)的做法，分别从左往右找max，从右往左找min，
从左往右遇到num小于max，说明这个num过小，将right置为i，
从右往左遇到num大于min，说明这个num过大，将left置为nums.length - i - 1，
最后当left < 0的时候，表明数组本身就是sorted，返回0，
否则返回right - left  + 1
*/