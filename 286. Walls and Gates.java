class Solution {
    public void wallsAndGates(int[][] rooms) {
        if(rooms == null || rooms.length == 0 || rooms[0].length == 0)  return;
        
        int m = rooms.length;
        int n = rooms[0].length;
        
        Queue<int[]> queue = new LinkedList<>();
        for(int i = 0; i < m; i ++) {
            for(int j = 0; j < n; j ++) {
                if(rooms[i][j] == 0) {
                    queue.add(new int[]{i, j});
                }
            }
        }
        
        int distance = 1;
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i ++) {
                int[] cur = queue.poll();
                for(int j = 0; j < 4; j ++) {
                    int[] next = {cur[0] + dx[j], cur[1] + dy[j]};
                    if(next[0] < 0 || next[0] >= m || next[1] < 0 || next[1] >= n || rooms[next[0]][next[1]] != Integer.MAX_VALUE)    continue;
                    rooms[next[0]][next[1]] = distance;
                    queue.add(next);   
                }
            }
            distance ++;
        }
    }
}

/*
BFS做法，将gate先放入queue中，
再逐个poll，更新周边rooms[i][j]为MAX_VALUE的点
*/

class Solution {
    public void wallsAndGates(int[][] rooms) {
        if(rooms == null || rooms.length == 0 || rooms[0].length == 0)  return;
        
        int m = rooms.length;
        int n = rooms[0].length;
        for(int i = 0; i < m; i ++) {
            for(int j = 0; j < n; j ++) {
                if(rooms[i][j] == 0) {
                    helper(rooms, i, j, 0);   
                }
            }
        }
    }
    
    private void helper(int[][] rooms, int x, int y, int distance) {
        int m = rooms.length;
        int n = rooms[0].length;
        
        if(x < 0 || x >= m || y < 0 || y >= n || rooms[x][y] < distance)   return;
        
        rooms[x][y] = distance;
        
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        
        for(int i = 0; i < 4; i ++) {
            int xx = x + dx[i];
            int yy = y + dy[i];
            helper(rooms, xx, yy, distance + 1);
        }
    }
}

/*
DFS做法，当改点为gate的时候，进入helper函数。
当当前rooms[i][j] < distance的时候，才进行更新，这样就剔除了wall和已经更新而distance更小的情况
*/