public class Solution {
    public boolean isPossible(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, Integer> appendMap = new HashMap<>();
        
        for(int num: nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        for(int num: nums) {

            if(map.get(num) == 0)   continue;
            if(appendMap.getOrDefault(num, 0) > 0) {
                appendMap.put(num, appendMap.get(num) - 1);
                appendMap.put(num + 1, appendMap.getOrDefault(num + 1, 0) + 1);
            } else if(map.getOrDefault(num + 1, 0) > 0 && map.getOrDefault(num + 2, 0) > 0) {
                map.put(num + 1, map.get(num + 1) - 1);
                map.put(num + 2, map.get(num + 2) - 1);
                appendMap.put(num + 3, appendMap.getOrDefault(num + 3, 0) + 1);
            } else {
                return false;
            }
            map.put(num, map.get(num) - 1);
        }
        
        return true;
    }
}

/*
map用来统计数组中出现的数字及其次数，
appendMap用来记录可以加入到已有sequence的的数字及其次数；
然后再次遍历数组，
每次遇到该num在map中为0，直接continue；
当appendMap中的该num的次数大于0的时候，说明其可以加到之前的sequence上面去，
将appendMap的该num次数-1，同时预置num + 1的次数 + 1；
当map中存在num + 1和num + 2的次数大于0的时候，说明可以从num新开一个sequence，
所以将num + 1和num + 2对应次数 - 1，
同时将appendNum中num + 3的预置的次数 + 1，表明该数可以加到这个sequence上面去；
当两种情况都不符合的时候，直接返回false；
*/