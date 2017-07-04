public class Solution {
    public void solve(char[][] board) {
        if(board == null || board.length == 0 || board[0].length == 0)  return;
        int m = board.length;
        int n = board[0].length;
        
        for(int i = 0; i < n; i ++) {
            if(board[0][i] == 'O') {
                dfs(board, 0, i);
            }
            if(board[m - 1][i] == 'O') {
                dfs(board, m - 1, i);
            }
        }
        for(int i = 1; i < m - 1; i ++) {
            if(board[i][0] == 'O') {
                dfs(board, i, 0);
            }
            if(board[i][n - 1] == 'O') {
                dfs(board, i, n - 1);
            }
        }
                
        for(int i = 0; i < m; i ++) {
            for(int j = 0; j < n; j ++) {
                if(board[i][j] == 'S') {
                    board[i][j] = 'O';
                } else {
                    board[i][j] = 'X';
                }
            }
        }
    }
    
    private void dfs(char[][] board, int row, int col) {
        int m = board.length;
        int n = board[0].length;
        if(board[row][col] != 'O')  return;
        board[row][col] = 'S';
        
        if(row - 2 >= 0)    dfs(board, row - 1, col);
        if(row + 2 < m)     dfs(board, row + 1, col);
        if(col - 2 >= 0)    dfs(board, row, col - 1);
        if(col + 2 < n)     dfs(board, row, col + 1);
    }
}

/*
从四个边界处运用dfs往内寻找，
遇到'O'将其置为'S'，这些被置为'S'的都是与最外圈相邻的，同时限定dfs的搜索范围不包括最外圈，
最后再次遍历board，将所有置为'S'的变成'O'
*/