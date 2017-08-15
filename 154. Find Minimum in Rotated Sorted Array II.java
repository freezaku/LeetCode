public class Solution {
    public int findMin(int[] nums) {
        int lo = 0;
        int hi = nums.length - 1;
        
        while(lo + 1 < hi) {
            if(nums[lo] < nums[hi]) return nums[lo];
            int mid = lo + (hi - lo) / 2;
            if(nums[mid] > nums[hi]) {
                lo = mid;
            } else if(nums[mid] < nums[hi]) {
                hi = mid;
            } else {
                hi --;
            }
        }
        
        return Math.min(nums[lo], nums[hi]);
    }
}

/*
和I类似，但是注意在nums[mid] == nums[hi]的时候不能直接轻易移动hi和lo，
因为有重复，只能把hi --。
*/