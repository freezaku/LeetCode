class Solution {
    int m, n;
    public void solve(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return;
        }
        m = board.length;
        n = board[0].length;
        
        for (int i=0; i < m; i++) {
            if (board[i][0] == 'O') {
                dfs(board, i, 0);
            }
            if (board[i][n-1] == 'O') {
                dfs(board, i, n-1);
            }
        }
        
        for (int i=0; i < n; i++) {
            if (board[0][i] == 'O') {
                dfs(board, 0, i);
            }
            if (board[m-1][i] == 'O') {
                dfs(board, m-1, i);
            }
        }
        
        for (int i=0; i < m; i++) {
            for (int j=0; j < n; j++) {
                if (board[i][j] == 'S') {
                    board[i][j] = 'O';
                } else {
                    board[i][j] = 'X';
                }
            }
        }
    }
    
    private void dfs(char[][] board, int x, int y) {
        if (x<0||y<0||x >= m|| y >= n) {
            return;
        }
        if (board[x][y] != 'O') {
            return;
        }
        board[x][y] = 'S';
        int[] dx = new int[]{0, 0, 1, -1};
        int[] dy = new int[]{1, -1, 0, 0};
        
        for (int i=0; i < 4; i++) {
            int xx = dx[i] + x;
            int yy = dy[i] + y;
            dfs(board, xx, yy);
        }
        
    }
    
}

/*
从四个边界处运用dfs往内寻找，
遇到'O'将其置为'S'，这些被置为'S'的都是与最外圈相邻的，同时限定dfs的搜索范围不包括最外圈，
最后再次遍历board，将所有置为'S'的变成'O'
*/
