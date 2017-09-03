class Solution {
    public int findKthLargest(int[] nums, int k) {
        k = nums.length - k;
        int lo = 0;
        int hi = nums.length - 1;
        
        while(lo < hi) {
            int pivot = partition(nums, lo, hi);
            if(pivot == k) {
                return nums[pivot];
            } else if(pivot < k) {
                lo = pivot + 1;
            } else {
                hi = pivot - 1;
            }
        }
        
        return nums[k];
    }
    
    private int partition(int[] nums, int lo, int hi) {
        int left = lo;
        int right = hi;
        int pivot = lo;
        
        while(left <= right) {
            while(left <= right && nums[left] <= nums[pivot])    left ++;
            while(left <= right && nums[right] >= nums[pivot])   right --;
            if(left <= right) {
                swap(nums, left, right);
            }
        }
        
        swap(nums, lo, right);
        return right;
    }
    
    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}

/*
quick sort，注意。
*/