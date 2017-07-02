Given an array of integers, find how many pairs in the array such that their sum is less than or equal to a specific target number. Please return the number of pairs.

Have you met this question in a real interview? Yes
Example
Given nums = [2, 7, 11, 15], target = 24. 
Return 5. 
2 + 7 < 24
2 + 11 < 24
2 + 15 < 24
7 + 11 < 24
7 + 15 < 25



public class Solution {
    /**
     * @param nums an array of integer
     * @param target an integer
     * @return an integer
     */
    public int twoSum5(int[] nums, int target) {
        // Write your code here
        if(nums == null || nums.length < 2)    return 0;
        Arrays.sort(nums);
        int count = 0;
        int left = 0;
        int right = nums.length - 1;
        while(left < right) {
            int sum = nums[left] + nums[right];
            if(sum > target) {
                right --;
            } else {
                count += right - left;
                left ++;
            }
        }
        return count;
    }
}

/*
只想到用最蠢的方法解决，没想到这样的.
直接利用两个pointer，前后计算和，
如满足<=target的条件，则说明这个right到left + 1配合left均满足条件，直接将其加入到count中，同时将left ++,
否则，减小right保持left即可.
*/