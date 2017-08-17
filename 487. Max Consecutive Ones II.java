public class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        if(nums == null || nums.length == 0)    return 0;
        
        int count = 0;
        int max = 0;
        for(int lo = 0, hi = 0; hi < nums.length; hi ++) {
            if(nums[hi] == 0) {
                count ++;
            }
            while(count > 1) {
                if(nums[lo] == 0) {
                    count --;
                }
                lo ++;
            } 
            max = Math.max(max, hi - lo + 1);
        }
        
        return max;
    }
}

/*
利用一个sliding window解决，可以对任意数目的可空缺0进行处理。
利用lo和hi构造一个sliding window，hi按for循环递增，
当其中0的数目超过范围的时候，将lo递增直到回到限定范围内。
*/

public int findMaxConsecutiveOnes(int[] nums) {                 
    int max = 0, k = 1; // flip at most k zero
    Queue<Integer> zeroIndex = new LinkedList<>(); 
    for (int lo = 0, hi = 0; hi < nums.length; h++) {
        if (nums[hi] == 0)
            zeroIndex.offer(hi);
        if (zeroIndex.size() > k)                                   
            lo = zeroIndex.poll() + 1;
        max = Math.max(max, h - l + 1);
    }
    return max;                     
}

/*
对于infinite data stream，使用queue来存储0出现的坐标更加合适。
*/