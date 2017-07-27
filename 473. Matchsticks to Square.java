public class Solution {
    public boolean makesquare(int[] nums) {
        if(nums == null || nums.length == 0)    return false;
        int sum = 0;
        for(int num: nums) {
            sum += num;
        }
        if(sum % 4 != 0)    return false;
        
        Arrays.sort(nums);
        
        int[] sums = new int[4];
        return dfs(nums, sums, nums.length - 1, sum / 4);
    }
    
    private boolean dfs(int[] nums, int[] sums, int index, int target) {
        if(index < 0) {
            if(sums[0] == target && sums[1] == target && sums[2] == target && sums[3] == target) {
                return true;
            } else {
                return false;
            }
        }
        
        for(int i = 0; i < 4; i ++) {
            if(sums[i] + nums[index] > target)  continue;
            sums[i] += nums[index];
            if(dfs(nums, sums, index - 1, target))  return true;
            sums[i] -= nums[index];
        }
        
        return false;
    }
}

/*
不明白自己的hashmap做法为什么不对，还在疑惑这题。
用一个数组存储四个边的状态，看是否到达target，
然后利用index的变化不断获取新的元素，当index<0的时候，对sums数组进行判断，返回true或false，
在dfs的遍历中，我们遍历sums中的每条边，
我们判断如果加上数组中的当前数字大于target，那么我们跳过，
如果没有，我们就加上这个数字，然后对数组中下一个位置调用递归，
如果返回为真，我们返回true，否则我们再从sums中对应位置将这个数字减去继续循环。

注意要先给数组从大到小的顺序排序，这样大的数字先加，如果超过target了，
就直接跳过了后面的再次调用递归的操作，效率会提高不少
*/