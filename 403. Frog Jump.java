public class Solution {
    public boolean canCross(int[] stones) {
        if(stones.length == 0)   return true;
        Map<Integer, Set<Integer>> map = new HashMap<>();
        int goal = stones[stones.length - 1];
        
        map.put(0, new HashSet<Integer>());
        map.get(0).add(1);
        for(int i = 1; i < stones.length; i ++) {
            map.put(stones[i], new HashSet<Integer>());
        }
        
        for(int i = 0; i < stones.length; i ++) {
            int pos = stones[i];
            for(int step: map.get(pos)) {
                int reach = step + pos;
                if(reach == goal) {
                    return true;
                }
                Set<Integer> set = map.get(reach);
                if(set != null) {
                    if(step - 1 > 0) {
                        set.add(step - 1);
                    }
                    set.add(step);
                    set.add(step + 1);
                }
            }   
        }
        
        return false;
    }
}

/*
使用map，key代表各个stone所在的位置(是坐标而不是index)，value代表该stone能够走的step的一个set，
我们的目标是观察有没有stone加上其step之后，能够到达我们的goal也就是最后一个stone的位置，
初始化map，将第一个stone和其规定的step 1存储进去，并且初始化其他stone的set；
遍历stones数组，每次获取该stone的step的set，然后相加获得reach，
若reach为goal，说明到达了最后一个stone，直接返回true，
否则，将可能的step，加入到reach的step的set中。
这在某种程度上也能算是一种DFS的做法.
*/