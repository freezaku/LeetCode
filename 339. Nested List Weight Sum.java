public class Solution {
    public List<String> findItinerary(String[][] tickets) {
        Map<String, PriorityQueue<String>> map = new HashMap<>();
        
        for(String[] ticket: tickets) {
            String from = ticket[0];
            String to = ticket[1];
            if(!map.containsKey(from)) {
                PriorityQueue<String> pq = new PriorityQueue<>();
                map.put(from, pq);
            }
            map.get(from).add(to);
        }
        
        LinkedList<String> res = new LinkedList<>();
        dfs(res, map, "JFK");
        
        return res;
    }
    
    private void dfs(LinkedList<String> res, Map<String, PriorityQueue<String>> map, String str) {
        while(map.containsKey(str) && !map.get(str).isEmpty()) {
            String next = map.get(str).poll();
            dfs(res, map, next);
        }
        res.addFirst(str);
    }
}

/*
想法很简单，但是有几点需要注意：
1. 利用priorityqueue来存储同一个from下的不同to，免于利用sort进行排序
2. dfs中，因为同一个from可能有多个to，所以利用while循环来不断poll出pq中的to，进行dfs
3. 利用linkedlist来进行存储，方便在first位置加上
*/