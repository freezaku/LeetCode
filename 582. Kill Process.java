public class Solution {
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        
        for(int i = 0; i < ppid.size(); i ++) {
            int parent = ppid.get(i);
            int child = pid.get(i);
            if(!map.containsKey(parent)) {
                List<Integer> list = new ArrayList<>();
                map.put(parent, list);
            }
            map.get(parent).add(child);
        }
        
        List<Integer> res = new ArrayList<>();
        dfs(map, kill, res);
        return res;
    }
    
    private void dfs(Map<Integer, List<Integer>> map, int kill, List<Integer> res) {
        res.add(kill);
        
        if(!map.containsKey(kill)) {
            return;
        }
        
        List<Integer> list = map.get(kill);
        for(int pid: list) {
            dfs(map, pid, res);
        }
    }
}

/*
简单题。
将parent和其child存入map中，然后使用DFS便利加入res即可。
*/