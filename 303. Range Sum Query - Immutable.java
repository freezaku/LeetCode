public class NumArray {
    private int[] sums;
    public NumArray(int[] nums) {
        if(nums.length != 0) {
            sums = new int[nums.length];
            sums[0] = nums[0];
            for(int i = 1; i < nums.length; i ++) {
                sums[i] = sums[i - 1] + nums[i];
            }
        }
    }
    
    public int sumRange(int i, int j) {
        if(i == 0) {
            return sums[j];
        } else {
            return sums[j] - sums[i - 1];
        }
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */

/*
需要注意当i为0的时候，直接返回sums[j]
*/