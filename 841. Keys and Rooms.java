1. dfs

class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        if (rooms == null || rooms.size() == 0) {
            return true;
        }
        Set<Integer> visited = new HashSet<>();
        enter(rooms, 0, visited);
        return visited.size() == rooms.size();
    }
    private void enter(List<List<Integer>> rooms, int cur, Set<Integer> visited) {
        if (visited.contains(cur)) {
            return;
        }
        visited.add(cur);
        // keys不能是一个全局的set，存所有的key，这样的话，一边遍历，某层的dfs一边往里加key，会出concurrency的问题
        // keys也不需要是一个全局的set，因为如果visit之后，visited会记录这个int
        List<Integer> keys = rooms.get(cur);
        for (Integer key : keys) {
            if (!visited.contains(key)) {
                enter(rooms, key, visited);
            }
        }
        
    }
}


2. bfs
class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        if (rooms == null || rooms.size() == 0) {
            return true;
        }
        Set<Integer> visited = new HashSet<>();
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        visited.add(0);
        
        while (!stack.isEmpty()) {
            Integer next = stack.pop();
            for (Integer key : rooms.get(next)) {
                if (!visited.contains(key)) {
                    stack.push(key);
                    visited.add(key);
                }
                if (visited.size() == rooms.size()) {
                    return true;
                }
            } 
            
        }
        return visited.size() == rooms.size();
    }
}