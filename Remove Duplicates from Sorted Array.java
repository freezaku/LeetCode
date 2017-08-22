public class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        int index = 1;
        for(int i = 1; i < nums.length; i ++) {
            if(nums[i] != nums[i - 1]) {
                nums[index] = nums[i];
                index ++;
            }
        }
        return index;
    }
}

/*
简单题，用基本思路。
维护两个index，一个i用来遍历数组，一个j用来记录长度和存储的位置，
若后一项和前一项相同，则不管跳过，i++；
若不同，则将后一项存入j位置，j++，i++;

这是一种维护动态数组的基本方法。
*/