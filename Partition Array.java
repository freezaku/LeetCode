Given an array nums of integers and an int k, partition the array (i.e move the elements in "nums") such that:

All elements < k are moved to the left
All elements >= k are moved to the right
Return the partitioning index, i.e the first index i nums[i] >= k.

 Notice

You should do really partition in array nums instead of just counting the numbers of integers smaller than k.

If all elements in nums are smaller than k, then return nums.length

Have you met this question in a real interview? Yes
Example
If nums = [3,2,2,1] and k=2, a valid answer is 1.

public class Solution {
    /*
     * @param nums: The integer array you should partition
     * @param k: An integer
     * @return: The index after partition
     */
    public int partitionArray(int[] nums, int k) {
        // write your code here
        if(nums == null || nums.length == 0)    return 0;
        
        int n = nums.length;
        int left = 0;
        int right = n - 1;
        int index = 0;
        while(index <= right) {
            if(nums[index] == k) {
                index ++;
            } else if(nums[index] < k) {
                swap(nums, left, index);
                index ++;
                left ++;
            } else {
                swap(nums, index, right);
                right --;
            }
        }
        
        return left;
    }
    
    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}

/*
荷兰旗问题
*/