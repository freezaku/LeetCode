class Solution {
    public String alienOrder(String[] words) {
        Map<Character, Set<Character>> graph = new HashMap<>();
        Map<Character, Integer> inDegree = new HashMap<>();
        
        for(String word: words) {
            for(char chr: word.toCharArray()) {
                graph.put(chr, new HashSet<>());
                inDegree.put(chr, 0);
            }
        }
        
        for(int i = 0; i < words.length - 1; i ++) {
            String word1 = words[i];
            String word2 = words[i + 1];
            for(int j = 0; j < Math.min(word1.length(), word2.length()); j ++) {
                char chr1 = word1.charAt(j);
                char chr2 = word2.charAt(j);
                if(chr1 == chr2)  continue;
                
                Set<Character> set = graph.get(chr1);
                if(!set.contains(chr2)) {
                    set.add(chr2);
                    inDegree.put(chr2, inDegree.get(chr2) + 1);
                }
                break;
            }
        }
        
        Queue<Character> queue = new LinkedList<>();
        for(char key: inDegree.keySet()) {
            if(inDegree.get(key) == 0) {
                queue.add(key);
            }
        }
        
        StringBuilder sb = new StringBuilder();
        int count = 0;
        while(!queue.isEmpty()) {
            char chr = queue.poll();
            count ++;
            sb.append(chr);
            Set<Character> neighbors = graph.get(chr);
            for(char neighbor: neighbors) {
                inDegree.put(neighbor, inDegree.get(neighbor) - 1);
                if(inDegree.get(neighbor) == 0) {
                    queue.add(neighbor);
                }
            }
        }
        
        return (count == inDegree.size() ? sb.toString() : "");
    }
}

/*
topological sort的一个变种问题，有几点需要注意：
1. 因为不知道需要排序的letter的个数，因此无法使用array构造graph和indegree，需要使用map
2. graph的map，value需要使用set
3. 遍历整个words，取出连续的两个word进行比较，同一位置遇到不同的char，需要更新graph和indegree，之后直接break，因为后面的字母不再遵循规律
4. 更新graph和indegree的时候，注意判断chr2是否已经存在于set中，防止indegree的重复 ++
5. 常规利用queue进行topological sort，但是需要维护一个变量count，当count最后的值等于letter总个数的时候，才是合理的graph，否则直接返回""
*/