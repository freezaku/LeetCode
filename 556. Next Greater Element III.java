public class Solution {
    public int nextGreaterElement(int n) {
        char[] nums = String.valueOf(n).toCharArray();
        int i = nums.length - 1;
        while(i >= 1 && nums[i - 1] >= nums[i]) i --;
        if(i == 0)  return -1;
        int j = i + 1;
        int min = i;
        int x = nums[i - 1];
        for(j = i + 1; j < nums.length; j ++) {
            if(nums[j] > x && nums[j] <= nums[min]) {
                min = j;
            }
        }
        char temp = nums[i - 1];
        nums[i - 1] = nums[min];
        nums[min] = temp;
        
        Arrays.sort(nums, i, nums.length);
        long val = Long.parseLong(new String(nums));
        return (val <= Integer.MAX_VALUE) ? (int)val : -1;
    }
}

/*
类似与next permutation，找比该数大的最小数。
将n转化为string，从右往左遍历找第一个相邻下降的坐标i，说明可以在这个地方做文章，使这个数变大。
从该位置往右寻找，找比这个数大的最小数，然后进行swap，这样就完成了把这个数增大的任务，
但是还要保持最小，因此要把这之后的数都sort好。
*/