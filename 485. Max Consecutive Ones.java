public class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        if(nums == null || nums.length == 0)    return 0;
        
        int count = nums[0] == 0 ? 0 : 1;
        int max = count;
        for(int i = 1; i < nums.length; i ++) {
            if(nums[i] == 0) {
                count = 0;
            } else {
                count += 1;
            }
            max = Math.max(max, count);
        }
        
        return max;
    }
}

/*
简单题重做
*/