public class Solution {
    public int searchInsert(int[] nums, int target) {
        if(nums == null || nums.length == 0)    return 0;
        
        int lo = 0;
        int hi = nums.length - 1;
        while(lo + 1 < hi) {
            int mid = lo + (hi - lo) / 2;
            if(nums[mid] == target) {
                return mid;
            } else if(nums[mid] < target) {
                lo = mid;
            } else {
                hi = mid;
            }
        }
        
        if(target <= nums[lo]) {
            return lo;
        } else if(target <= nums[hi]) {
            return hi;
        } else {
            return hi + 1;
        }
        
    }
}

/*
利用lo + 1 < hi作为循环判断条件，
注意这种情况，需要对结束时候的情况进行分析
*/