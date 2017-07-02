Find the kth smallest numbers in an unsorted integer array.

Have you met this question in a real interview? Yes
Example
Given [3, 4, 1, 2, 5], k = 3, the 3rd smallest numbers are [1, 2, 3].

class Solution {
    /*
     * @param k an integer
     * @param nums an integer array
     * @return kth smallest element
     */
    public int kthSmallest(int k, int[] nums) {
        // write your code here
        return quickSelect(0, nums.length - 1, k - 1, nums);
    }
    
    private int quickSelect(int start, int end, int target, int[] nums) {
        if(start == end)    return nums[start];
        int left = start;
        int right = end;
        int pivot = nums[(start + end) / 2];
        
        while(left <= right) {
            while(left <= right && nums[left] < pivot)    left ++;
            while(left <= right && nums[right] > pivot)   right --;
            if(left <= right) {
                swap(nums, left, right);
                left ++;
                right --;
            }
        }
        
        if(target <= right && start <= right) {
            return quickSelect(start, right, target, nums);
        } else if(target >= left && left <= end) {
            return quickSelect(left, end, target, nums);
        } else {
            return nums[target];
        }
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
};

/*
配合215. Kth Largest Element in an Array来看，
利用quick select的典型
*/

public class Solution {
    public int findKthLargest(int[] nums, int k) {
        k = nums.length - k;
        int start = 0;
        int end = nums.length - 1;
        while(start < end) {
            int pivot = partition(nums, start, end);
            if(pivot == k) {
                return nums[pivot];
            } else if(pivot > k) {
                end = pivot - 1;
            } else {
                start = pivot + 1;
            }
        }
        return nums[k];
    }
    private int partition(int[] nums, int start, int end) {
        int left = start;
        int right = end;
        int pivot = start;
        while(left <= right) {
            while(left <= right && nums[left] <= nums[pivot])    left ++;
            while(left <= right && nums[right] >= nums[pivot])   right --;
            if(left <= right) {
                swap(nums, left, right);
            }
        }
        swap(nums, start, right);
        return right;
    }
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}