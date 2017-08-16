public class Solution {
    public int longestConsecutive(int[] nums) {
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int num: nums) {
            if(map.containsKey(num))    continue;
            int left = map.containsKey(num - 1) ? map.get(num - 1) : 0;
            int right = map.containsKey(num + 1) ? map.get(num + 1) : 0;
            int count = left + right + 1;
            map.put(num, count);
            map.put(num - left, count);
            map.put(num + right, count);
            res = Math.max(res, count);
        }
        
        return res;
    }
}

/*
利用map存储当前的num和当前的num所拥有的连续序列的长度，
遍历nums，
当map中不含有num的时候，
left为从map中可以获取的num - 1的长度，
right为从map中可以获取的num + 1的长度，
当num -1或num + 1不存在的时候，left或right为0；
此时置sum为left + right + 1，表示通过num将左右连接在了一起，
并且更新res；
同时更新num - left和num + right的value。
*/