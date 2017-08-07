public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) { 
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null || nums.length <= 3)    return res;
        
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 3; i ++) {
            if(i > 0 && nums[i] == nums[i - 1]) continue;
            for(int j = nums.length - 1; j > i + 2; j --) {
                if(j < nums.length - 1 && nums[j] == nums[j + 1])   continue;
                int m = i + 1;
                int n = j - 1;
                while(m < n) {
                    int sum = nums[i] + nums[m] + nums[n] + nums[j];
                    if(sum == target) {
                        res.add(Arrays.asList(nums[i], nums[m], nums[n], nums[j]));
                        m ++;
                        n --;
                        while(m < n && nums[m] == nums[m - 1])  m ++;
                        while(m < n && nums[n] == nums[n + 1])  n --;
                    } else if(sum > target) {
                        n --;
                    } else {
                        m ++;
                    }
                }
            }
        }
        
        return res;
    }
}

/*
和3sum的思路相同，但是这次要使用4个pointer。
在每个pointer的那一轮都要注意去重，防止list内放入两个相同的答案。
同时注意提前判断不可能的情况，如4 * nums[i] > target, 则直接break；
若 4 * nums[j] < target，也直接break；
*/