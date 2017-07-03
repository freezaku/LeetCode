public class Solution {
    public int triangleNumber(int[] nums) {
        int count = 0;
        int n = nums.length;
        Arrays.sort(nums);
        
        for(int i = 0; i < n; i ++) {
            int left = 0;
            int right = i - 1;
            while(left < right) {
                if(nums[left] + nums[right] > nums[i]) {
                    count += right - left;
                    right --;
                } else {
                    left ++;
                }
            }
        }
        
        return count;
    }
}

/*
固定的i是最大元素，
left从0开始，right从i - 1开始，
然后固定right，
当nums[left] + nums[right] > nums[i]的时候，所有该left到比right小的元素均符合要求，然后将right--重新固定，
否则，直接将left ++
*/