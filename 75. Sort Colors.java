public class Solution {
    public void sortColors(int[] nums) {
        if(nums == null || nums.length <= 1)    return;
        int left = 0;
        int right = nums.length - 1;
        int index = 0;
        
        while(index <= right) {
            if(nums[index] == 0) {
                swap(left, index, nums);
                index ++;
                left ++;
            } else if(nums[index] == 2) {
                swap(index, right, nums);
                right --;
            } else {
                index ++;
            }
        }
    } 
    
    private void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

/*
经典的荷兰旗问题，需要注意不同情况下，三个指针变化的情况。
只有在和 end 换元素时，i 指针的位置是不动的，因为下一轮还要看一下换过来的元素是不是 < key 要放到左边。
而与start指针交换时，需要将start和i都 ＋＋，因为此值要么为0，要么为1，都不需要再进行考虑。
*/