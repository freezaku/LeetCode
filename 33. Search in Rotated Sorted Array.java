public class Solution {
    public int search(int[] nums, int target) {
        if(nums == null || nums.length == 0)    return -1;
        int lo = 0;
        int hi = nums.length - 1;
        
        while(lo + 1 < hi) {
            int mid = lo + (hi - lo) / 2;
            if(nums[mid] == target) {
                return mid;
            }
            if(nums[mid] >= nums[lo]) {
                if(target <= nums[mid] && target >= nums[lo]) {
                    hi = mid;
                } else {
                    lo = mid;
                }
            } else {
                if(target >= nums[mid] && target <= nums[hi]) {
                    lo = mid;
                } else {
                    hi = mid;
                }
            }
        }
        
        if(nums[lo] == target)  return lo;
        if(nums[hi] == target)  return hi;
        return -1;
    }
}

/*
主要就是使用left + 1 < right这个限定条件，来防止越界的情况，
这样就不必对hi和lo进行加一和减一的操作了。
然后画图限定范围
*/