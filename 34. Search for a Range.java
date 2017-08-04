public class Solution {
    public int[] searchRange(int[] nums, int target) {
        if(nums == null || nums.length == 0 || target < nums[0] || target > nums[nums.length - 1])  return new int[]{-1, -1};
        int lo = 0;
        int hi = nums.length - 1;
        int index = -1;
        while(lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if(nums[mid] == target) {
                index = mid;
                break;
            } else if(nums[mid] > target) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        if(index == -1) {
            return new int[]{-1, -1};
        }
        int start = index;
        int end = index;
        while(start >= 0 && nums[start] == target) start --;
        while(end < nums.length && nums[end] == target) end ++;
        return new int[]{start + 1, end - 1};
    }
}

/*
ez, but nothing to say, laji
*/

public class Solution {
    public int[] searchRange(int[] nums, int target) {
        if(nums == null || nums.length == 0)    return new int[]{-1, -1};
        int[] res = new int[2];
        res[0] = findFirst(nums, target);
        res[1] = findLast(nums, target);
        return res;
    }
    private int findFirst(int[] nums, int target) {
        int index = -1;
        int left = 0;
        int right = nums.length - 1;
        while(left <= right) {
            int mid = left  + (right - left) / 2;
            if(nums[mid] >= target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
            if(nums[mid] == target) index = mid;
        }
        return index;
    }
    private int findLast(int[] nums, int target) {
        int index = -1;
        int left = 0;
        int right = nums.length - 1;
        while(left <= right) {
            int mid = left  + (right - left) / 2;
            if(nums[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
            if(nums[mid] == target) index = mid;
        }
        return index;
    } 
}

/*
利用bst来寻找最左边和最右边的两个边界，
*/

public class Solution {
    public int[] searchRange(int[] nums, int target) {
        if(nums == null || nums.length == 0)    return new int[]{-1, -1};
        
        int[] res = new int[2];
        res[0] = findFirst(nums, target);
        res[1] = findLast(nums, target);
        
        return res;
    }
    
    private int findFirst(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length - 1;
        
        while(lo + 1 < hi) {
            int mid = lo + (hi - lo) / 2;
            if(nums[mid] >= target) {
                hi = mid;
            } else {
                lo = mid;
            }
        }
        
        if(nums[lo] == target)  return lo;
        if(nums[hi] == target)  return hi;
        return -1;
    }
    
    private int findLast(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length - 1;
        
        while(lo + 1 < hi) {
            int mid = lo + (hi - lo) / 2;
            if(nums[mid] <= target) {
                lo = mid;
            } else {
                hi = mid;
            }
        }
        
        if(nums[hi] == target)  return hi;
        if(nums[lo] == target)  return lo;
        return -1;
    } 
}
/*
改用lo + 1 < hi的方式来重做Binary search的题目，防止边界条件出现问题
*/