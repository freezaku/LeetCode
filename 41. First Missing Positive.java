public class Solution {
    public int firstMissingPositive(int[] nums) {
        if(nums == null || nums.length == 0)    return 1;
        
        int n = nums.length;
        int i = 0;
        while(i < n) {
            if(nums[i] == i + 1 || nums[i] > n || nums[i] <= 0) {
                i ++;
            } else {
                if(nums[nums[i] - 1] != nums[i]) {
                    swap(i, nums[i] - 1, nums);
                } else {
                    i ++;
                }   
            }
        }
        
        i = 0;
        while(i < n) {
            if(nums[i] == i + 1) {
                i ++;
            } else {
                break;
            }
        }
        
        return i + 1;
    }
    
    private void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
}