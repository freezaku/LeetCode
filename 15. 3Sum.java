public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null || nums.length <= 2)    return res;
        
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 2; i ++) {
            if(i == 0 || (i > 0 && nums[i] != nums[i - 1])) {
                int j = i + 1;
                int k = nums.length - 1;

                while(j < k) {
                    int sum = nums[i] + nums[j] + nums[k];
                    if(sum == 0) {
                        res.add(Arrays.asList(nums[i], nums[j], nums[k]));
                        j ++;
                        k --;
                        while(j < k && nums[j] == nums[j - 1])  j ++;
                        while(j < k && nums[k] == nums[k + 1])  k --;
                    } else if(sum < 0) {
                        j ++;
                    } else {
                        k --;
                    }
                }
            }
        }
        
        return res;
    }
}
/*
这题的一个关键就是避免重复，
对于i，j，k都需要进行判断来避免重复，
同时记住这个arrays转化为list的方法，
res.add(Arrays.asList(i, j, k));
*/