class Solution {
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        for(int i = 0; i < m; i ++) {
            for(int j = 0; j < n; j ++) {
                if(grid[i][j] == '0')   continue;
                count ++;
                helper(grid, i, j);
            }
        }
        
        return count;
    }
    
    private void helper(char[][] grid, int x, int y) {
        int m = grid.length;
        int n = grid[0].length;
        if(x < 0 || x >= m || y < 0 || y >= n || grid[x][y] == '0')   return;
        
        grid[x][y] = '0';
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        for(int i = 0; i < 4; i ++) {
            int xx = x + dx[i];
            int yy = y + dy[i];
            helper(grid, xx, yy);
        }
    }
}

/*
简单的BFS + Recursion解决
*/