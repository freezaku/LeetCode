class Solution {
    private int[] nums;
    private Random rand;
    public Solution(int[] nums) {
        this.nums = nums;
        rand = new Random();
    }
    
    public int pick(int target) {
        int count = 0;
        int res = -1;
        
        for(int i = 0; i < nums.length; i ++) {
            if(nums[i] == target) {
                count ++;
                if(rand.nextInt(count) == 0) {
                    res = i;
                }
            }
        }
        
        return res;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */

/*
蓄水池抽样，有比较模板化的解决方式和套路。
*/