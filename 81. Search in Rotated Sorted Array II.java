public class Solution {
    public boolean search(int[] nums, int target) {
        if(nums == null || nums.length == 0)    return false;
        
        int lo = 0;
        int hi = nums.length - 1;
        while(lo + 1 < hi) {
            int mid = lo + (hi - lo) / 2;
            if(nums[mid] == target) {
                return true;
            }
            if(nums[mid] > nums[lo]) {
                if(target <= nums[mid] && target >= nums[lo]) {
                    hi = mid;
                } else {
                    lo = mid;
                }
            } else if(nums[mid] < nums[lo]) {
                if(target >= nums[mid] && target <= nums[hi]) {
                    lo = mid;
                } else {
                    hi = mid;
                }
            } else {
                lo ++;
            }
        }
        
        if(nums[lo] == target || nums[hi] == target)    return true;
        return false;
    }
}

/*
与第一题属于相同版本，要牢记得出mid之后，
将mid与low，high的值进行比较，再进一步缩小判断范围，将target与mid和low或者high的值进行比较求解。

对于重复的特殊情况，如1111115, which is rotated to 1151111.

我们无法直接解决，只能将low＋＋然后继续带入循环，worst cast o(n)。
*/