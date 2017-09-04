class Solution {
    public void moveZeroes(int[] nums) {
        if(nums == null || nums.length == 0)    return;
        
        int index = 0;
        for(int i = 0; i < nums.length; i ++) {
            if(nums[i] != 0) {
                swap(nums, index, i);
                index ++;
            }
        }
    }
    
    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}