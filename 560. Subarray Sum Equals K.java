public class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int res = 0;
        map.put(0, 1);
        for(int i = 0; i < nums.length; i ++) {
            sum += nums[i];
            if(map.containsKey(sum - k)) {
                res += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return res;
    }
}

/*
跟subarray sum略有不同，
这题需要的是求出subarray为k的所有subarray的个数，
因此不再关心坐标，在map中的value为该sum出现的次数，
每次遇到sum - k存在的情况，就将res中加入该sum - k出现的次数
*/