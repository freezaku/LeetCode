public class Solution {
    public int threeSumSmaller(int[] nums, int target) {
        if(nums == null || nums.length < 3)    return 0;
        
        int res = 0;
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 2; i ++) {
            int j = i + 1;
            int k = nums.length - 1;
            while(j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if(sum < target) {
                    res += (k - j);
                    j ++;
                } else {
                    k --;
                }
            }
        }
        
        return res;
    }
}

/*
简单题复习，
当nums[i] + nums[j] + nums[k] < target的时候，说明如果k从j + 1到 当前的 k都满足 < target的条件，
所以count += k - j
*/