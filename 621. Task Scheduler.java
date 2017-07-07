public class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> map = new HashMap<>();
        for(char task: tasks) {
            map.put(task, map.getOrDefault(task, 0) + 1);
        }
        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>(
            (a, b) -> (a.getValue() != b.getValue()) ? b.getValue() - a.getValue() : a.getKey() - b.getKey()
        );
        
        pq.addAll(map.entrySet());
        
        int count = 0;
        
        while(!pq.isEmpty()) {
            int k = n + 1;
            List<Map.Entry<Character, Integer>> tempList = new ArrayList<>();
            
            while(k > 0 && !pq.isEmpty()) {
                Map.Entry<Character, Integer> entry = pq.poll();
                entry.setValue(entry.getValue()  - 1);
                tempList.add(entry);
                k --;
                count ++;
            }
            
            for(Map.Entry<Character, Integer> e: tempList) {
                if(e.getValue() > 0)    pq.add(e);
            }
            
            if(pq.isEmpty())    break;
            
            if(k > 0) {
                count += k;
            }
        }
        
        return count;
    }
}

/*
基本思路明白，但是对应的数据结构没有想到，利用pq存储map的entry来解决，
首先利用map去计数，然后构造一个priorityqueue，按照将序排列，
将map的entryset全部放入pq中，
task的顺序，需要将出现次数最多的task最优先处理，在两个task中填充足够多的其他的task，若不够则用idle填充，
因此利用templist记录从pq中弹出的entry的value - 1之后的entry，这表明用去的task的数目减少1，
当k > 0的且pq不为empty的时候，不断k --， count ++,
然后将value仍然  > 0的entry放入pq中，
若k > 0，说明n这个条件没有满足，需要再放入k个idle的interval，

需要注意的是，当pq为empty的时候直接break，这表明到了最后一个需要处理的task，没有必要再增加idle了
*/