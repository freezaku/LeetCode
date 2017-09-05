class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        if(nums == null)    return 0;
        
        int n = nums.length;
        int[] sums = new int[n + 1];
        sums[0] = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);
        for(int i = 1; i <= n; i ++) {
            sums[i] = sums[i - 1] + nums[i - 1];
            map.put(sums[i], Math.max(map.getOrDefault(sums[i], 0), i));
        }
        
        int max = 0;
        for(int i = 0; i <= n; i ++) {
            int target = sums[i] + k;
            if(map.containsKey(target)) {
                max = Math.max(max, map.get(target) - i);
            }
        }
        
        return max;
    }
}

/*
自己写的粗糙做法。
重新构造sums数组，需要进行两次遍历。
*/

public class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        if(nums == null || nums.length == 0)    return 0;

        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int max = 0;

        for(int i = 0; i < nums.length; i ++) {
            sum += nums[i];
            if(sum == k)    max = i + 1;
            if(map.containsKey(sum - k)) {
                max = Math.max(max, i - map.get(sum - k));
            }
            if(!map.containsKey(sum)) {
                map.put(sum, i);
            }
        }

        return max;
    }
}


class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        if(nums == null)    return 0;
        
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);
        int max = 0;
        int sum = 0;
        
        for(int i = 0; i < n; i ++) {
            sum += nums[i];
            if(map.containsKey(sum - k)) {
                max = Math.max(max, i - map.get(sum - k) + 1);
            }
            if(!map.containsKey(sum)) {
                map.put(sum, i + 1);
            }
        }
        
        return max;
    }
}
/*
更加合适的做法，一次遍历即可
*/