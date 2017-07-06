public class Solution {
    public int findPairs(int[] nums, int k) {
        if(k < 0)   return 0;
        
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        
        for(int num: nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        for(Map.Entry<Integer, Integer> entry: map.entrySet()) {
            if(k == 0) {
                if(entry.getValue() > 1)    count ++;    
            } else {
                if(map.containsKey(entry.getKey() + k))   count ++;
            }
        }
        return count;
    }
}

/*
这题需要改变的思路就是不需要一次找num + k 和 num - k两个target的值，
而是先将nums中的元素全部计数并放入map之后，
再遍历这个map，根据k是否为0去寻找target的值
*/