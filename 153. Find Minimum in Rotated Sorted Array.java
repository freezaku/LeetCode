public class Solution {
    public int findMin(int[] nums) {
        int lo = 0;
        int hi = nums.length - 1;
        
        while(lo + 1 < hi) {
            if(nums[lo] < nums[hi]) return nums[lo];
            int mid = lo + (hi - lo) / 2;
            if(nums[mid] >= nums[hi]) {
                lo = mid;
            } else {
                hi = mid;
            }
        }
        
        return Math.min(nums[lo], nums[hi]);
    }
}

/*
注意这个提前结束条件，当nums[lo] < nums[hi]的时候，表明是sorted的。
每次和nums[hi]进行比较，而不是lo。
*/