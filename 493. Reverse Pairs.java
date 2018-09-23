class Solution {
    int res;
    public int reversePairs(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        res = 0;
        mergesort(nums, 0, nums.length - 1);
        return res;
    }
    private void mergesort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = left + (right - left)/2;
        
        mergesort(nums, left, mid);
        mergesort(nums, mid+1, right);
        int count = 0;
        for (int l=left, r=mid+1; l<=mid;) {
            if (r > right || (long)nums[l] <= 2*(long)nums[r]) {
                l++;
                res+=count;
            } else {
                r++;
                count++;
            }
        }
        Arrays.sort(nums, left, right + 1);
    }
}



/*
mergesort的思想，315同理
*/