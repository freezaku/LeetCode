public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        if(nums == null || nums.length < 3)  return 0;
        
        Arrays.sort(nums);
        int res = nums[0] + nums[1] + nums[2];
        for(int i = 0; i < nums.length - 2; i ++) {
            int j = i + 1;
            int k = nums.length - 1;
            while(j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if(sum == target) {
                    res = sum;
                    return res;
                } else if(sum > target) {
                    k --;
                } else {
                    j ++;
                }
                if(Math.abs(sum - target) < Math.abs(res - target)) {
                    res = sum;
                }
            }
        }
        
        return res;
    }
}

/*
简单题复习，和3sum相同
*/