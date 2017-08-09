public class Solution {
    public void nextPermutation(int[] nums) {
        if(nums == null || nums.length <= 1)    return;
        
        int lo = nums.length - 2;
        while(lo >= 0 && nums[lo + 1] <= nums[lo]) {
            lo --;
        }
        
        if(lo < 0) {
            reverse(0, nums.length - 1, nums);
            return;
        }
        
        int val = nums[lo];
        int hi = nums.length - 1;
        while(hi >= lo) {
            if(nums[hi] > val) {
                break;
            }
            hi --;
        }
        
        swap(lo, hi, nums);
        reverse(lo + 1, nums.length - 1, nums);
    }
    
    private void swap(int lo, int hi, int[] nums) {
        int temp = nums[lo];
        nums[lo] = nums[hi];
        nums[hi] = temp;
    }
    
    private void reverse(int lo, int hi, int[] nums) {
        while(lo < hi) {
            int temp = nums[lo];
            nums[lo] = nums[hi];
            nums[hi] = temp;
            lo ++;
            hi --;
        }
    }
    
}

/*
属于找规律的一种。
从倒数第二个开始找，找nums[i] < nums[i + 1]，找到第一个下落的数。
从该数往后找，找到nums[j] <= nums[i]为止，将j--，则其为大于nums[i]的最小数，
将这两个数先swap，再将i之后的数全部reverse。
*/