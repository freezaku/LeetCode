Find K-th largest element in an array.

 Notice

You can swap elements in the array

Have you met this question in a real interview? Yes
Example
In array [9,3,2,4,8], the 3rd largest element is 4.

In array [1,2,3,4,5], the 1st largest element is 5, 2nd largest element is 4, 3rd largest element is 3 and etc.

public class Solution {
    /*
     * @param : An integer
     * @param : An array
     * @return: the Kth largest element
     */
    public int kthLargestElement(int n, int[] nums) {
        // write your code here
        return quickSelect(0, nums.length - 1, n - 1, nums);
    }
    
    private int quickSelect(int start, int end, int target, int[] nums) {
        if(start == end)    return nums[start];
        int left = start;
        int right = end;
        int pivot = nums[(start + end) / 2];
        while(left <= right) {
            while(left <= right && nums[left] > pivot)  left ++;
            while(left <= right && nums[right] < pivot) right --;
            if(left <= right) {
                swap(nums, left, right);
                left ++;
                right --;
            }
        }
        
        if(target <= right && start <= right) {
            return quickSelect(start, right, target, nums);
        } else if(target >= left && end >= left) {
            return quickSelect(left, end, target, nums);
        } else {
            return nums[target];
        }
    }
    
    private void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
};

/*
同样利用quickselect来解决，
但是这次需要注意将pivot的前面存储大的元素，后面存储小的元素
*/