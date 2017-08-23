class Solution {
    /**
     * @param nums: The integer array.
     * @param target: Target to find.
     * @return: The first position of target. Position starts from 0.
     */
    public int binarySearch(int[] nums, int target) {
        //write your code here
        if(nums == null || nums.length == 0)    return -1;
        
        int n = nums.length;
        if(nums[0] > target || nums[n - 1] < target)    return -1;
        int lo = 0;
        int hi = n - 1;
        while(lo + 1 < hi) {
            int mid = lo + (hi - lo) / 2;
            if(nums[mid] >= target) {
                hi = mid;
            } else {
                lo = mid;
            }
        }
        
        if(nums[lo] == target) {
            return lo;
        } else if(nums[hi] == target) {
            return hi;
        } else {
            return -1;
        }
    }
}

/*
简单的Binary Search，找第一次出现的位置，可能对之后的解题有帮助
*/