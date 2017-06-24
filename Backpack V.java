Given n items with size nums[i] which an integer array and all positive numbers. An integer target denotes the size of a backpack. Find the number of possible fill the backpack.

Each item may only be used once

Have you met this question in a real interview? Yes
Example
Given candidate items [1,2,3,3,7] and target 7,

A solution set is: 
[7]
[1, 3, 3]
return 2

public class Solution {
    /**
     * @param nums an integer array and all positive numbers
     * @param target an integer
     * @return an integer
     */
    public int backPackV(int[] nums, int target) {
        // Write your code here
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for(int i = 0; i < nums.length; i ++) {
            for(int j = target; j >= nums[i]; j --) {
                dp[j] += dp[j - nums[i]];
            }
        }
        
        return dp[target];
    }
}

/*
这题和IV几乎一样, 不同的是元素只能取一次，因此内层遍历j的时候从大到小遍历（解释见III）。dp[j]表示背包容量为j时，对前i件物品且每件物品只能取一次的情况下能取的最大值。
dp[0]解释一下：就是将容量为0的背包装满的方法，显然只有一种，就是什么都不装。
*/