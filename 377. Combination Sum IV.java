class Solution {
    public int combinationSum4(int[] nums, int target) {
        if(nums == null || nums.length == 0)    return 0;
        
        int[] dp = new int[target + 1];
        dp[0] = 1;
        
        for(int i = 1; i <= target; i ++) {
            for(int j = 0; j < nums.length; j ++) {
                if(i >= nums[j]) {
                    dp[i] += dp[i - nums[j]];
                }
            }
        }
        
        return dp[target];
    }
}

/*
背包问题的变型，用无限次数的item凑成一定value
*/

class Solution {
    public int combinationSum4(int[] nums, int target) {
        return helper(0, target, nums, new HashMap<Integer, Integer>());
    }
    
    private int helper(int curSum, int target, int[] nums, Map<Integer, Integer> map) {
        if(curSum > target) return 0;
        if(curSum == target)    return 1;
        if(map.containsKey(curSum)) return map.get(curSum);
        
        int count = 0;
        for(int i = 0; i < nums.length; i ++) {
            count += helper(curSum + nums[i], target, nums, map);
        }
        
        map.put(curSum, count);
        return count;
    }
}

/*
DFS + RECURSION + MEMORIZE SEARCH
*/

