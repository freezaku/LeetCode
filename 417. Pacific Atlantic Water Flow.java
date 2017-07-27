public class Solution {
    public List<int[]> pacificAtlantic(int[][] matrix) {
        List<int[]> res = new ArrayList<>();
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0)   return res;
        int m = matrix.length;
        int n = matrix[0].length;
        
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];
        
        for(int i = 0; i < m; i ++) {
            dfs(matrix, pacific, i, 0, Integer.MIN_VALUE);
            dfs(matrix, atlantic, i, n - 1, Integer.MIN_VALUE);
        }
        for(int i = 0; i < n; i ++) {
            dfs(matrix, pacific, 0, i, Integer.MIN_VALUE);
            dfs(matrix, atlantic, m - 1, i, Integer.MIN_VALUE);
        }
        
        for(int i = 0; i < m; i ++) {
            for(int j = 0; j < n; j ++) {
                if(pacific[i][j] && atlantic[i][j]) {
                    res.add(new int[]{i, j});
                }
            }
        }
        
        return res;
    }
    
    int[][] dir = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private void dfs(int[][] matrix, boolean[][] visited, int x, int y, int height) {
        int m = matrix.length;
        int n = matrix[0].length;
        if(x < 0 || x >= m || y < 0 || y >= n || visited[x][y] || matrix[x][y] < height) return;
        
        visited[x][y] = true;
        
        for(int i = 0; i < 4; i ++) {
            int xx = x + dir[i][0];
            int yy = y + dir[i][1];
            dfs(matrix, visited, xx, yy, matrix[x][y]);
        }
    }
}

/*
利用两个boolean数组存储pacific和atlantic的情况，
同时为true的点加入res中.
*/